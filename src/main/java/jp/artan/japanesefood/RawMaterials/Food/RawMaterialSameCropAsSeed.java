package jp.artan.japanesefood.RawMaterials.Food;

import jp.artan.japanesefood.Common.FoodClass.JapaneseFoodPlant;
import jp.artan.japanesefood.Common.FoodClass.SameCropAsSeed;

public class RawMaterialSameCropAsSeed extends SameCropAsSeed {
    /**
     * コンストラクタ
     * @param name 食べ物の名前(※英字小文字のみ)
     * @param amount 回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public RawMaterialSameCropAsSeed(String name, int amount, float saturation) {
        super(new RawMaterialSeed(name, new RawMaterialPlant(name)));
    }
}
