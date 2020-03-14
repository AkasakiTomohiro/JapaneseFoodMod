package jp.artan.japanesefoodmod.souvenir;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.souvenir.food.SouvenirFood;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class JapaneseFoodSouvenir {
    public static CreativeTabs creativeTab = new SouvenirCreativeTab();

    public static final JapaneseFood TokyoBanana = new SouvenirFood("tokyo_banana", 3, 0.5F);

    public static void registerModels(ModelRegistryEvent event) {
        TokyoBanana.registerModel(event);
    }

    public static void preInit(FMLPreInitializationEvent event) {
    }

    /**
     * 清廉レシピを登録
     * 
     * @param event
     */
    public static void init(FMLInitializationEvent event) {
        // GameRegistry.addSmelting();
    }

    public static void postInit(FMLPostInitializationEvent event) {
    }
}
