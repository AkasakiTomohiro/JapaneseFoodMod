package jp.artan.japanesefoodmod.raw_materials;

import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed;
import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.tabs.FruitTreeCreativeTab;
import jp.artan.japanesefoodmod.raw_materials.tabs.RawMaterialsCreativeTab;
import jp.artan.japanesefoodmod.raw_materials.wood.RawMaterialsFruitTree;
import jp.artan.japanesefoodmod.raw_materials.world.tree.BananaTreeSupplier;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class JapaneseFoodRawMaterials {
    // クリエイティブタブ
    public static CreativeTabs rawMaterialsCreativeTab = new RawMaterialsCreativeTab();
    public static CreativeTabs fruitTreeCreativeTab = new FruitTreeCreativeTab();

    // 果樹
    public static final FruitTree BANANA = new RawMaterialsFruitTree("banana", 1, 0.5F, new BananaTreeSupplier());

    // 作物
    public static final SameCropAsSeed SOY = new RawMaterialSameCropAsSeed("soy", 1, 0.5F);

    // 魚

    public static void preInit(FMLPreInitializationEvent event) {
    }

    /**
     * 清廉レシピを登録
     * 
     * @param event
     */
    public static void init(FMLInitializationEvent event) {
        // 精錬レシピ登録
//        GameRegistry.addSmelting(FISH, new ItemStack(FISH_BAKED, 1), 0.4F);

        // 鉱石辞書登録
        BANANA.registerOreDictionaryEntries();
    }

    public static void postInit(FMLPostInitializationEvent event) {
    }
}
