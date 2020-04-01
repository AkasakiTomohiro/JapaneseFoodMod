package jp.artan.japanesefoodmod.raw_materials.world.seaweed;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenSeaweed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class LaminariaceaeGen extends WorldGenSeaweed {
    public LaminariaceaeGen() {
        super(false, 5);
    }

    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos) {
        int minHeight = parRandom.nextInt(Math.max(60 - 1 - 5 - parBlockPos.getY(), 0)) + this.minTreeHeight;

        // Check if tree fits in world
        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= 60) {
            IBlockState state = parWorld.getBlockState(parBlockPos.up());
            if(state.getBlock() == Blocks.WATER) {
                JapaneseFoodMod.logger.info("##############################");
                JapaneseFoodMod.logger.info("minHeight: " + minHeight);
                for(int i = 0; i < minHeight; i++) {
                    BlockPos blockPos = new BlockPos(parBlockPos.getX(), parBlockPos.getY() + i + 1, parBlockPos.getZ());
                    setBlockAndNotifyAdequately(parWorld, blockPos, blockStateWood);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
