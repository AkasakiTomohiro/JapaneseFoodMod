package jp.artan.japanesefoodmod.raw_materials;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public class JapaneseFoodRawMaterials
{
    public static CreativeTabs creativeTab = new RawMaterialsCreativeTab();

    public static void registerItems(RegistryEvent.Register<Item> event) {
        RawMaterials.registerItem(event);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        RawMaterials.registerBlocks(event);
    }

    public static void registerModels(ModelRegistryEvent event) {
        RawMaterials.registerModel(event);
    }
}
