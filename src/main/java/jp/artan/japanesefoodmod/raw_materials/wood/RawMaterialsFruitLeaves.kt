package jp.artan.japanesefoodmod.raw_materials.wood

import jp.artan.japanesefoodmod.common.wood.FruitLeaves
import jp.artan.japanesefoodmod.init.CreativeTabsInit

class RawMaterialsFruitLeaves(name: String) : FruitLeaves(name) {
    init {
        this.setCreativeTab(CreativeTabsInit.fruitTreeCreativeTab)
    }
}
