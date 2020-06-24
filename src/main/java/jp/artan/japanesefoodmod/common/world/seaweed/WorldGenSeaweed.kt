package jp.artan.japanesefoodmod.common.world.seaweed

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.seaweeds.CustomSeaweedBlock
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraft.world.gen.feature.WorldGenAbstractTree
import java.util.Random

abstract class WorldGenSeaweed(parShouldNotify: Boolean, val minTreeHeight: Int) : WorldGenAbstractTree(parShouldNotify) {
    lateinit var blockStateWood: IBlockState

    fun setBlockStateWood(customSeaweedBlock: CustomSeaweedBlock) {
        this.blockStateWood = customSeaweedBlock.getDefaultState()
    }

    override fun isReplaceable(world: World, pos: BlockPos): Boolean {
        val state = world.getBlockState(pos)
        JapaneseFoodMod.logger.info("state.getBlock(): " + state.getBlock().getUnlocalizedName())
        return state.getBlock() == Blocks.GRAVEL
    }

    abstract override fun generate(parWorld: World, parRandom: Random, parBlockPos: BlockPos): Boolean
}
