package jp.artan.japanesefoodmod.common.food;

import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import net.minecraft.item.ItemFood;

/**
 * 食べ物の共通クラス
 */
public abstract class JapaneseFood extends ItemFood {

    protected final String Name;

    /**
     * コンストラクタ
     * 
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public JapaneseFood(String name, int amount, float saturation) {
        super(amount, saturation, false);
        this.Name = name;
        this.setUnlocalizedName(this.Name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.Name);

        Init.ITEMS.add(this);
    }
}
