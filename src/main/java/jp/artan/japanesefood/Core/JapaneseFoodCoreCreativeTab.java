package jp.artan.japanesefood.Core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class JapaneseFoodCoreCreativeTab extends CreativeTabs {

    public JapaneseFoodCoreCreativeTab(String label){
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(JapaneseFoodRawMaterials.Banana);
    }

}
