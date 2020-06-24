package jp.artan.japanesefoodmod.raw_materials.world.tree

import jp.artan.japanesefoodmod.common.wood.FruitBlock
import jp.artan.japanesefoodmod.common.wood.FruitLeaves
import jp.artan.japanesefoodmod.common.wood.FruitLog
import jp.artan.japanesefoodmod.common.world.tree.WorldGenFruitTrees
import jp.artan.japanesefoodmod.common.world.tree.WorldGenSupplier
import net.minecraft.block.BlockLog
import net.minecraft.init.Biomes
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import java.util.Random

class BananaTreeSupplier : WorldGenSupplier(Blocks.GRASS, 100) {
    lateinit var log: FruitLog
    lateinit var leaves: FruitLeaves
    lateinit var fruitBlock: FruitBlock

    override fun getWorldGenerate(parShouldNotify: Boolean): WorldGenFruitTrees {
        return BananaTreeGen(parShouldNotify, this.log, this.leaves, this.fruitBlock)
    }

    override fun setIBlockState(log: FruitLog, leaves: FruitLeaves, fruitBlock: FruitBlock) {
        this.log = log
        this.leaves = leaves
        this.fruitBlock = fruitBlock
    }

    override fun getEnableBiome(biome: Biome): Boolean {
        return biome == Biomes.PLAINS
    }
}

class BananaTreeGen(parShouldNotify: Boolean, log: FruitLog, leaves: FruitLeaves, fruitBlock: FruitBlock) :
        WorldGenFruitTrees(parShouldNotify, log, leaves, fruitBlock) {

    override fun generateLeaves(parWorld: World, parBlockPos: BlockPos, height: Int, parRandom: Random) {
        for (foliageY in (parBlockPos.getY() - 3 + height)..(parBlockPos.getY() + height) step 1) {
            val foliageLayer = foliageY - (parBlockPos.getY() + height)
            val foliageLayerRadius = 1 - foliageLayer / 2

            for (foliageX in (parBlockPos.getX() - foliageLayerRadius)..(parBlockPos.getX() + foliageLayerRadius) step 1) {
                val foliageRelativeX = foliageX - parBlockPos.getX()

                for (foliageZ in (parBlockPos.getZ() - foliageLayerRadius)..(parBlockPos.getZ() + foliageLayerRadius) step 1) {
                    val foliageRelativeZ = foliageZ - parBlockPos.getZ()

                    // Fill in layer with some randomness
                    if (Math.abs(foliageRelativeX) != foliageLayerRadius
                            || Math.abs(foliageRelativeZ) != foliageLayerRadius
                            || parRandom.nextInt(2) != 0 && foliageLayer != 0) {
                        val blockPosLeaves = BlockPos(foliageX, foliageY, foliageZ)
                        val stateLeaves = parWorld.getBlockState(blockPosLeaves)

                        if (stateLeaves.getBlock().isAir(stateLeaves, parWorld, blockPosLeaves)
                                || stateLeaves.getBlock().isLeaves(stateLeaves, parWorld, blockPosLeaves)) {
                            setBlockAndNotifyAdequately(parWorld, blockPosLeaves, blockStateLeaves)
                        }
                    }
                }
            }
        }
    }

    override fun generateFlits(parWorld: World, parBlockPos: BlockPos, height: Int, parRandom: Random) {
        val foliageY = parBlockPos.getY() - 3 + height - 1
        val foliageLayer = foliageY - (parBlockPos.getY() + height)
        val foliageLayerRadius = 1 - foliageLayer / 2

        for (foliageX in (parBlockPos.getX() - foliageLayerRadius)..(parBlockPos.getX() + foliageLayerRadius) step 1) {

            for (foliageZ in (parBlockPos.getZ() - foliageLayerRadius)..(parBlockPos.getZ() + foliageLayerRadius) step 1) {

                val blockPos = BlockPos(foliageX, foliageY, foliageZ)
                val state = parWorld.getBlockState(blockPos)

                val stateLeaves = parWorld.getBlockState(BlockPos(foliageX, foliageY + 1, foliageZ))

                if (state.getBlock().isAir(state, parWorld, blockPos)
                        && state.getBlock().isLeaves(stateLeaves, parWorld, blockPos) && parRandom.nextInt(10) == 1) {
                    setBlockAndNotifyAdequately(parWorld, blockPos, this.blockStateFruit)
                }
            }
        }
    }

    override fun generateTrunk(parWorld: World, parBlockPos: BlockPos, minHeight: Int) {
        for (height in 0..minHeight step 1) {
            val upN = parBlockPos.up(height)
            val state = parWorld.getBlockState(upN)

            if (state.getBlock().isAir(state, parWorld, upN) || state.getBlock().isLeaves(state, parWorld, upN)) {
                setBlockAndNotifyAdequately(parWorld, parBlockPos.up(height),
                        blockStateWood.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y))
            }
        }
    }

    override fun isSuitableLocation(parWorld: World, parBlockPos: BlockPos, minHeight: Int): Boolean {
        var isSuitableLocation = true

        for (checkY in (parBlockPos.getY())..(parBlockPos.getY() + 1 + minHeight) step 1) {
            // Handle increasing space towards top of tree
            var extraSpaceNeeded = 1
            // Handle base location
            if (checkY == parBlockPos.getY()) {
                extraSpaceNeeded = 0
            }
            // Handle top location
            if (checkY >= parBlockPos.getY() + 1 + minHeight - 2) {
                extraSpaceNeeded = 2
            }

            val blockPos = BlockPos.MutableBlockPos()

            for (checkX in (parBlockPos.getX() - extraSpaceNeeded)..(parBlockPos.getX() + extraSpaceNeeded) step 1) {
                if (!isSuitableLocation) {
                    break
                }
                for (checkZ in (parBlockPos.getZ() - extraSpaceNeeded)..(parBlockPos.getZ() + extraSpaceNeeded) step 1) {
                    if (!isSuitableLocation) {
                        break
                    }
                    isSuitableLocation = this.isReplaceable(parWorld, blockPos.setPos(checkX, checkY, checkZ))
                }
            }
        }

        return isSuitableLocation
    }
}
