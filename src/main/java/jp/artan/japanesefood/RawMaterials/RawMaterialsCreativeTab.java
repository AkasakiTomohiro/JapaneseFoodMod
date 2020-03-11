package jp.artan.japanesefood.RawMaterials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RawMaterialsCreativeTab extends CreativeTabs {

    public RawMaterialsCreativeTab(String label){
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(RawMaterials.Banana);
    }

}
