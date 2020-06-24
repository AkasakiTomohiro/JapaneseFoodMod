package jp.artan.japanesefoodmod.raw_materials.world.tree;

import jp.artan.japanesefoodmod.common.wood.FruitBlock;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.common.wood.FruitLog;
import jp.artan.japanesefoodmod.common.world.tree.WorldGenFruitTrees;
import jp.artan.japanesefoodmod.common.world.tree.WorldGenSupplier;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

public class DefaultTreeSupplier extends WorldGenSupplier {
    private FruitLog log;
    private FruitLeaves leaves;
    private FruitBlock fruitBlock;

    public DefaultTreeSupplier() {
        super(100);
    }

    @Override
    public WorldGenFruitTrees getWorldGenerate(boolean parShouldNotify) {
        return new DefaultTreeGen(parShouldNotify, this.log, this.leaves, this.fruitBlock);
    }

    public void setIBlockState(FruitLog log, FruitLeaves leaves, FruitBlock fruitBlock) {
        this.log = log;
        this.leaves = leaves;
        this.fruitBlock = fruitBlock;
    }

    @Override
    public boolean getEnableBiome(Biome biome) {
        return biome == Biomes.PLAINS;
    }

}

class DefaultTreeGen extends WorldGenFruitTrees {

    public DefaultTreeGen(boolean parShouldNotify, FruitLog log, FruitLeaves leaves, FruitBlock fruitBlock) {
        super(parShouldNotify, log, leaves, fruitBlock);
    }
}
