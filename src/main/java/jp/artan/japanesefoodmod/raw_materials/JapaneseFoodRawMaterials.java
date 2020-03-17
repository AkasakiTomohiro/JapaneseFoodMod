package jp.artan.japanesefoodmod.raw_materials;

import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed;
import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood;
import jp.artan.japanesefoodmod.raw_materials.wood.RawMaterialsFruitTree;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class JapaneseFoodRawMaterials {
    // クリエイティブタブ
    public static CreativeTabs creativeTab = new RawMaterialsCreativeTab();

    // 果樹
    public static final FruitTree BANANA = new RawMaterialsFruitTree("banana", 1, 0.5F);

    // 作物
    public static final SameCropAsSeed Soy = new RawMaterialSameCropAsSeed("soy", 1, 0.5F);

    // 魚
    public static final JapaneseFood FISH = new RawMaterialFood("fish", 1, 0.5F);
    public static final JapaneseFood FISH_BAKED = new RawMaterialFood("fish_baked", 2, 1F);
    public static final JapaneseFood FISH2 = new RawMaterialFood("fish2", 1, 0.5F);

    public static void preInit(FMLPreInitializationEvent event) {
    }

    /**
     * 清廉レシピを登録
     * 
     * @param event
     */
    public static void init(FMLInitializationEvent event) {
        GameRegistry.addSmelting(FISH, new ItemStack(FISH_BAKED, 1), 0.4F);
    }

    public static void postInit(FMLPostInitializationEvent event) {
    }
}
