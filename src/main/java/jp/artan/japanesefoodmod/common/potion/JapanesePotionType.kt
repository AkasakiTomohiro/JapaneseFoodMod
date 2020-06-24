package jp.artan.japanesefoodmod.common.potion

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.init.Init.Companion.POTION_TYPES
import net.minecraft.potion.PotionType

class JapanesePotionType(private val potionTypeName: String) : PotionType() {

    init {
        this.setRegistryName(JapaneseFoodMod.MODID, this.potionTypeName)
        POTION_TYPES.add(this)
    }
}
