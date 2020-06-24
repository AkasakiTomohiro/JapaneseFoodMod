package jp.artan.japanesefoodmod.init

import jp.artan.japanesefoodmod.common.potion.CommonPotion
import java.util.ArrayList
import jp.artan.japanesefoodmod.common.potion.JapanesePotion
import jp.artan.japanesefoodmod.common.potion.JapanesePotionType

class Init {
    companion object {
        val POTIONS = ArrayList<JapanesePotion>()
        val POTION_TYPES = ArrayList<JapanesePotionType>()

//        val TEST_POTION = CommonPotion("test", false, 0xFFFFFF)
    }
}
