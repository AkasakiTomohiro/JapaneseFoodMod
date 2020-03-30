package jp.artan.japanesefoodmod.common.potion;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import net.minecraft.potion.PotionType;

import static jp.artan.japanesefoodmod.init.Init.POTION_TYPES;

public class JapanesePotionType extends PotionType {
    private final String name;

    public JapanesePotionType(String name) {
        super();
        this.name = name;
        this.setRegistryName(JapaneseFoodMod.MODID, this.name);

        POTION_TYPES.add(this);
    }
}
