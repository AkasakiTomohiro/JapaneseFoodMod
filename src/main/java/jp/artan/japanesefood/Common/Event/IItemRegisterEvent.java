package jp.artan.japanesefood.Common.Event;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public interface IItemRegisterEvent {

    /**
     * アイテムを登録する
     * @param event
     */
    void registerItem(RegistryEvent.Register<Item> event);

    /**
     * モデルを登録する
     * @param event
     */
    void registerModel(ModelRegistryEvent event);
}
