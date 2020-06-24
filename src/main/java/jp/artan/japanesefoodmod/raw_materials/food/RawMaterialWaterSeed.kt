package jp.artan.japanesefoodmod.raw_materials.food

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant
import jp.artan.japanesefoodmod.common.food.JapaneseFoodSeed
import jp.artan.japanesefoodmod.init.CreativeTabsInit
import net.minecraft.advancements.CriteriaTriggers
import net.minecraft.block.BlockLiquid
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.stats.StatList
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.RayTraceResult
import net.minecraft.world.World

/**
 * 水上作物用の種
 */
class RawMaterialWaterSeed(name: String, block: JapaneseFoodPlant) : JapaneseFoodSeed(name, block) {
    init {
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab)
    }

    override fun onItemUse(player: EntityPlayer, worldIn: World, pos: BlockPos, hand: EnumHand,
                           facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): EnumActionResult {
        val itemstack = player.getHeldItem(hand)
        val raytraceresult = this.rayTrace(worldIn, player, true)

        if (raytraceresult == null) {
            return EnumActionResult.PASS
        } else {
            if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
                val blockpos = raytraceresult.getBlockPos()

                if (!worldIn.isBlockModifiable(player, blockpos) || !player
                                .canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack)) {
                    return EnumActionResult.FAIL
                }

                val blockpos1 = blockpos.up()
                val blockpos2 = blockpos.down()
                val iblockstate = worldIn.getBlockState(blockpos)
                val liquidValue = iblockstate.getValue(BlockLiquid.LEVEL) as Int

                if (iblockstate.getMaterial() == Material.WATER
                        && liquidValue == 0
                        && worldIn.isAirBlock(blockpos1)
                        && worldIn.getBlockState(blockpos2).getMaterial() != Material.WATER) {
                    val blocksnapshot = net.minecraftforge.common.util.BlockSnapshot
                            .getBlockSnapshot(worldIn, blockpos1)
                    worldIn.setBlockState(blockpos1, this.Plant.getDefaultState())
                    if (net.minecraftforge.event.ForgeEventFactory
                                    .onPlayerBlockPlace(player, blocksnapshot, EnumFacing.UP, hand)
                                    .isCanceled()) {
                        blocksnapshot.restore(true, false)
                        return EnumActionResult.FAIL
                    }

                    worldIn.setBlockState(blockpos1, this.Plant.getDefaultState(), 11)

                    if (player is EntityPlayerMP) {
                        CriteriaTriggers.PLACED_BLOCK.trigger(player, blockpos1, itemstack)
                    }

                    if (!player.capabilities.isCreativeMode) {
                        itemstack.shrink(1)
                    }

                    player.addStat(StatList.getObjectUseStats(this))
                    return EnumActionResult.SUCCESS
                }
            }
            return EnumActionResult.FAIL
        }
    }
}
