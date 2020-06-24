package jp.artan.japanesefoodmod.raw_materials.wood

import jp.artan.japanesefoodmod.common.wood.FruitBlock
import jp.artan.japanesefoodmod.init.CreativeTabsInit

class RawMaterialsFruitBlock(name: String) : FruitBlock(name) {
    init {
        this.setCreativeTab(CreativeTabsInit.fruitTreeCreativeTab)
    }
}
