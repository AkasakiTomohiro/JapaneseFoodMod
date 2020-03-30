package jp.artan.japanesefoodmod.init.tabs;

import jp.artan.japanesefoodmod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ToolCreativeTab  extends CreativeTabs {

    public ToolCreativeTab() {
        super("japanesefoodtool");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.GROUND_WOOD);
    }

}