package jp.artan.japanesefoodmod.raw_materials.tabs;

import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FruitTreeCreativeTab extends CreativeTabs {

    public FruitTreeCreativeTab() {
        super("japanesefoodfruittree");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(JapaneseFoodRawMaterials.BANANA.log);
    }

}
