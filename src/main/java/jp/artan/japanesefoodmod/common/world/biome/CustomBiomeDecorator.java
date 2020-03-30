package jp.artan.japanesefoodmod.common.world.biome;

import com.google.common.base.Predicate;
import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class CustomBiomeDecorator extends BiomeDecorator {

    // If you want to make these configurable, you'll need a ChunkGeneratorSettings
    // instance and use the fields from there instead.
    private int dirtSize = 33;
    private int gravelSize = 33;
    private int graniteSize = 33;
    private int dioriteSize = 33;
    private int andesiteSize = 33;
    private int coalSize = 17;
    private int ironSize = 9;
    private int goldSize = 9;
    private int redstoneSize = 9;
    private int diamondSize = 8;
    private int lapisSize = 8;

    private int dirtCount = 10;
    private int gravelCount = 8;
    private int dioriteCount = 10;
    private int graniteCount = 10;
    private int andesiteCount = 10;
    private int coalCount = 20;
    private int ironCount = 20;
    private int goldCount = 2;
    private int redstoneCount = 8;
    private int diamondCount = 1;
    private int lapisCount = 1;

    private int lapisCenterHeight = 6;
    private int lapisSpread = 16;

    private int oreGenMinHeight = 0;

    private int dirtMaxHeight = 80;
    private int gravelMaxHeight = 80;
    private int dioriteMaxHeight = 80;
    private int graniteMaxHeight = 80;
    private int andesiteMaxHeight = 80;
    private int coalMaxHeight = 70;
    private int ironMaxHeight = 64;
    private int goldMaxHeight = 32;
    private int redstoneMaxHeight = 16;
    private int diamondMaxHeight = 16;

    /**
     * Instantiates a new biome decorator cloud.
     */
    public CustomBiomeDecorator() {
        super();

        // Must use predicate version if you wnat to replace custom blocks, otherwise will
        // only replace Blocks.STONE.
        dirtGen = new WorldGenMinable(Blocks.DIRT.getDefaultState(), dirtSize);
        gravelOreGen = new WorldGenMinable(Blocks.GRAVEL.getDefaultState(), gravelSize);
        graniteGen = new WorldGenMinable(
                Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE),
                graniteSize);
        dioriteGen = new WorldGenMinable(
                Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE),
                dioriteSize);
        andesiteGen = new WorldGenMinable(
                Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE),
                andesiteSize);
        coalGen = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), coalSize);
        ironGen = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), ironSize);
        goldGen = new WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), goldSize);
        redstoneGen = new WorldGenMinable(Blocks.REDSTONE_ORE.getDefaultState(), redstoneSize);
        diamondGen = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), diamondSize);
        lapisGen = new WorldGenMinable(Blocks.LAPIS_ORE.getDefaultState(), lapisSize);

        //        System.out.println("treesPerChunk: " + treesPerChunk);
        treesPerChunk = 10;
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
    @Override
    public void decorate(World worldIn, Random random, Biome biome, BlockPos pos) {
        if (decorating) {
            throw new RuntimeException("Already decorating");
        } else {
            this.waterlilyPerChunk = 0;
            this.treesPerChunk = 10;
            this.extraTreeChance = 0.1F;
            this.flowersPerChunk = 100;
            this.grassPerChunk = 2;
            this.deadBushPerChunk = 0;
            this.mushroomsPerChunk = 0;
            this.reedsPerChunk = 0;
            this.cactiPerChunk = 0;
            this.gravelPatchesPerChunk = 1;
            this.sandPatchesPerChunk = 3;
            this.clayPerChunk = 1;
            this.bigMushroomsPerChunk = 0;
            this.generateFalls = true;

            chunkPos = pos;
            genDecorations(biome, worldIn, random);
            decorating = false;
        }
    }

    /**
     * This is where things like trees are generated.
     *
     * @param biomeIn the biome in
     * @param worldIn the world in
     * @param random the random
     */
    @Override
    protected void genDecorations(Biome biomeIn, World worldIn, Random random) {
        JapaneseFoodMod.logger.info("genDecorations");
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldIn, random, chunkPos));

        this.generateOres(worldIn, random);

        generateTrees(worldIn, biomeIn, random, chunkPos);
        generateFlowers(worldIn, biomeIn, random, chunkPos);
        generateGrass(worldIn, biomeIn, random, chunkPos);

        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(worldIn, random, chunkPos));
    }

    private void generateTrees(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos) {
        int treesToGen = treesPerChunk;

        if (random.nextFloat() < extraTreeChance) {
            ++treesToGen;
        }

        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.TREE))
            JapaneseFoodMod.logger.info("treesToGen: " + treesToGen);
        for (int numTreesGenerated = 0; numTreesGenerated < treesToGen; ++numTreesGenerated) {
            int treeX = random.nextInt(16) + 8;
            int treeZ = random.nextInt(16) + 8;
            WorldGenAbstractTree treeGen = biomeIn.getRandomTreeFeature(random);
            treeGen.setDecorationDefaults();
            BlockPos blockpos = worldIn.getHeight(chunkPos.add(treeX, 0, treeZ));

            if (treeGen.generate(worldIn, random, blockpos)) {
                treeGen.generateSaplings(worldIn, random, blockpos);
            }
        }
    }

    private void generateFlowers(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS))
            for (int numFlowersGenerated = 0; numFlowersGenerated < flowersPerChunk; ++numFlowersGenerated) {
                int flowerX = random.nextInt(16) + 8;
                int flowerZ = random.nextInt(16) + 8;
                int yRange = worldIn.getHeight(chunkPos.add(flowerX, 0, flowerZ)).getY() + 32;

                if (yRange > 0) {
                    int flowerY = random.nextInt(yRange);
                    BlockPos flowerBlockPos = chunkPos.add(flowerX, flowerY, flowerZ);
                    flowerGen.generate(worldIn, random, flowerBlockPos);
                }
            }
    }

    private void generateGrass(World worldIn, Biome biomeIn, Random random, BlockPos chunkPos) {
        if (TerrainGen.decorate(worldIn, random, chunkPos, DecorateBiomeEvent.Decorate.EventType.GRASS))
            for (int numGrassPerChunk = 0; numGrassPerChunk < grassPerChunk; ++numGrassPerChunk) {
                int grassX = random.nextInt(16) + 8;
                int grassZ = random.nextInt(16) + 8;
                int yRange = worldIn.getHeight(chunkPos.add(grassX, 0, grassZ)).getY() * 1;

                if (yRange > 0) {
                    int grassY = random.nextInt(yRange);
                    biomeIn.getRandomWorldGenForGrass(random).generate(worldIn, random,
                            chunkPos.add(grassX, grassY, grassZ));
                }
            }
    }

    /**
     * Generates ores in the current chunk.
     *
     * @param worldIn the world in
     * @param random the random
     */
    @Override
    protected void generateOres(World worldIn, Random random) {
        JapaneseFoodMod.logger.info("generateOres");
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(worldIn, random, chunkPos));
        if (TerrainGen.generateOre(worldIn, random, dirtGen, chunkPos, OreGenEvent.GenerateMinable.EventType.DIRT)) {
            genStandardOre1(worldIn, random, dirtCount, dirtGen, oreGenMinHeight, dirtMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, gravelOreGen, chunkPos,
                OreGenEvent.GenerateMinable.EventType.GRAVEL)) {
            genStandardOre1(worldIn, random, gravelCount, gravelOreGen, oreGenMinHeight, gravelMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, dioriteGen, chunkPos,
                OreGenEvent.GenerateMinable.EventType.DIORITE)) {
            genStandardOre1(worldIn, random, dioriteCount, dioriteGen, oreGenMinHeight, dioriteMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, graniteGen, chunkPos,
                OreGenEvent.GenerateMinable.EventType.GRANITE)) {
            genStandardOre1(worldIn, random, graniteCount, graniteGen, oreGenMinHeight, graniteMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, andesiteGen, chunkPos,
                OreGenEvent.GenerateMinable.EventType.ANDESITE)) {
            genStandardOre1(worldIn, random, andesiteCount, andesiteGen, oreGenMinHeight, andesiteMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, coalGen, chunkPos, OreGenEvent.GenerateMinable.EventType.COAL)) {
            genStandardOre1(worldIn, random, coalCount, coalGen, oreGenMinHeight, coalMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, ironGen, chunkPos, OreGenEvent.GenerateMinable.EventType.IRON)) {
            genStandardOre1(worldIn, random, ironCount, ironGen, oreGenMinHeight, ironMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, goldGen, chunkPos, OreGenEvent.GenerateMinable.EventType.GOLD)) {
            genStandardOre1(worldIn, random, goldCount, goldGen, oreGenMinHeight, goldMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, redstoneGen, chunkPos,
                OreGenEvent.GenerateMinable.EventType.REDSTONE)) {
            genStandardOre1(worldIn, random, redstoneCount, redstoneGen, oreGenMinHeight, redstoneMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, diamondGen, chunkPos,
                OreGenEvent.GenerateMinable.EventType.DIAMOND)) {
            genStandardOre1(worldIn, random, diamondCount, diamondGen, oreGenMinHeight, diamondMaxHeight);
        }
        if (TerrainGen.generateOre(worldIn, random, lapisGen, chunkPos, OreGenEvent.GenerateMinable.EventType.LAPIS)) {
            genStandardOre2(worldIn, random, lapisCount, lapisGen, lapisCenterHeight, lapisSpread);
        }
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(worldIn, random, chunkPos));
    }
}
