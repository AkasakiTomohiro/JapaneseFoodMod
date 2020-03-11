package jp.artan.japanesefood.Common.FoodClass;

import jp.artan.japanesefood.Common.Event.IItemRegisterEvent;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public abstract class SameCropAsSeed implements IItemRegisterEvent {

    public final JapaneseFood Food;

    /**
     * コンストラクタ
     * @param food 食べ物の名前(※英字小文字のみ)
     */
    public SameCropAsSeed(JapaneseFood food) {
        this.Food = food;
    }

    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        this.Food.registerItem(event);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        this.Food.registerModel(event);
    }
}
