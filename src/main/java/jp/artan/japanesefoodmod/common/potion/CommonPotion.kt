package jp.artan.japanesefoodmod.common.potion;

class CommonPotion(name: String, isBadEffectIn: Boolean, liquidColorIn: Int) {
    val potion = JapanesePotion(name, isBadEffectIn, liquidColorIn)
    val type = JapanesePotionType(name)
}
