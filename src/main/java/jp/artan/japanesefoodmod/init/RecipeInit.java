package jp.artan.japanesefoodmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static jp.artan.japanesefoodmod.init.BlockInit.BANANA;
import static jp.artan.japanesefoodmod.init.BlockInit.GRAPE;
import static jp.artan.japanesefoodmod.init.ItemInit.RAISIN;

public class RecipeInit {
    public static void smelting(FMLInitializationEvent event) {
        // 精錬レシピ登録
        GameRegistry.addSmelting(GRAPE.fruit, new ItemStack(RAISIN, 1), 0.4F);
    }

    public static void registerOreDictionaryEntries(FMLInitializationEvent event) {
        // 鉱石辞書登録
        BANANA.registerOreDictionaryEntries();
        GRAPE.registerOreDictionaryEntries();
    }
}
