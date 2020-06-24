package jp.artan.japanesefoodmod.common.world.biome

import com.google.common.base.Predicate
import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.food.JapaneseFood
import net.minecraft.block.BlockStone
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeDecorator
import net.minecraft.world.gen.feature.WorldGenAbstractTree
import net.minecraft.world.gen.feature.WorldGenLiquids
import net.minecraft.world.gen.feature.WorldGenMinable
import net.minecraft.world.gen.feature.WorldGenerator
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.terraingen.DecorateBiomeEvent
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType
import net.minecraftforge.event.terraingen.OreGenEvent
import net.minecraftforge.event.terraingen.TerrainGen

import java.util.Random

class CustomBiomeDecorator() : BiomeDecorator() {

    // If you want to make these configurable, you'll need a ChunkGeneratorSettings
    // instance and use the fields from there instead.
    var dirtSize = 33
    var gravelSize = 33
    var graniteSize = 33
    var dioriteSize = 33
    var andesiteSize = 33
    var coalSize = 17
    var ironSize = 9
    var goldSize = 9
    var redstoneSize = 9
    var diamondSize = 8
    var lapisSize = 8

    var dirtCount = 10
    var gravelCount = 8
    var dioriteCount = 10
    var graniteCount = 10
    var andesiteCount = 10
    var coalCount = 20
    var ironCount = 20
    var goldCount = 2
    var redstoneCount = 8
    var diamondCount = 1
    var lapisCount = 1

    var lapisCenterHeight = 6
    var lapisSpread = 16

    var oreGenMinHeight = 0

    var dirtMaxHeight = 80
    var gravelMaxHeight = 80
    var dioriteMaxHeight = 80
    var graniteMaxHeight = 80
    var andesiteMaxHeight = 80
    var coalMaxHeight = 70
    var ironMaxHeight = 64
    var goldMaxHeight = 32
    var redstoneMaxHeight = 16
    var diamondMaxHeight = 16

    /**
     * Instantiates a new biome decorator cloud.
     */
    init {
        // Must use predicate version if you wnat to replace custom blocks, otherwise will
        // only replace Blocks.STONE.
        dirtGen = WorldGenMinable(Blocks.DIRT.getDefaultState(), dirtSize)
        gravelOreGen = WorldGenMinable(Blocks.GRAVEL.getDefaultState(), gravelSize)
        graniteGen = WorldGenMinable(
                Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE),
                graniteSize)
        dioriteGen = WorldGenMinable(
                Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE),
                dioriteSize)
        andesiteGen = WorldGenMinable(
                Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE),
                andesiteSize)
        coalGen = WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), coalSize)
        ironGen = WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), ironSize)
        goldGen = WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), goldSize)
        redstoneGen = WorldGenMinable(Blocks.REDSTONE_ORE.getDefaultState(), redstoneSize)
        diamondGen = WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), diamondSize)
        lapisGen = WorldGenMinable(Blocks.LAPIS_ORE.getDefaultState(), lapisSize)

        //        System.out.println("treesPerChunk: " + treesPerChunk)
        treesPerChunk = 10
    }

    /**
     *
     * This is the function where ore generation and things like flowers are generated.
     *
     * @param worldIn the world in
     * @param random the random
     * @param biome the biome
     * @param pos the pos
     */
    override fun decorate(worldIn: World, random: Random, biome: Biome, pos: BlockPos) {
        if (decorating) {
            throw RuntimeException("Already decorating")
        } else {
            this.waterlilyPerChunk = 0
            this.treesPerChunk = 10
            this.extraTreeChance = 0.1F
            this.flowersPerChunk = 100
            this.grassPerChunk = 2
            this.deadBushPerChunk = 0
            this.mushroomsPerChunk = 0
            this.reedsPerChunk = 0
            this.cactiPerChunk = 0
            this.gravelPatchesPerChunk = 1
            this.sandPatchesPerChunk = 3
            this.clayPerChunk = 1
            this.bigMushroomsPerChunk = 0
            this.generateFalls = true

            chunkPos = pos
            genDecorations(biome, worldIn, random)
            decorating = false
        }
    }

    /**
     * This is where things like trees are generated.
     *
     * @param biomeIn the biome in
     * @param worldIn the world in
     * @param random the random
     */
    override fun genDecorations(biomeIn: Biome, worldIn: World, random: Random) {
        JapaneseFoodMod.logger.info("genDecorations")
        MinecraftForge.EVENT_BUS.post(DecorateBiomeEvent.Pre(worldIn, random, chunkPos))

        this.generateOres(worldIn, random)

        generateTrees(worldIn, biomeIn, random, chunkPos)
        generateFlowers(worldIn, biomeIn, random, chunkPos)
        generateGrass(worldIn, biomeIn, random, chunkPos)

        MinecraftForge.EVENT_BUS.post(DecorateBiomeEvent.Post(worldIn, random, chunkPos))
    }

    private fun generateTrees(worldIn: World, biomeIn: Biome, random: Random, chunkPos: BlockPos) {
        var treesToGen = treesPerChunk

        if (random.nextFloat() < extraTreeChance) {
            ++treesToGen
        }

        if (TerrainGen.decorate(worldIn, random, chunkPos, EventType.TREE)) {
            JapaneseFoodMod.logger.info("treesToGen: " + treesToGen)
        }

        for (numTreesGenerated in 0..treesToGen step 1) {
            val treeX = random.nextInt(16) + 8
            val treeZ = random.nextInt(16) + 8
            val treeGen = biomeIn.getRandomTreeFeature(random)
            treeGen.setDecorationDefaults()
            val blockpos = worldIn.getHeight(chunkPos.add(treeX, 0, treeZ))

            if (treeGen.generate(worldIn, random, blockpos)) {
                treeGen.generateSaplings(worldIn, random, blockpos)
            }
        }
    }

    private fun generateFlowers(worldIn: World, biomeIn: Biome, random: Random, chunkPos: BlockPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS))
            for (numFlowersGenerated in 0..flowersPerChunk step 1) {
                val flowerX = random.nextInt(16) + 8
                val flowerZ = random.nextInt(16) + 8
                val yRange = worldIn.getHeight(chunkPos.add(flowerX, 0, flowerZ)).getY() + 32

                if (yRange > 0) {
                    val flowerY = random.nextInt(yRange)
                    val flowerBlockPos = chunkPos.add(flowerX, flowerY, flowerZ)
                    flowerGen.generate(worldIn, random, flowerBlockPos)
                }
            }
    }

    private fun generateGrass(worldIn: World, biomeIn: Biome, random: Random, chunkPos: BlockPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, EventType.GRASS))
            for (numGrassPerChunk in 0..grassPerChunk step 1) {
                val grassX = random.nextInt(16) + 8
                val grassZ = random.nextInt(16) + 8
                val yRange = worldIn.getHeight(chunkPos.add(grassX, 0, grassZ)).getY() * 1

                if (yRange > 0) {
                    val grassY = random.nextInt(yRange)
                    biomeIn.getRandomWorldGenForGrass(random).generate(worldIn, random,
                            chunkPos.add(grassX, grassY, grassZ))
                }
            }
    }

    /**
     * Generates ores in the current chunk.
     *
     * @param worldIn the world in
     * @param random the random
     */
    override fun generateOres(worldIn: World, random: Random) {
        JapaneseFoodMod.logger.info("generateOres")
        MinecraftForge.ORE_GEN_BUS.post(OreGenEvent.Pre(worldIn, random, chunkPos))
        if (TerrainGen.generateOre(worldIn, random, dirtGen, chunkPos, OreGenEvent.GenerateMinable.EventType.DIRT)) {
            genStandardOre1(worldIn, random, dirtCount, dirtGen, oreGenMinHeight, dirtMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, gravelOreGen, chunkPos,
                        OreGenEvent.GenerateMinable.EventType.GRAVEL)) {
            genStandardOre1(worldIn, random, gravelCount, gravelOreGen, oreGenMinHeight, gravelMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, dioriteGen, chunkPos,
                        OreGenEvent.GenerateMinable.EventType.DIORITE)) {
            genStandardOre1(worldIn, random, dioriteCount, dioriteGen, oreGenMinHeight, dioriteMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, graniteGen, chunkPos,
                        OreGenEvent.GenerateMinable.EventType.GRANITE)) {
            genStandardOre1(worldIn, random, graniteCount, graniteGen, oreGenMinHeight, graniteMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, andesiteGen, chunkPos,
                        OreGenEvent.GenerateMinable.EventType.ANDESITE)) {
            genStandardOre1(worldIn, random, andesiteCount, andesiteGen, oreGenMinHeight, andesiteMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, coalGen, chunkPos, OreGenEvent.GenerateMinable.EventType.COAL)) {
            genStandardOre1(worldIn, random, coalCount, coalGen, oreGenMinHeight, coalMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, ironGen, chunkPos, OreGenEvent.GenerateMinable.EventType.IRON)) {
            genStandardOre1(worldIn, random, ironCount, ironGen, oreGenMinHeight, ironMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, goldGen, chunkPos, OreGenEvent.GenerateMinable.EventType.GOLD)) {
            genStandardOre1(worldIn, random, goldCount, goldGen, oreGenMinHeight, goldMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, redstoneGen, chunkPos,
                        OreGenEvent.GenerateMinable.EventType.REDSTONE)) {
            genStandardOre1(worldIn, random, redstoneCount, redstoneGen, oreGenMinHeight, redstoneMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, diamondGen, chunkPos,
                        OreGenEvent.GenerateMinable.EventType.DIAMOND)) {
            genStandardOre1(worldIn, random, diamondCount, diamondGen, oreGenMinHeight, diamondMaxHeight)
        }
        if (TerrainGen.generateOre(worldIn, random, lapisGen, chunkPos, OreGenEvent.GenerateMinable.EventType.LAPIS)) {
            genStandardOre2(worldIn, random, lapisCount, lapisGen, lapisCenterHeight, lapisSpread)
        }
        MinecraftForge.ORE_GEN_BUS.post(OreGenEvent.Post(worldIn, random, chunkPos))
    }
}
