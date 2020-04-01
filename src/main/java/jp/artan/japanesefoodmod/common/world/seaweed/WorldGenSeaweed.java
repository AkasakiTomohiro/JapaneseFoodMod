package jp.artan.japanesefoodmod.common.world.seaweed;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.seaweeds.CustomSeaweedBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public abstract class WorldGenSeaweed extends WorldGenAbstractTree {
    protected final int minTreeHeight;
    protected IBlockState blockStateWood;

    public WorldGenSeaweed(final boolean parShouldNotify, int minTreeHeight) {
        super(parShouldNotify);
        this.minTreeHeight = minTreeHeight;
    }

    public void setBlockStateWood(CustomSeaweedBlock customSeaweedBlock) {
        this.blockStateWood = customSeaweedBlock.getDefaultState();
    }

    public WorldGenSeaweed(final boolean parShouldNotify, final CustomSeaweedBlock log) {
        this(parShouldNotify, 5);
    }

    @Override
    public boolean isReplaceable(World world, BlockPos pos)
    {
        net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
        JapaneseFoodMod.logger.info("state.getBlock(): " + state.getBlock().getUnlocalizedName());
        return state.getBlock() == Blocks.GRAVEL;
    }

    public abstract boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos);
}
