package jp.artan.japanesefood.Common.Event;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public interface IItemRegisterEvent {

    /**
     * Register Item
     * @param event
     */
    void registerItem(RegistryEvent.Register<Item> event);

    /**
     * Register Model
     * @param event
     */
    void registerModel(ModelRegistryEvent event);
}
