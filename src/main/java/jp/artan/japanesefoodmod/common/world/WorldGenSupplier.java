package jp.artan.japanesefoodmod.common.world;

import jp.artan.japanesefoodmod.common.wood.FruitBlock;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.common.wood.FruitLog;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public abstract class WorldGenSupplier {

    /**
     * 生成確立
     * @note 100を指定すると1％の確立で生成される
     */
    public final int genChance;

    /**
     * なんのブロックの上に木を生成するか
     */
    public final Block topBlock;

    protected WorldGenSupplier(Block topBlock, int chance) {
        this.topBlock = topBlock;
        this.genChance = chance;
    }

    protected WorldGenSupplier(int chance) {
        this(Blocks.GRASS, chance);
    }

    public abstract WorldGenFruitTrees getWorldGenerate(boolean parShouldNotify);
    public abstract void setIBlockState(FruitLog log, FruitLeaves leaves, FruitBlock fruitBlock);

    /**
     * 指定したバイオームで生成してよいか
     * @param biome バイオーム
     * @return 生成してよいか
     */
    public abstract boolean getEnableBiome(Biome biome);
}
