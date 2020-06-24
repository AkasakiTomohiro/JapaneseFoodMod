package jp.artan.japanesefoodmod.common.world.tree

import jp.artan.japanesefoodmod.common.wood.FruitBlock
import jp.artan.japanesefoodmod.common.wood.FruitLeaves
import jp.artan.japanesefoodmod.common.wood.FruitLog
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.world.biome.Biome

/**
 * @param topBlock なんのブロックの上に木を生成するか
 * @param genChance 生成確立 100を指定すると1％の確立で生成される
 */
abstract class WorldGenSupplier(val topBlock: Block = Blocks.GRASS, val genChance: Int) {

    fun getGenChance(biome: Biome): Int {
        return this.genChance
    }

    /**
     * 指定したバイオームで生成してよいか
     * @param biome バイオーム
     * @return 生成してよいか
     */
    abstract fun getEnableBiome(biome: Biome): Boolean

    abstract fun getWorldGenerate(parShouldNotify: Boolean): WorldGenFruitTrees
    abstract fun setIBlockState(log: FruitLog, leaves: FruitLeaves, fruitBlock: FruitBlock)
}
