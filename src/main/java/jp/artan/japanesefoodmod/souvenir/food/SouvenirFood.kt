package jp.artan.japanesefoodmod.souvenir.food

import jp.artan.japanesefoodmod.common.food.JapaneseFood
import jp.artan.japanesefoodmod.init.CreativeTabsInit

class SouvenirFood(name: String, amount: Int, saturation: Float) : JapaneseFood(name, amount, saturation) {

    /**
     * コンストラクタ
     *
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    init {
        this.setCreativeTab(CreativeTabsInit.creativeTab)
    }
}
