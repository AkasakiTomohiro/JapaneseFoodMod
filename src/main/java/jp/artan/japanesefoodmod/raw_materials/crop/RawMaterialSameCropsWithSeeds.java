package jp.artan.japanesefoodmod.raw_materials.crop;

import jp.artan.japanesefoodmod.common.crop.CropsWithSeeds;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialPlant;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialSeed;

public class RawMaterialSameCropsWithSeeds extends CropsWithSeeds {
    /**
     * コンストラクタ
     * @param name 食べ物の名前(※英字小文字のみ)
     * @param amount 回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public RawMaterialSameCropsWithSeeds(String name, int amount, float saturation) {
        super(new RawMaterialFood(name, amount, saturation), new RawMaterialSeed(name, new RawMaterialPlant(name)));
    }
}
