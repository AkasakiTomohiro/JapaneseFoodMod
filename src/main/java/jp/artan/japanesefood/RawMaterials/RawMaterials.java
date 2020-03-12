package jp.artan.japanesefood.RawMaterials;

import jp.artan.japanesefood.Common.crop.SameCropAsSeed;
import jp.artan.japanesefood.RawMaterials.crop.RawMaterialSameCropAsSeed;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public class RawMaterials {

//    public static final JapaneseFood Banana = new RawMaterialFood("banana", 1, 0.5F);

    public static final SameCropAsSeed Soy = new RawMaterialSameCropAsSeed("soy", 1, 0.5F);

//    public static final CropsWithSeeds Banana = new RawMaterialSameCropsWithSeeds("banana", 1, 0.5F);

    public static void registerItem(RegistryEvent.Register<Item> event) {
//        Banana.registerItem(event);
        Soy.registerItem(event);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
//        Banana.registerBlock(event);
        Soy.registerBlock(event);
    }

    public static void registerModel(ModelRegistryEvent event) {
//        Banana.registerModel(event);
        Soy.registerModel(event);
    }
}
