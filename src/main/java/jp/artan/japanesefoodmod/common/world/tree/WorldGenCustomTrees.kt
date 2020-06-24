package jp.artan.japanesefoodmod.common.world.tree

import jp.artan.japanesefoodmod.common.wood.FruitTree
import jp.artan.japanesefoodmod.init.BlockInit.Companion.ALMOND
import jp.artan.japanesefoodmod.init.BlockInit.Companion.BANANA
import jp.artan.japanesefoodmod.init.BlockInit.Companion.CHESTNUT
import jp.artan.japanesefoodmod.init.BlockInit.Companion.CITRON
import jp.artan.japanesefoodmod.init.BlockInit.Companion.GRAPE
import jp.artan.japanesefoodmod.init.BlockInit.Companion.JUGLANS
import jp.artan.japanesefoodmod.init.BlockInit.Companion.MANDARIN_ORANGE
import jp.artan.japanesefoodmod.init.BlockInit.Companion.ORANGE
import net.minecraft.block.Block
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.WorldType
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.gen.IChunkGenerator
import net.minecraftforge.fml.common.IWorldGenerator

import java.util.Random

class WorldGenCustomTrees (): IWorldGenerator {

    companion object{
        fun calculateGenerationHeight( world:World, x: Int, z: Int,  topBlock:Block): Int
        {
            var y = world.getHeight()
            var foundGround = false

            while(!foundGround && y-- >= 0)
            {
                val block = world.getBlockState(BlockPos(x,y,z)).getBlock()
                foundGround = block == topBlock
            }

            return y
        }
    }

    override fun generate(random:Random, chunkX: Int, chunkZ: Int, world:World, chunkGenerator:IChunkGenerator, chunkProvider:IChunkProvider) {
        when (world.provider.getDimension()) {
            -1 -> {
                // エンド
            }
            0 -> {
                // オーバーワールド
                runGenerator(BANANA, world, random, chunkX, chunkZ)
                runGenerator(GRAPE, world, random, chunkX, chunkZ)
                runGenerator(ALMOND, world, random, chunkX, chunkZ)
                runGenerator(JUGLANS, world, random, chunkX, chunkZ)
                runGenerator(CITRON, world, random, chunkX, chunkZ)
                runGenerator(ORANGE, world, random, chunkX, chunkZ)
                runGenerator(MANDARIN_ORANGE, world, random, chunkX, chunkZ)
                runGenerator(CHESTNUT, world, random, chunkX, chunkZ)
            }
            1 -> {
                // ネーザー
            }
        }
    }

    private fun runGenerator( fruitTree:FruitTree,  world:World,  random:Random,  chunkX: Int,  chunkZ: Int)
    {
        val generator = fruitTree.sapling.supplier.getWorldGenerate(false)

        val x = (chunkX * 16) + random.nextInt(15)
        val z = (chunkZ * 16) + random.nextInt(15)
        val y = calculateGenerationHeight(world, x, z, fruitTree.sapling.supplier.topBlock)
        val pos = BlockPos(x,y,z)
        val biome = world.provider.getBiomeForCoords(pos)

        if(world.getWorldType() != WorldType.FLAT)
        {
            if(fruitTree.sapling.supplier.getEnableBiome(biome))
            {
                if(random.nextInt(fruitTree.sapling.supplier.getGenChance(biome)) == 0)
                {
                    generator.generate(world, random, pos)
                }
            }
        }
    }
}
