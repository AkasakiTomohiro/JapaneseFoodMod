package jp.artan.japanesefood.souvenir;

import jp.artan.japanesefood.common.food.JapaneseFood;
import jp.artan.japanesefood.souvenir.food.SouvenirFood;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public class Souvenir {
    public static final JapaneseFood TokyoBanana = new SouvenirFood("tokyo_banana", 3, 0.5F);

    public static void registerItem(RegistryEvent.Register<Item> event) {
        TokyoBanana.registerItem(event);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    public static void registerModel(ModelRegistryEvent event) {
        TokyoBanana.registerModel(event);
    }
}
