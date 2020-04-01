package jp.artan.japanesefoodmod.common.world.seaweed;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.seaweeds.CustomSeaweedBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class WorldGenSeaweed extends WorldGenAbstractTree {
    protected final int minTreeHeight;
    protected IBlockState blockStateWood;

    public WorldGenSeaweed(final boolean parShouldNotify, final CustomSeaweedBlock log, final int minTreeHeight) {
        super(parShouldNotify);
        this.blockStateWood = log.getDefaultState();
        this.minTreeHeight = minTreeHeight;
    }

    public WorldGenSeaweed(final boolean parShouldNotify, final CustomSeaweedBlock log) {
        this(parShouldNotify, log, 5);
    }

    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos) {
        int minHeight = parRandom.nextInt(Math.max(60 - 1 - 5 - parBlockPos.getY(), 0)) + 5;

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

    @Override
    public boolean isReplaceable(World world, BlockPos pos)
    {
        net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
        JapaneseFoodMod.logger.info("state.getBlock(): " + state.getBlock().getUnlocalizedName());
        return state.getBlock() == Blocks.GRAVEL;
    }
}
