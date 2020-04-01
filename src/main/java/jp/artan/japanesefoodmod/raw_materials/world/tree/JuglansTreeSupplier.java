package jp.artan.japanesefoodmod.raw_materials.world.tree;

import jp.artan.japanesefoodmod.common.wood.FruitBlock;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.common.wood.FruitLog;
import jp.artan.japanesefoodmod.common.world.tree.WorldGenFruitTrees;
import jp.artan.japanesefoodmod.common.world.tree.WorldGenSupplier;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

public class JuglansTreeSupplier extends WorldGenSupplier {
    private FruitLog log;
    private FruitLeaves leaves;
    private FruitBlock fruitBlock;

    public JuglansTreeSupplier() {
        super(100);
    }

    @Override
    public WorldGenFruitTrees getWorldGenerate(boolean parShouldNotify) {
        return new JuglansTreeGen(parShouldNotify, this.log, this.leaves, this.fruitBlock);
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

class JuglansTreeGen extends WorldGenFruitTrees {

    public JuglansTreeGen(boolean parShouldNotify, FruitLog log, FruitLeaves leaves, FruitBlock fruitBlock) {
        super(parShouldNotify, log, leaves, fruitBlock);
    }

    protected void generateLeaves(World parWorld, BlockPos parBlockPos, int height, Random parRandom) {
        for (int foliageY = parBlockPos.getY() - 3 + height; foliageY <= parBlockPos.getY() + height; ++foliageY) {
            int foliageLayer = foliageY - (parBlockPos.getY() + height);
            int foliageLayerRadius = 1 - foliageLayer / 2;

            for (int foliageX = parBlockPos.getX() - foliageLayerRadius; foliageX <= parBlockPos.getX()
                    + foliageLayerRadius; ++foliageX) {
                int foliageRelativeX = foliageX - parBlockPos.getX();

                for (int foliageZ = parBlockPos.getZ() - foliageLayerRadius; foliageZ <= parBlockPos.getZ()
                        + foliageLayerRadius; ++foliageZ) {
                    int foliageRelativeZ = foliageZ - parBlockPos.getZ();

                    // Fill in layer with some randomness
                    if (Math.abs(foliageRelativeX) != foliageLayerRadius
                            || Math.abs(foliageRelativeZ) != foliageLayerRadius
                            || parRandom.nextInt(2) != 0 && foliageLayer != 0) {
                        BlockPos blockPosLeaves = new BlockPos(foliageX, foliageY, foliageZ);
                        IBlockState stateLeaves = parWorld.getBlockState(blockPosLeaves);

                        if (stateLeaves.getBlock().isAir(stateLeaves, parWorld, blockPosLeaves)
                                || stateLeaves.getBlock().isLeaves(stateLeaves, parWorld, blockPosLeaves)) {
                            setBlockAndNotifyAdequately(parWorld, blockPosLeaves, blockStateLeaves);
                        }
                    }
                }
            }
        }
    }

    protected void generateFlits(World parWorld, BlockPos parBlockPos, int height, Random parRandom) {
        int foliageY = parBlockPos.getY() - 3 + height - 1;
        int foliageLayer = foliageY - (parBlockPos.getY() + height);
        int foliageLayerRadius = 1 - foliageLayer / 2;

        for (int foliageX = parBlockPos.getX() - foliageLayerRadius; foliageX <= parBlockPos.getX()
                + foliageLayerRadius; ++foliageX) {

            for (int foliageZ = parBlockPos.getZ() - foliageLayerRadius; foliageZ <= parBlockPos.getZ()
                    + foliageLayerRadius; ++foliageZ) {

                BlockPos blockPos = new BlockPos(foliageX, foliageY, foliageZ);
                IBlockState state = parWorld.getBlockState(blockPos);

                IBlockState stateLeaves = parWorld.getBlockState(new BlockPos(foliageX, foliageY + 1, foliageZ));

                if (state.getBlock().isAir(state, parWorld, blockPos)
                        && state.getBlock().isLeaves(stateLeaves, parWorld, blockPos) && parRandom.nextInt(10) == 1) {
                    setBlockAndNotifyAdequately(parWorld, blockPos, this.blockStateFruit);
                }
            }
        }
    }

    protected void generateTrunk(World parWorld, BlockPos parBlockPos, int minHeight) {
        for (int height = 0; height < minHeight; ++height) {
            BlockPos upN = parBlockPos.up(height);
            IBlockState state = parWorld.getBlockState(upN);

            if (state.getBlock().isAir(state, parWorld, upN) || state.getBlock().isLeaves(state, parWorld, upN)) {
                setBlockAndNotifyAdequately(parWorld, parBlockPos.up(height),
                        blockStateWood.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
            }
        }
    }

    protected boolean isSuitableLocation(World parWorld, BlockPos parBlockPos, int minHeight) {
        boolean isSuitableLocation = true;

        for (int checkY = parBlockPos.getY(); checkY <= parBlockPos.getY() + 1 + minHeight; ++checkY) {
            // Handle increasing space towards top of tree
            int extraSpaceNeeded = 1;
            // Handle base location
            if (checkY == parBlockPos.getY()) {
                extraSpaceNeeded = 0;
            }
            // Handle top location
            if (checkY >= parBlockPos.getY() + 1 + minHeight - 2) {
                extraSpaceNeeded = 2;
            }

            BlockPos.MutableBlockPos blockPos = new BlockPos.MutableBlockPos();

            for (int checkX = parBlockPos.getX() - extraSpaceNeeded; checkX <= parBlockPos.getX() + extraSpaceNeeded
                    && isSuitableLocation; ++checkX) {
                for (int checkZ = parBlockPos.getZ() - extraSpaceNeeded; checkZ <= parBlockPos.getZ() + extraSpaceNeeded
                        && isSuitableLocation; ++checkZ) {
                    isSuitableLocation = this.isReplaceable(parWorld, blockPos.setPos(checkX, checkY, checkZ));
                }
            }
        }

        return isSuitableLocation;
    }
}
