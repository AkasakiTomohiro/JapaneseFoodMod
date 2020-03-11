package jp.artan.japanesefood.Core;

import jp.artan.japanesefood.Core.Food.RawMaterialFood;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class JapaneseFoodRawMaterials {

    public static final Item Banana = new RawMaterialFood("banana", 2, 0.5F);

    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(JapaneseFoodRawMaterials.Banana);
    }

    public static void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                JapaneseFoodRawMaterials.Banana,
                0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodCoreMod.MODID, "banana"), "inventory"));
    }
}
