package jp.artan.japanesefoodmod.raw_materials.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodAsSeed;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;

public class RawMaterialFoodAsSeed extends JapaneseFoodAsSeed {

    /**
     * コンストラクタ
     * 
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public RawMaterialFoodAsSeed(String name, int amount, float saturation, JapaneseFoodPlant plant) {
        super(name, amount, saturation, plant);
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab);
    }
}
