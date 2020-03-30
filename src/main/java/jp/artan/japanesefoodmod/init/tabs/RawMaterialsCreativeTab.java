package jp.artan.japanesefoodmod.init.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static jp.artan.japanesefoodmod.init.BlockInit.SOY;

public class RawMaterialsCreativeTab extends CreativeTabs {

    public RawMaterialsCreativeTab() {
        super("japanesefoodrawmaterials");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(SOY.Seed);
    }

}
