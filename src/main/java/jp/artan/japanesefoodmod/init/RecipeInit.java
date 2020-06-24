package jp.artan.japanesefoodmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static jp.artan.japanesefoodmod.init.BlockInit.*;
import static jp.artan.japanesefoodmod.init.ItemInit.*;

public class RecipeInit {
    public static void smelting(FMLInitializationEvent event) {
        // 精錬レシピ登録
        GameRegistry.addSmelting(GRAPE.fruit, new ItemStack(RAISIN, 1), 0.4F);
        GameRegistry.addSmelting(CLUEA_PALLASII, new ItemStack(CLUEA_PALLASII_BAKED, 1), 0.4F);
        GameRegistry.addSmelting(SQUID, new ItemStack(DRIED_SQUID, 1), 0.4F);
    }

    public static void registerOreDictionaryEntries(FMLInitializationEvent event) {
        // 鉱石辞書登録
        FRUIT_TREES.forEach(f -> {
            f.registerOreDictionaryEntries();
        });
    }
}
