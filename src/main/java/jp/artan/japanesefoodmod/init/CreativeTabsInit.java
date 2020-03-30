package jp.artan.japanesefoodmod.init;

import jp.artan.japanesefoodmod.init.tabs.FruitTreeCreativeTab;
import jp.artan.japanesefoodmod.init.tabs.RawMaterialsCreativeTab;
import jp.artan.japanesefoodmod.init.tabs.SouvenirCreativeTab;
import jp.artan.japanesefoodmod.init.tabs.ToolCreativeTab;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsInit {
    public static CreativeTabs rawMaterialsCreativeTab = new RawMaterialsCreativeTab();
    public static CreativeTabs fruitTreeCreativeTab = new FruitTreeCreativeTab();
    public static CreativeTabs toolCreativeTab = new ToolCreativeTab();
    public static CreativeTabs creativeTab = new SouvenirCreativeTab();
}
