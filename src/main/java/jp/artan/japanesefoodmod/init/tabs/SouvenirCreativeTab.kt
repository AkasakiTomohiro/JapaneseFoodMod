package jp.artan.japanesefoodmod.init.tabs

import jp.artan.japanesefoodmod.init.ItemInit
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class SouvenirCreativeTab : CreativeTabs("japanesefoodsouvenir") {

    override fun getTabIconItem(): ItemStack {
        return ItemStack(ItemInit.TOKYO_BANANA)
    }

}
