package jp.artan.japanesefoodmod.init.tabs;

import jp.artan.japanesefoodmod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RawMaterialsCreativeTab extends CreativeTabs {

    public RawMaterialsCreativeTab() {
        super("japanesefoodrawmaterials");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.SOY.Seed);
    }

}
