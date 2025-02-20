package net.turtleboi.strawberryfrogs.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.turtleboi.strawberryfrogs.ai.EatStrawberryGoal;
import net.turtleboi.strawberryfrogs.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class StrawberryFrogEntity extends Frog implements PlayerRideable{
    private static final EntityDataAccessor<Integer> STRAWBERRIES_EATEN =
            SynchedEntityData.defineId(StrawberryFrogEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> HUNGER_TIMER =
            SynchedEntityData.defineId(StrawberryFrogEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> JUMP_STRENGTH =
            SynchedEntityData.defineId(StrawberryFrogEntity.class, EntityDataSerializers.FLOAT);


    public StrawberryFrogEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1f);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STRAWBERRIES_EATEN, 0);
        this.entityData.define(HUNGER_TIMER, 600);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    public static boolean canSpawn(EntityType<StrawberryFrogEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random){
        return isNearStrawberryBush(level, pos, 5) && checkAnimalSpawnRules(entityType, level, spawnType, pos, random);
    }

    private static boolean isNearStrawberryBush(ServerLevelAccessor level, BlockPos pos, int radius) {
        for (BlockPos checkPos : BlockPos.betweenClosed(pos.offset(-radius, -radius, -radius), pos.offset(radius, radius, radius))) {
            BlockState state = level.getBlockState(checkPos);
            Block block = state.getBlock();

            if (block == ModBlocks.STRAWBERRY_BUSH.get()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void tick() {
        if (!this.level().isClientSide()) {
            boolean hasEatStrawberryGoal = goalSelector.getAvailableGoals()
                    .stream()
                    .anyMatch(goal -> goal.getGoal() instanceof EatStrawberryGoal);

            if (getHungerTimer() >= 599) {
                if (hasEatStrawberryGoal) {
                    //System.out.println(Component.literal("Hunger timer " + this + " " + this.entityData.get(HUNGER_TIMER)));
                    //System.out.println(Component.literal("Removing EatStrawberryGoal from " + this));
                    goalSelector.removeGoal(new EatStrawberryGoal(this));
                }
                subHungerTimer();
            } else if (getHungerTimer() > 0) {
                //System.out.println(Component.literal("Hunger timer " + this + " " + this.entityData.get(HUNGER_TIMER)));
                subHungerTimer();
            } else if (getHungerTimer() <= 0) {
                if (!hasEatStrawberryGoal) {
                    //System.out.println(Component.literal("Hunger timer " + this + " " + this.entityData.get(HUNGER_TIMER)));
                    //System.out.println(Component.literal("Adding EatStrawberryGoal to " + this));
                    goalSelector.addGoal(1, new EatStrawberryGoal(this));
                }
            }
        }
        super.tick();
    }


    public int getStrawberriesEaten() {
        return this.entityData.get(STRAWBERRIES_EATEN);
    }

    public void addStrawberryEaten() {
        this.entityData.set(STRAWBERRIES_EATEN, getStrawberriesEaten() + 1);
        this.refreshDimensions();
    }

    public int getHungerTimer() {

        return this.entityData.get(HUNGER_TIMER);
    }

    private void subHungerTimer(){
        this.entityData.set(HUNGER_TIMER, getHungerTimer() - 1);
    }

    public void resetHungerTimer(){
        //System.out.println(Component.literal("Resetting hunger timer on " + this));
        this.entityData.set(HUNGER_TIMER, 600);
    }

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        float sizeMultiplier = getSizeMultiplier();
        return new EntityDimensions(
                super.getDimensions(pPose).width * sizeMultiplier,
                super.getDimensions(pPose).height * sizeMultiplier,
                false
        );
    }

    private float getSizeMultiplier() {
        return 1.0F + (getStrawberriesEaten() * 0.25F);
    }

    public float getJumpStrength() {
        return 0.5F + (getStrawberriesEaten() * 0.05F); // Max ~1.0F jump power
    }

    public void updateJumpStrength() {
        this.entityData.set(JUMP_STRENGTH, getJumpStrength());
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        if (!this.level().isClientSide && getStrawberriesEaten() >= 10 && this.canRide(pPlayer) && !pPlayer.isCrouching()) {
            //System.out.println(Component.literal("Player riding " + this));
            setRiding(pPlayer);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(pPlayer, pHand);
    }

    @Override
    public Vec3 getDismountLocationForPassenger(LivingEntity pPassenger) {
        Direction direction = this.getMotionDirection();
        if (direction.getAxis() != Direction.Axis.Y) {
            int[][] offsets = DismountHelper.offsetsForDirection(direction);
            BlockPos blockpos = this.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for (Pose pose : pPassenger.getDismountPoses()) {
                AABB aabb = pPassenger.getLocalBoundsForPose(pose);

                for (int[] offset : offsets) {
                    blockpos$mutableblockpos.set(blockpos.getX() + offset[0], blockpos.getY(), blockpos.getZ() + offset[1]);
                    double d0 = this.level().getBlockFloorHeight(blockpos$mutableblockpos);
                    if (DismountHelper.isBlockFloorValid(d0)) {
                        Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos$mutableblockpos, d0);
                        if (DismountHelper.canDismountTo(this.level(), pPassenger, aabb.move(vec3))) {
                            pPassenger.setPose(pose);
                            return vec3;
                        }
                    }
                }
            }
        }

        return super.getDismountLocationForPassenger(pPassenger);
    }

    private void setRiding(Player pPlayer) {
        pPlayer.setYRot(this.getYRot());
        pPlayer.setXRot(this.getXRot());
        pPlayer.startRiding(this);
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        return ((LivingEntity) this.getFirstPassenger());
    }

    @Override
    public void travel(Vec3 pTravelVector) {
        if(this.isVehicle() && getControllingPassenger() instanceof Player) {
            LivingEntity livingentity = this.getControllingPassenger();
            this.setYRot(livingentity.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(livingentity.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());
            this.yBodyRot = this.getYRot();
            this.yHeadRot = this.yBodyRot;
            float f = livingentity.xxa * 0.5F;
            float f1 = livingentity.zza;

            if (this.isControlledByLocalInstance()) {
                float speed = (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED);

                this.setSpeed(speed/8);
                super.travel(new Vec3(f, pTravelVector.y, f1));
            }
        } else {
            super.travel(pTravelVector);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("StrawberriesEaten", getStrawberriesEaten());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("StrawberriesEaten")) {
            this.entityData.set(STRAWBERRIES_EATEN, tag.getInt("StrawberriesEaten"));
            this.refreshDimensions();
        }
    }
}
