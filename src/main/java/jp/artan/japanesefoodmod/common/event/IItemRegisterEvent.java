package jp.artan.japanesefoodmod.common.event;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public interface IItemRegisterEvent {

    /**
     * Register Model
     * 
     * @param event
     */
    void registerModel(ModelRegistryEvent event);
}
