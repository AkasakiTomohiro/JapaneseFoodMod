package jp.artan.japanesefood.RawMaterials.crop;

import jp.artan.japanesefood.Common.crop.CropsWithSeeds;
import jp.artan.japanesefood.RawMaterials.Food.RawMaterialFood;
import jp.artan.japanesefood.RawMaterials.Food.RawMaterialPlant;
import jp.artan.japanesefood.RawMaterials.Food.RawMaterialSeed;

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
