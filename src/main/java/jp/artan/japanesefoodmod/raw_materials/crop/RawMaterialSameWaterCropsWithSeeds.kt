package jp.artan.japanesefoodmod.raw_materials.crop

import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialWaterPlant
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialWaterSeed

class RawMaterialSameWaterCropsWithSeeds : RawMaterialSameCropsWithSeeds {
    /**
     * コンストラクタ
     *
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    constructor(name: String, amount: Int, saturation: Float) : super(RawMaterialFood(name, amount, saturation), RawMaterialWaterSeed(name, RawMaterialWaterPlant(name))) {
    }
}
