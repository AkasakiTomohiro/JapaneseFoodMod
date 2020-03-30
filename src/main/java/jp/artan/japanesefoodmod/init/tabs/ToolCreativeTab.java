package jp.artan.japanesefoodmod.init.tabs;

import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ToolCreativeTab  extends CreativeTabs {

    public ToolCreativeTab() {
        super("japanesefoodtool");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(JapaneseFoodRawMaterials.GROUND_WOOD);
    }

}