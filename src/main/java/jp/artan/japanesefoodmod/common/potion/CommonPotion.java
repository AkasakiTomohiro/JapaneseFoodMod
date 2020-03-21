package jp.artan.japanesefoodmod.common.potion;

public class CommonPotion {
    public final JapanesePotion potion;
    public final JapanesePotionType type;

    public CommonPotion(String name, boolean isBadEffectIn, int liquidColorIn) {
        this.potion = new JapanesePotion(name, isBadEffectIn, liquidColorIn);
        this.type = new JapanesePotionType(name);
    }
}
