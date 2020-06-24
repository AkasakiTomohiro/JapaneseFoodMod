package jp.artan.japanesefoodmod.init.tabs

import jp.artan.japanesefoodmod.init.BlockInit
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class RawMaterialsCreativeTab : CreativeTabs("japanesefoodrawmaterials") {


    override fun getTabIconItem(): ItemStack {
        return  ItemStack(BlockInit.SOY.Seed)
    }

}
