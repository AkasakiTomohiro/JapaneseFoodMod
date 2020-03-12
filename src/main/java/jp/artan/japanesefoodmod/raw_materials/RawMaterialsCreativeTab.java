package jp.artan.japanesefoodmod.raw_materials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class RawMaterialsCreativeTab extends CreativeTabs {

    public RawMaterialsCreativeTab(){
        super("japanesefoodrawmaterials");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(RawMaterials.Soy.Seed);
    }

}
