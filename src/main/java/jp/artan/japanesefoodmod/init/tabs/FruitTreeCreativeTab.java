package jp.artan.japanesefoodmod.init.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static jp.artan.japanesefoodmod.init.BlockInit.BANANA;

public class FruitTreeCreativeTab extends CreativeTabs {

    public FruitTreeCreativeTab() {
        super("japanesefoodfruittree");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(BANANA.log);
    }

}
