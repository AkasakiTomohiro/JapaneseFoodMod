package jp.artan.japanesefoodmod.raw_materials.world.seaweed

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenSeaweed
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

import java.util.Random

class OgonoriGen : WorldGenSeaweed(false, 5) {
    override fun generate(parWorld: World, parRandom: Random, parBlockPos: BlockPos): Boolean {
        val minHeight = parRandom.nextInt(Math.max(60 - 1 - 5 - parBlockPos.getY(), 0)) + this.minTreeHeight

        // Check if tree fits in world
        if (parBlockPos.getY() >= 1 && parBlockPos.getY() + minHeight + 1 <= 60) {
            val state = parWorld.getBlockState(parBlockPos.up())
            if (state.getBlock() == Blocks.WATER) {
                JapaneseFoodMod.logger.info("##############################")
                JapaneseFoodMod.logger.info("minHeight: " + minHeight)
                for (i in 0..minHeight step 1) {
                    val blockPos = BlockPos(parBlockPos.getX(), parBlockPos.getY() + i + 1, parBlockPos.getZ())
                    setBlockAndNotifyAdequately(parWorld, blockPos, blockStateWood)
                }
                return true
            } else {
                return false
            }
        } else {
            return false
        }
    }
}
