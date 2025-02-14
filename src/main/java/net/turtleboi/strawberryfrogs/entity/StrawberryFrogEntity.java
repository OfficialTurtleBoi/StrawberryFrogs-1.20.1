package net.turtleboi.strawberryfrogs.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.turtleboi.strawberryfrogs.ai.EatStrawberryGoal;
import net.turtleboi.strawberryfrogs.block.ModBlocks;

public class StrawberryFrogEntity extends Frog {
    private static final EntityDataAccessor<Integer> STRAWBERRIES_EATEN =
            SynchedEntityData.defineId(StrawberryFrogEntity.class, EntityDataSerializers.INT);

    private int hungerTimer = 600;
    public StrawberryFrogEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STRAWBERRIES_EATEN, 0);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new EatStrawberryGoal(this));
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

    public int getHungerTimer() {
        return hungerTimer;
    }

    public void resetHungerTimer() {
        hungerTimer = 600;
    }

    @Override
    public void tick() {
        if (!this.level().isClientSide()) {
            if (hungerTimer > 0) {
                hungerTimer--;
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

    @Override
    public EntityDimensions getDimensions(Pose pPose) {
        float sizeMultiplier = getSizeMultiplier();
        return super.getDimensions(pPose).scale(sizeMultiplier);
    }

    private float getSizeMultiplier() {
        int eaten = getStrawberriesEaten();
        return 1.0F + (eaten * 0.3F);
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
