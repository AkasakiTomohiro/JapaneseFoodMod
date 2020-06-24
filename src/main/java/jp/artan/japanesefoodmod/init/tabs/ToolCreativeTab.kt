package jp.artan.japanesefoodmod.init.tabs

import jp.artan.japanesefoodmod.init.ItemInit
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class ToolCreativeTab : CreativeTabs("japanesefoodtool") {


    override fun getTabIconItem(): ItemStack {
        return ItemStack(ItemInit.GROUND_WOOD)
    }

}