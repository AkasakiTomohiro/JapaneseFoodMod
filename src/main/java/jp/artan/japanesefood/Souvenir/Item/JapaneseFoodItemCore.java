package jp.artan.japanesefood.Souvenir.Item;

import jp.artan.japanesefood.Souvenir.JapaneseFoodSouvenirMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class JapaneseFoodItemCore {

    public static final Item Banana = new ItemFood(1, 0.5F, false)
            .setCreativeTab(JapaneseFoodSouvenirMod.creativeTab)
            .setUnlocalizedName("banana")
            .setRegistryName(JapaneseFoodSouvenirMod.MODID, "banana");

    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(JapaneseFoodItemCore.Banana);
    }

    public static void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                JapaneseFoodItemCore.Banana,
                0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodSouvenirMod.MODID, "banana"), "inventory"));
    }
}
