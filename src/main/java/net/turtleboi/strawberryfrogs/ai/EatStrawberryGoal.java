package net.turtleboi.strawberryfrogs.ai;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.turtleboi.strawberryfrogs.block.ModBlocks;
import net.turtleboi.strawberryfrogs.block.StrawberryBushBlock;
import net.turtleboi.strawberryfrogs.entity.StrawberryFrogEntity;
import net.turtleboi.strawberryfrogs.network.ModNetworking;
import net.turtleboi.strawberryfrogs.network.packets.SendParticlesS2C;

import java.util.EnumSet;

public class EatStrawberryGoal extends Goal {
    private final StrawberryFrogEntity frog;
    private BlockPos targetBushPos;

    public EatStrawberryGoal(StrawberryFrogEntity  frog) {
        this.frog = frog;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (frog.getHungerTimer() > 0) {
            return false;
        }

        targetBushPos = findNearbyStrawberryBush();
        return targetBushPos != null;
    }

    @Override
    public boolean canContinueToUse() {
        if (targetBushPos == null) return false;
        double distSq = frog.distanceToSqr(targetBushPos.getX() + 0.5, targetBushPos.getY(), targetBushPos.getZ() + 0.5);
        return distSq > 2.25;
    }

    @Override
    public void start() {
        if (targetBushPos != null) {
            moveToBush();
        }
    }

    @Override
    public void tick() {
        if (targetBushPos != null) {
            double distSq = frog.distanceToSqr(targetBushPos.getX() + 0.5, targetBushPos.getY(), targetBushPos.getZ() + 0.5);
            if (distSq < 4.0) {
                eatStrawberries();
            } else {
                moveToBush();
            }
        }
    }

    @Override
    public void stop() {
        targetBushPos = null;
    }

    private BlockPos findNearbyStrawberryBush() {
        Level level = frog.level();
        BlockPos frogPos = frog.blockPosition();
        RandomSource random = frog.getRandom();
        for (int i = 0; i < 10; i++) {
            BlockPos checkPos = frogPos.offset(random.nextInt(7) - 3, random.nextInt(3) - 1, random.nextInt(7) - 3);
            BlockState state = level.getBlockState(checkPos);
            if (state.is(ModBlocks.STRAWBERRY_BUSH.get()) && state.hasProperty(StrawberryBushBlock.AGE)) {
                int age = state.getValue(StrawberryBushBlock.AGE);
                if (age == 4) {
                    return checkPos;
                }
            }
        }
        return null;
    }

    private void eatStrawberries() {
        Level level = frog.level();
        BlockState state = level.getBlockState(targetBushPos);
        if (state.is(ModBlocks.STRAWBERRY_BUSH.get()) && state.hasProperty(StrawberryBushBlock.AGE)) {
            frog.getLookControl().setLookAt(targetBushPos.getX() + 0.5, targetBushPos.getY() + 0.5, targetBushPos.getZ() + 0.5);
            frog.setPose(Pose.USING_TONGUE);
            frog.tongueAnimationState.start(frog.tickCount);
            int newAge = Math.max(0, state.getValue(StrawberryBushBlock.AGE) - 2);
            level.setBlock(targetBushPos, state.setValue(StrawberryBushBlock.AGE, newAge), 3);
        }

        level.playSound(
                frog,
                frog.getOnPos(),
                SoundEvents.FROG_TONGUE,
                SoundSource.NEUTRAL,
                0.8F + level.random.nextFloat() * 0.4F,
                0.8F + level.random.nextFloat() * 0.4F);
        level.playSound(
                null,
                targetBushPos,
                SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES,
                SoundSource.NEUTRAL,
                0.8F + level.random.nextFloat() * 0.4F,
                0.8F + level.random.nextFloat() * 0.4F);

        if (!level.isClientSide()) {
            for (Player player : level.players()) {
                if (player instanceof ServerPlayer serverPlayer) {
                    ModNetworking.sendToPlayer(new SendParticlesS2C(
                            ParticleTypes.HEART,
                            frog.getX(),
                            frog.getEyeY() + 0.25,
                            frog.getZ(),
                            0.1,
                            0.25,
                            0.1,
                            3,
                            1
                    ), serverPlayer);
                    //System.out.println("Spawning particles on client: " + level.isClientSide());
                }
            }
        }

        frog.addStrawberryEaten();
        frog.resetHungerTimer();
        targetBushPos = null;
        this.stop();
    }

    private void moveToBush() {
        if (targetBushPos != null) {
            double offsetX = (targetBushPos.getX() + 0.5) - frog.getX();
            double offsetZ = (targetBushPos.getZ() + 0.5) - frog.getZ();
            double distance = Math.sqrt(offsetX * offsetX + offsetZ * offsetZ);
            double stopDistance = 1.5 + frog.getRandom().nextDouble() * 0.5;
            double moveX = (offsetX / distance) * (distance - stopDistance);
            double moveZ = (offsetZ / distance) * (distance - stopDistance);
            frog.getNavigation().moveTo(frog.getX() + moveX, frog.getY(), frog.getZ() + moveZ, 1.0);
        }
    }
}
