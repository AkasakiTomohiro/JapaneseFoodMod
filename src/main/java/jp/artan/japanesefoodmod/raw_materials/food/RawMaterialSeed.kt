package jp.artan.japanesefoodmod.raw_materials.food

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant
import jp.artan.japanesefoodmod.common.food.JapaneseFoodSeed
import jp.artan.japanesefoodmod.init.CreativeTabsInit

class RawMaterialSeed(name: String, block: JapaneseFoodPlant) : JapaneseFoodSeed(name, block) {
    init {
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab)
    }
}
