package jp.artan.japanesefoodmod.raw_materials.crop;

import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFoodAsSeed;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialPlant;

public class RawMaterialSameCropAsSeed extends SameCropAsSeed {
    /**
     * コンストラクタ
     * 
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public RawMaterialSameCropAsSeed(String name, int amount, float saturation) {
        super(new RawMaterialFoodAsSeed(name, amount, saturation, new RawMaterialPlant(name)));
    }
}
