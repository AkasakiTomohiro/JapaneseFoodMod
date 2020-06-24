package jp.artan.japanesefoodmod.common.world.seaweed

import jp.artan.japanesefoodmod.common.seaweeds.CustomSeaweeds
import jp.artan.japanesefoodmod.init.BlockInit
import net.minecraft.block.Block
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.WorldType
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.gen.IChunkGenerator
import net.minecraftforge.fml.common.IWorldGenerator

import java.util.Random

class WorldGenCustomSeaweed() : IWorldGenerator {

    companion object {
        fun calculateGenerationHeight(world: World, x: Int, z: Int, topBlock: Block): Int {
            var y = world.getHeight()
            var foundGround = false

            while (!foundGround && y-- >= 0) {
                val block = world.getBlockState(BlockPos(x, y, z)).getBlock()
                foundGround = block == topBlock
            }

            return y
        }
    }

    override fun generate(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkGenerator,
                          chunkProvider: IChunkProvider) {
        when (world.provider.getDimension()) {
            -1 -> {
                // エンド
            }
            0 -> {
                // オーバーワールド
                runGenerator(BlockInit.SEAWEEDS, world, random, chunkX, chunkZ)
                runGenerator(BlockInit.TENGSA, world, random, chunkX, chunkZ)
                runGenerator(BlockInit.OGONORI, world, random, chunkX, chunkZ)
            }
            1 -> {
                // ネーザー
            }
        }
    }

    private fun runGenerator(fruitTree: CustomSeaweeds, world: World, random: Random, chunkX: Int, chunkZ: Int) {
        val generator = fruitTree.getWorldGenerator(false)

        val x = (chunkX * 16) + random.nextInt(15)
        val z = (chunkZ * 16) + random.nextInt(15)
        val y = calculateGenerationHeight(world, x, z, fruitTree.block.topBlock)
        val pos = BlockPos(x, y, z)
        val biome = world.provider.getBiomeForCoords(pos)

        if (world.getWorldType() != WorldType.FLAT) {
            if (fruitTree.block.getEnableBiome(biome)) {
                if (random.nextInt(fruitTree.block.getGenChance(biome)) == 0) {
                    generator.generate(world, random, pos)
                }
            }
        }
    }

}