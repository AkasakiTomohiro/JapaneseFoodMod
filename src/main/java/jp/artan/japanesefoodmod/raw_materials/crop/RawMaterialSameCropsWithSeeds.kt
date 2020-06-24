package jp.artan.japanesefoodmod.raw_materials.crop

import jp.artan.japanesefoodmod.common.crop.CropsWithSeeds
import jp.artan.japanesefoodmod.common.food.JapaneseFood
import jp.artan.japanesefoodmod.common.food.JapaneseFoodSeed
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialPlant
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialSeed

open class RawMaterialSameCropsWithSeeds : CropsWithSeeds {
    /**
     * コンストラクタ
     *
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    constructor(name: String, amount: Int, saturation: Float) : super(RawMaterialFood(name, amount, saturation), RawMaterialSeed(name, RawMaterialPlant(name))) {
    }

    constructor(food: JapaneseFood, seed: JapaneseFoodSeed) : super(food, seed) {
    }
}
