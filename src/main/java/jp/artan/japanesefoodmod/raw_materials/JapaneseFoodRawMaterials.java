package jp.artan.japanesefoodmod.raw_materials;

import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed;
import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.common.tool.CustomTool;
import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood;
import jp.artan.japanesefoodmod.init.tabs.FruitTreeCreativeTab;
import jp.artan.japanesefoodmod.init.tabs.RawMaterialsCreativeTab;
import jp.artan.japanesefoodmod.raw_materials.wood.RawMaterialsFruitTree;
import jp.artan.japanesefoodmod.raw_materials.world.tree.BananaTreeSupplier;
import jp.artan.japanesefoodmod.raw_materials.world.tree.GrapeTreeSupplier;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class JapaneseFoodRawMaterials {
    // クリエイティブタブ
    public static CreativeTabs rawMaterialsCreativeTab = new RawMaterialsCreativeTab();
    public static CreativeTabs fruitTreeCreativeTab = new FruitTreeCreativeTab();

    // ツール
    public static final CustomTool GROUND_WOOD = new CustomTool("ground_wood");

    // 果樹
    public static final FruitTree BANANA = new RawMaterialsFruitTree("banana", 1, 0.3F, new BananaTreeSupplier());
    public static final FruitTree GRAPE = new RawMaterialsFruitTree("grape", 1, 0.3F, new GrapeTreeSupplier());

    // 作物
    public static final SameCropAsSeed SOY = new RawMaterialSameCropAsSeed("soy", 1, 0.1F);

    // 魚

    // 加工品
    public static final JapaneseFood BUTTER = new RawMaterialFood("butter", 1, 0.3F);
    public static final JapaneseFood RAISIN = new RawMaterialFood("raisin", 1, 0.2F);
    public static final JapaneseFood SALT = new RawMaterialFood("salt", 0, 0.1F);

    public static void preInit(FMLPreInitializationEvent event) {
    }

    /**
     * 清廉レシピを登録
     * 
     * @param event
     */
    public static void init(FMLInitializationEvent event) {
        // 精錬レシピ登録
        GameRegistry.addSmelting(GRAPE.fruit, new ItemStack(RAISIN, 1), 0.4F);

        // 鉱石辞書登録
        BANANA.registerOreDictionaryEntries();
        GRAPE.registerOreDictionaryEntries();
    }

    public static void postInit(FMLPostInitializationEvent event) {
    }
}
