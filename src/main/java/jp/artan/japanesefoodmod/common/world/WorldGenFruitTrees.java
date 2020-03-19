package jp.artan.japanesefoodmod.common.world;

import jp.artan.japanesefoodmod.common.wood.FruitBlock;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.common.wood.FruitLog;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenFruitTrees extends WorldGenAbstractTree {
    protected IBlockState blockStateWood;
    protected IBlockState blockStateLeaves;
    protected IBlockState blockStateFruit;

    public WorldGenFruitTrees(boolean parShouldNotify, FruitLog log, FruitLeaves leaves, FruitBlock fruitBlock) {
        super(parShouldNotify);
        this.blockStateWood = log.getDefaultState();
        this.blockStateFruit = fruitBlock.getDefaultState();
        this.blockStateLeaves = leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
    }
}
