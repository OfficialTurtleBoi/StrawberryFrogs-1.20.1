package net.turtleboi.strawberryfrogs.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.turtleboi.strawberryfrogs.block.ModBlocks;

public class StrawberryFrogEntity extends Frog {
    public StrawberryFrogEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
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
}
