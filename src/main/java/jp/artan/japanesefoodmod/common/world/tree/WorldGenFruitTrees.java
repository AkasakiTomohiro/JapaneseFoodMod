package jp.artan.japanesefoodmod.common.world.tree;

import java.util.Random;

import jp.artan.japanesefoodmod.common.wood.FruitBlock;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.common.wood.FruitLog;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;

public abstract class WorldGenFruitTrees extends WorldGenAbstractTree {
    protected final int minTreeHeight;
    protected IBlockState blockStateWood;
    protected IBlockState blockStateLeaves;
    protected IBlockState blockStateFruit;

    public WorldGenFruitTrees(final boolean parShouldNotify, final FruitLog log, final FruitLeaves leaves,
            final FruitBlock fruitBlock, final int minTreeHeight) {
        super(parShouldNotify);
        this.blockStateWood = log.getDefaultState();
        this.blockStateFruit = fruitBlock.getDefaultState();
        this.blockStateLeaves = leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
        this.minTreeHeight = minTreeHeight;
    }

    public WorldGenFruitTrees(final boolean parShouldNotify, final FruitLog log, final FruitLeaves leaves,
            final FruitBlock fruitBlock) {
        this(parShouldNotify, log, leaves, fruitBlock, 5);
    }

    @Override
    public boolean generate(World parWorld, Random parRandom, BlockPos parBlockPos) {
        int minHeight = parRandom.nextInt(3) + minTreeHeight;

        // Check if tree fits in world
        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight()) {
            if (!isSuitableLocation(parWorld, parBlockPos, minHeight)) {
                return false;
            } else {
                IBlockState state = parWorld.getBlockState(parBlockPos.down());

                if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP,
                        (IPlantable) Blocks.SAPLING) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1) {
                    state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos);
                    generateLeaves(parWorld, parBlockPos, minHeight, parRandom);
                    generateTrunk(parWorld, parBlockPos, minHeight);
                    generateFlits(parWorld, parBlockPos, minHeight, parRandom);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    protected abstract void generateLeaves(World parWorld, BlockPos parBlockPos, int height, Random parRandom);

    protected abstract void generateFlits(World parWorld, BlockPos parBlockPos, int height, Random parRandom);

    protected abstract void generateTrunk(World parWorld, BlockPos parBlockPos, int minHeight);

    protected abstract boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight);
}
