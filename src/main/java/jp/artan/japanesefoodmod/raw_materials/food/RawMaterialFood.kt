package jp.artan.japanesefoodmod.raw_materials.food

import jp.artan.japanesefoodmod.init.CreativeTabsInit
import jp.artan.japanesefoodmod.common.food.JapaneseFood

/**
 * コンストラクタ
 *
 * @param name       食べ物の名前(※英字小文字のみ)
 * @param amount     回復する満腹度
 * @param saturation 回復する隠し満腹度
 */
class RawMaterialFood(name: String, amount: Int, saturation: Float) : JapaneseFood(name, amount, saturation) {
    init {
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab)
    }
}
