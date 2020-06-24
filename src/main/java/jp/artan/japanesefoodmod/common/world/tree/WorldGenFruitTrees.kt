package jp.artan.japanesefoodmod.common.world.tree

import java.util.Random
import jp.artan.japanesefoodmod.common.wood.FruitBlock
import jp.artan.japanesefoodmod.common.wood.FruitLeaves
import jp.artan.japanesefoodmod.common.wood.FruitLog
import net.minecraft.block.BlockLeaves
import net.minecraft.init.Blocks
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.gen.feature.WorldGenAbstractTree
import net.minecraftforge.common.IPlantable

abstract class WorldGenFruitTrees(parShouldNotify: Boolean, log: FruitLog, leaves: FruitLeaves, fruitBlock: FruitBlock, val minTreeHeight: Int = 5) : WorldGenAbstractTree(parShouldNotify) {
    val blockStateWood = log.getDefaultState()
    val blockStateLeaves = fruitBlock.getDefaultState()
    val blockStateFruit = leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, false)

    override fun generate(parWorld: World, parRandom: Random, parBlockPos: BlockPos): Boolean {
        val minHeight = parRandom.nextInt(3) + minTreeHeight

        // Check if tree fits in world
        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= parWorld.getHeight()) {
            if (!isSuitableLocation(parWorld, parBlockPos, minHeight)) {
                return false
            } else {
                val state = parWorld.getBlockState(parBlockPos.down())

                if (state.getBlock().canSustainPlant(state, parWorld, parBlockPos.down(), EnumFacing.UP,
                                Blocks.SAPLING as IPlantable) && parBlockPos.getY() < parWorld.getHeight() - minHeight - 1) {
                    state.getBlock().onPlantGrow(state, parWorld, parBlockPos.down(), parBlockPos)
                    generateLeaves(parWorld, parBlockPos, minHeight, parRandom)
                    generateTrunk(parWorld, parBlockPos, minHeight)
                    generateFlits(parWorld, parBlockPos, minHeight, parRandom)
                    return true
                } else {
                    return false
                }
            }
        } else {
            return false
        }
    }

    abstract fun generateLeaves(parWorld: World, parBlockPos: BlockPos, height: Int, parRandom: Random)

    abstract fun generateFlits(parWorld: World, parBlockPos: BlockPos, height: Int, parRandom: Random)

    abstract fun generateTrunk(parWorld: World, parBlockPos: BlockPos, minHeight: Int)

    abstract fun isSuitableLocation(parWorld: World, parBlockPos: BlockPos, minHeight: Int): Boolean
}
