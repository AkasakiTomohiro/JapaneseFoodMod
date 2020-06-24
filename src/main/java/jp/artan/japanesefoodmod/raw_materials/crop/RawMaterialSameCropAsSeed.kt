package jp.artan.japanesefoodmod.raw_materials.crop;

import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed
import jp.artan.japanesefoodmod.common.food.JapaneseFoodAsSeed
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFoodAsSeed
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialPlant

open class RawMaterialSameCropAsSeed : SameCropAsSeed {
    /**
     * コンストラクタ
     *
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    constructor(name: String, amount: Int, saturation: Float) : super(RawMaterialFoodAsSeed(name, amount, saturation, RawMaterialPlant(name))) {
    }

    constructor(seed: JapaneseFoodAsSeed) : super(seed) {
    }
}
