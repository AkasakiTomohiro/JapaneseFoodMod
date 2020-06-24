package jp.artan.japanesefoodmod.raw_materials.wood

import jp.artan.japanesefoodmod.common.wood.FruitLog
import jp.artan.japanesefoodmod.init.CreativeTabsInit

class RawMaterialsFruitLog(name: String) : FruitLog(name) {
    init {
        this.setCreativeTab(CreativeTabsInit.fruitTreeCreativeTab)
    }
}
