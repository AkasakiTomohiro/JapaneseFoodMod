package jp.artan.japanesefoodmod.raw_materials.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodSeed;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * 水上作物用の種
 */
public class RawMaterialWaterSeed extends JapaneseFoodSeed {
    public RawMaterialWaterSeed(String name, JapaneseFoodPlant block) {
        super(name, block);
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        RayTraceResult raytraceresult = this.rayTrace(worldIn, player, true);

        if (raytraceresult == null) {
            return EnumActionResult.PASS;
        } else {
            if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
                BlockPos blockpos = raytraceresult.getBlockPos();

                if (!worldIn.isBlockModifiable(player, blockpos) || !player
                        .canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack)) {
                    return EnumActionResult.FAIL;
                }

                BlockPos blockpos1 = blockpos.up();
                BlockPos blockpos2 = blockpos.down();
                IBlockState iblockstate = worldIn.getBlockState(blockpos);

                if (iblockstate.getMaterial() == Material.WATER
                        && ((Integer) iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0
                        && worldIn.isAirBlock(blockpos1)
                        && worldIn.getBlockState(blockpos2).getMaterial() != Material.WATER) {
                    net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot
                            .getBlockSnapshot(worldIn, blockpos1);
                    worldIn.setBlockState(blockpos1, this.Plant.getDefaultState());
                    if (net.minecraftforge.event.ForgeEventFactory
                            .onPlayerBlockPlace(player, blocksnapshot, net.minecraft.util.EnumFacing.UP, hand)
                            .isCanceled()) {
                        blocksnapshot.restore(true, false);
                        return EnumActionResult.FAIL;
                    }

                    worldIn.setBlockState(blockpos1, this.Plant.getDefaultState(), 11);

                    if (player instanceof EntityPlayerMP) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, blockpos1, itemstack);
                    }

                    if (!player.capabilities.isCreativeMode) {
                        itemstack.shrink(1);
                    }

                    player.addStat(StatList.getObjectUseStats(this));
                    return EnumActionResult.SUCCESS;
                }
            }
            return EnumActionResult.FAIL;
        }
    }
}
