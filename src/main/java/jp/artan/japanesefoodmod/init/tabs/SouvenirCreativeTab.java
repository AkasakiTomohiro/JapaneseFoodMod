package jp.artan.japanesefoodmod.init.tabs;

import jp.artan.japanesefoodmod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SouvenirCreativeTab extends CreativeTabs {

    public SouvenirCreativeTab() {
        super("japanesefoodsouvenir");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.TOKYO_BANANA);
    }

}
