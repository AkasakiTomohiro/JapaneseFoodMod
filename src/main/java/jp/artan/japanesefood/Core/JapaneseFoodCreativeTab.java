package jp.artan.japanesefood.Core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class JapaneseFoodCreativeTab extends CreativeTabs {
    private ItemStack tabIconItem;

    public JapaneseFoodCreativeTab(String label, ItemStack itemStack){
        super(label);
        this.tabIconItem = itemStack;
    }

    @Override
    public ItemStack getTabIconItem() {
        return this.tabIconItem;
    }

}
