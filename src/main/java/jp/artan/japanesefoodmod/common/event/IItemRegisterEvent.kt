package jp.artan.japanesefoodmod.common.event

import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent

interface IItemRegisterEvent {

    /**
     * Register Item
     *
     * @param event
     */
    fun registerItem(event: RegistryEvent.Register<Item>)

    /**
     * Register Model
     *
     * @param event
     */
    fun registerModel(event: ModelRegistryEvent)
}
