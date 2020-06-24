package jp.artan.japanesefoodmod.raw_materials.food

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant
import jp.artan.japanesefoodmod.init.CreativeTabsInit

class RawMaterialPlant(name: String) : JapaneseFoodPlant(name) {
    init {
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab)
    }
}
