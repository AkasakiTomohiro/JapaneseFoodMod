package jp.artan.japanesefoodmod.raw_materials;

import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed;
import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.fish.RawMaterialFish;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class JapaneseFoodRawMaterials
{
    public static CreativeTabs creativeTab = new RawMaterialsCreativeTab();

    public static final JapaneseFood Banana = new RawMaterialFood("banana", 1, 0.5F);

    public static final SameCropAsSeed Soy = new RawMaterialSameCropAsSeed("soy", 1, 0.5F);

    public static final RawMaterialFish ROW_FISH = new RawMaterialFish("row_fish", false);

    public static final RawMaterialFish COOKED_FISH = new RawMaterialFish("baked_fish", true);

    public static void registerItems(RegistryEvent.Register<Item> event) {
        Banana.registerItem(event);
        Soy.registerItem(event);
        ROW_FISH.registerItem(event);
        COOKED_FISH.registerItem(event);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        Soy.registerBlock(event);
    }

    public static void registerModels(ModelRegistryEvent event) {
        Banana.registerModel(event);
        Soy.registerModel(event);
        ROW_FISH.registerModel(event);
        COOKED_FISH.registerModel(event);
    }

    /**
     * 清廉レシピを登録
     * @param event
     */
    public void init(FMLInitializationEvent event) {
//        GameRegistry.addSmelting();
    }
}
