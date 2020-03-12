package jp.artan.japanesefoodmod.souvenir;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.souvenir.food.SouvenirFood;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public class JapaneseFoodSouvenir {
    public static CreativeTabs creativeTab = new SouvenirCreativeTab();

    public static final JapaneseFood TokyoBanana = new SouvenirFood("tokyo_banana", 3, 0.5F);

    public static void registerItems(RegistryEvent.Register<Item> event) {
        TokyoBanana.registerItem(event);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

    public static void registerModels(ModelRegistryEvent event) {
        TokyoBanana.registerModel(event);
    }
}
