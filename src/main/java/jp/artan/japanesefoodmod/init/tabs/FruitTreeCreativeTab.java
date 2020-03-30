package jp.artan.japanesefoodmod.init.tabs;

import jp.artan.japanesefoodmod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FruitTreeCreativeTab extends CreativeTabs {

    public FruitTreeCreativeTab() {
        super("japanesefoodfruittree");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.BANANA.log);
    }

}
