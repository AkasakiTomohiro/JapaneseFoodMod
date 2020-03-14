package jp.artan.japanesefoodmod.souvenir;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SouvenirCreativeTab extends CreativeTabs {

    public SouvenirCreativeTab() {
        super("japanesefoodsouvenir");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(JapaneseFoodSouvenir.TokyoBanana);
    }

}
