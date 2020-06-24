package jp.artan.japanesefoodmod.raw_materials.food

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant
import jp.artan.japanesefoodmod.init.CreativeTabsInit
import net.minecraft.block.BlockLiquid
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

/**
 * 水上作物用の作物ブロック
 */
class RawMaterialWaterPlant(name: String) : JapaneseFoodPlant(name) {
    init {
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab)
    }

    override fun canSustainBush(state: IBlockState): Boolean {
        return state.getBlock() == Blocks.WATER
    }

    override fun canBlockStay(worldIn: World, pos: BlockPos, state: IBlockState): Boolean {
        if (pos.getY() >= 0 && pos.getY() < 256) {
            val iblockstate = worldIn.getBlockState(pos.down())
            val material = iblockstate.getMaterial()
            val material2 = worldIn.getBlockState(pos.down().down()).getMaterial()
            val liquidValue = iblockstate.getValue(BlockLiquid.LEVEL) as Int
            return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && material == Material.WATER && liquidValue == 0 && material2 != Material.WATER
        } else {
            return false
        }
    }
}
