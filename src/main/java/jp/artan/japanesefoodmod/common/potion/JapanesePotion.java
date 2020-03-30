package jp.artan.japanesefoodmod.common.potion;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import net.minecraft.potion.Potion;

import static jp.artan.japanesefoodmod.init.Init.POTIONS;

public class JapanesePotion extends Potion {
    private final String name;

    public JapanesePotion(String name, boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        this.name = name;
        this.setPotionName(this.name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.name);

        POTIONS.add(this);
    }

}