package jp.artan.japanesefood.RawMaterials;

import jp.artan.japanesefood.Common.FoodClass.JapaneseFood;
import jp.artan.japanesefood.RawMaterials.Food.RawMaterialFood;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class RawMaterials {

    public static final JapaneseFood Banana = new RawMaterialFood("banana", 2, 0.5F);

    public static void registerItem(RegistryEvent.Register<Item> event) {
        Banana.registerItem(event);
    }

    public static void registerModel(ModelRegistryEvent event) {
        Banana.registerModel(event);
    }
}
