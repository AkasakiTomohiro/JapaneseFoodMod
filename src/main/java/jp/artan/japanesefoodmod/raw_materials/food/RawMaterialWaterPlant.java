package jp.artan.japanesefoodmod.raw_materials.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

/**
 * 水上作物用の作物ブロック
 */
public class RawMaterialWaterPlant extends JapaneseFoodPlant {
    public RawMaterialWaterPlant(String name) {
        super(name);
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab);
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.WATER;
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        if (pos.getY() >= 0 && pos.getY() < 256)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos.down());
            Material material = iblockstate.getMaterial();
            Material material2 = worldIn.getBlockState(pos.down().down()).getMaterial();
            return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && material == Material.WATER && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0 && material2 != Material.WATER;
        }
        else
        {
            return false;
        }
    }
}
