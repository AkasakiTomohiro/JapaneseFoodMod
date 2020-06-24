package jp.artan.japanesefoodmod.init

import jp.artan.japanesefoodmod.init.BlockInit.Companion.ALMOND
import jp.artan.japanesefoodmod.init.BlockInit.Companion.BANANA
import jp.artan.japanesefoodmod.init.BlockInit.Companion.CHESTNUT
import jp.artan.japanesefoodmod.init.BlockInit.Companion.CITRON
import jp.artan.japanesefoodmod.init.BlockInit.Companion.GRAPE
import jp.artan.japanesefoodmod.init.BlockInit.Companion.JUGLANS
import jp.artan.japanesefoodmod.init.BlockInit.Companion.MANDARIN_ORANGE
import jp.artan.japanesefoodmod.init.BlockInit.Companion.ORANGE
import jp.artan.japanesefoodmod.init.ItemInit.Companion.CLUEA_PALLASII
import jp.artan.japanesefoodmod.init.ItemInit.Companion.CLUEA_PALLASII_BAKED
import jp.artan.japanesefoodmod.init.ItemInit.Companion.DRIED_SQUID
import jp.artan.japanesefoodmod.init.ItemInit.Companion.RAISIN
import jp.artan.japanesefoodmod.init.ItemInit.Companion.SQUID
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.registry.GameRegistry

class RecipeInit {
    companion object {
        fun smelting(event: FMLInitializationEvent) {
            // 精錬レシピ登録
            GameRegistry.addSmelting(GRAPE.fruit, ItemStack(RAISIN, 1), 0.4F)
            GameRegistry.addSmelting(CLUEA_PALLASII, ItemStack(CLUEA_PALLASII_BAKED, 1), 0.4F)
            GameRegistry.addSmelting(SQUID, ItemStack(DRIED_SQUID, 1), 0.4F)
        }

        fun registerOreDictionaryEntries(event: FMLInitializationEvent) {
            // 鉱石辞書登録
            BANANA.registerOreDictionaryEntries()
            GRAPE.registerOreDictionaryEntries()
            ALMOND.registerOreDictionaryEntries()
            JUGLANS.registerOreDictionaryEntries()
            CITRON.registerOreDictionaryEntries()
            ORANGE.registerOreDictionaryEntries()
            MANDARIN_ORANGE.registerOreDictionaryEntries()
            CHESTNUT.registerOreDictionaryEntries()
        }
    }
}
