package jp.artan.japanesefoodmod.souvenir;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.souvenir.food.SouvenirFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class JapaneseFoodSouvenir {
    public static CreativeTabs creativeTab = new SouvenirCreativeTab();
    // 食べ物
    public static final JapaneseFood MARUSEI_BUTTER_SAND = new SouvenirFood("marusei_butter_sand", 2, 0.5F);
    public static final JapaneseFood KININ_TSUGARU_DUKE = new SouvenirFood("kinin_tsugaru_duke", 1, 0.1F);
    public static final JapaneseFood LE_DESERE = new SouvenirFood("le_desere", 2, 0.6F);
    public static final JapaneseFood KAMOMES_EGG = new SouvenirFood("kamomes_egg", 2, 0.8F);
    public static final JapaneseFood KOKYO = new SouvenirFood("kokyo", 2, 0.4F);
    public static final JapaneseFood HAGINOTSUKI = new SouvenirFood("haginotsuki", 2, 0.5F);
    public static final JapaneseFood KADEN_YUBESHI = new SouvenirFood("kaden_yubeshi", 2, 0.5F);
    public static final JapaneseFood YOSHIWARADENTYU = new SouvenirFood("yoshiwaradentyu", 2, 1.0F);
    public static final JapaneseFood KOIN_MANAKA = new SouvenirFood("koin_monaka", 2, 0.3F);
    public static final JapaneseFood TABIGARASU = new SouvenirFood("tabigarasu", 1, 0.2F);
    public static final JapaneseFood PEANUTS_MONAKA = new SouvenirFood("peanuts_monaka", 1, 1.0F);
    public static final JapaneseFood SOUKA_SENBEI = new SouvenirFood("souka_senbei", 2, 1.0F);
    public static final JapaneseFood TokyoBanana = new SouvenirFood("tokyo_banana", 2, 0.5F);
    public static final JapaneseFood HATO_SABLE = new SouvenirFood("hato_sable", 2, 1.0F);
    public static final JapaneseFood SASADANGO = new SouvenirFood("sasadango", 2, 1.2F);
    public static final JapaneseFood KANOKOMOTI = new SouvenirFood("kanokomoti", 1, 0.6F);

    public static void registerModels(ModelRegistryEvent event) {
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
