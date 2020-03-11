package jp.artan.japanesefood.Souvenir;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class JapaneseFoodSouvenirCreativeTab extends CreativeTabs {

    public JapaneseFoodSouvenirCreativeTab(String label){
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.APPLE);
    }

}
