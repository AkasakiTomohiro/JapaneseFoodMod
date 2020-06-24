package jp.artan.japanesefoodmod.raw_materials.food

import jp.artan.japanesefoodmod.common.food.JapaneseFoodAsSeed
import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant
import jp.artan.japanesefoodmod.init.CreativeTabsInit

/**
 * コンストラクタ
 *
 * @param name       食べ物の名前(※英字小文字のみ)
 * @param amount     回復する満腹度
 * @param saturation 回復する隠し満腹度
 */
class RawMaterialFoodAsSeed (name: String, amount: Int, saturation: Float,plant: JapaneseFoodPlant) : JapaneseFoodAsSeed(name, amount, saturation, plant) {
    init {
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab)
    }
}
