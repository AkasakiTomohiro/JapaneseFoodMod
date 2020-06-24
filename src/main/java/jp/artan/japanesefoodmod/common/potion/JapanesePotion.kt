package jp.artan.japanesefoodmod.common.potion

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.init.Init.Companion.POTIONS
import net.minecraft.potion.Potion

class JapanesePotion(private val potionName: String, isBadEffectIn: Boolean, liquidColorIn: Int) : Potion(isBadEffectIn, liquidColorIn) {

    init {
        this.setPotionName(this.potionName)
        this.setRegistryName(JapaneseFoodMod.MODID, this.potionName)

        POTIONS.add(this)
    }

    override fun getName(): String {
        return this.potionName
    }
}