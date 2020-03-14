package jp.artan.japanesefoodmod.souvenir.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.souvenir.JapaneseFoodSouvenir;

public class SouvenirFood extends JapaneseFood {

    /**
     * コンストラクタ
     * 
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public SouvenirFood(String name, int amount, float saturation) {
        super(name, amount, saturation);
        this.setCreativeTab(JapaneseFoodSouvenir.creativeTab);
    }
}
