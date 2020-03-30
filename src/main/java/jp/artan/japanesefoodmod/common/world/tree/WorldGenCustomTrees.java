package jp.artan.japanesefoodmod.common.world.tree;

import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenCustomTrees implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                break;
            case 0:
                runGenerator(ItemInit.BANANA, world, random, chunkX, chunkZ);
                runGenerator(ItemInit.GRAPE, world, random, chunkX, chunkZ);
                break;
            case 1:
                break;
        }
    }

    private void runGenerator(FruitTree fruitTree, World world, Random random, int chunkX, int chunkZ)
    {
        WorldGenerator generator = fruitTree.sapling.supplier.getWorldGenerate(false);

        int x = (chunkX * 16) + random.nextInt(15);
        int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world, x, z, fruitTree.sapling.supplier.topBlock);
        BlockPos pos = new BlockPos(x,y,z);
        Biome biome = world.provider.getBiomeForCoords(pos);

        if(world.getWorldType() != WorldType.FLAT)
        {
            if(fruitTree.sapling.supplier.getEnableBiome(biome))
            {
                if(random.nextInt(fruitTree.sapling.supplier.getGenChance(biome)) == 0)
                {
                    generator.generate(world, random, pos);
                }
            }
        }
    }

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
    {
        int y = world.getHeight();
        boolean foundGround = false;

        while(!foundGround && y-- >= 0)
        {
            Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround = block == topBlock;
        }

        return y;
    }
}
