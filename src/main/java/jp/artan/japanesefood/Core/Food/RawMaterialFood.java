package jp.artan.japanesefood.Core.Food;

import jp.artan.japanesefood.Core.JapaneseFoodCoreMod;
import jp.artan.japanesefood.Common.FoodClass.JapaneseFood;

public class RawMaterialFood extends JapaneseFood {

    /**
     * コンストラクタ
     * @param name 食べ物の名前(※英字小文字のみ)
     * @param amount 回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public RawMaterialFood(String name, int amount, float saturation) {
        super(name, amount, saturation);
        this.setCreativeTab(JapaneseFoodCoreMod.creativeTab);
        this.setRegistryName(JapaneseFoodCoreMod.MODID, name);
    }
}
