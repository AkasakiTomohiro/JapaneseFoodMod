package jp.artan.japanesefoodmod.raw_materials.crop;

import jp.artan.japanesefoodmod.raw_materials.food.*;

public class RawMaterialSameWaterCropsWithSeeds extends RawMaterialSameCropsWithSeeds {
    /**
     * コンストラクタ
     *
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public RawMaterialSameWaterCropsWithSeeds(String name, int amount, float saturation) {
        super(new RawMaterialFood(name, amount, saturation), new RawMaterialWaterSeed(name, new RawMaterialWaterPlant(name)));
    }
}
