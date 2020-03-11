package jp.artan.japanesefood.RawMaterials;

import jp.artan.japanesefood.Common.FoodClass.JapaneseFood;
import jp.artan.japanesefood.Common.FoodClass.SameCropAsSeed;
import jp.artan.japanesefood.RawMaterials.Food.RawMaterialFood;
import jp.artan.japanesefood.RawMaterials.Food.RawMaterialSameCropAsSeed;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public class RawMaterials {

    public static final JapaneseFood Banana = new RawMaterialFood("banana", 2, 0.5F);

    public static final SameCropAsSeed Soy = new RawMaterialSameCropAsSeed("soy", 2, 0.5F);

    public static void registerItem(RegistryEvent.Register<Item> event) {
        Banana.registerItem(event);
        Soy.registerItem(event);
    }

    public static void registerModel(ModelRegistryEvent event) {
        Banana.registerModel(event);
        Soy.registerModel(event);
    }
}
