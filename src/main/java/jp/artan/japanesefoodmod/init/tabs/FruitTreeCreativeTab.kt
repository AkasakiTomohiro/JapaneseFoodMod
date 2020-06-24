package jp.artan.japanesefoodmod.init.tabs

import jp.artan.japanesefoodmod.init.BlockInit
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack

class FruitTreeCreativeTab : CreativeTabs("japanesefoodfruittree") {
    override fun getTabIconItem(): ItemStack {
        return ItemStack(BlockInit.BANANA.log)
    }

}
