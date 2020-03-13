package jp.artan.japanesefoodmod.raw_materials.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFish;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;

public class RawMaterialFish extends JapaneseFish {

    /**
     * コンストラクタ
     * @param name 食べ物の名前(※英字小文字のみ)
     * @param cooked 調理済みがどうか
     */
    public RawMaterialFish(String name, boolean cooked) {
        super(name, cooked);
        this.setCreativeTab(JapaneseFoodRawMaterials.creativeTab);
    }
}
