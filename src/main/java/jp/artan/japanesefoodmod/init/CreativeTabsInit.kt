package jp.artan.japanesefoodmod.init

import jp.artan.japanesefoodmod.init.tabs.FruitTreeCreativeTab
import jp.artan.japanesefoodmod.init.tabs.RawMaterialsCreativeTab
import jp.artan.japanesefoodmod.init.tabs.SouvenirCreativeTab
import jp.artan.japanesefoodmod.init.tabs.ToolCreativeTab

class CreativeTabsInit {
    companion object {
        val rawMaterialsCreativeTab = RawMaterialsCreativeTab()
        val fruitTreeCreativeTab = FruitTreeCreativeTab()
        val toolCreativeTab = ToolCreativeTab()
        val creativeTab = SouvenirCreativeTab()
    }
}
