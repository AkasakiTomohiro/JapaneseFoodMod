package jp.artan.japanesefoodmod.common.event;

import net.minecraft.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public interface IBlockRegisterEvent {

    /**
     * Register Block
     * @param event
     */
    void registerBlock(RegistryEvent.Register<Block> event);

    /**
     * Register Model
     * @param event
     */
    void registerModel(ModelRegistryEvent event);
}
