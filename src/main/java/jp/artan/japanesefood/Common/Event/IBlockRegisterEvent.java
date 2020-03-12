package jp.artan.japanesefood.Common.Event;

import net.minecraft.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public interface IBlockRegisterEvent {

    /**
     * ブロックを登録する
     * @param event
     */
    void registerBlock(RegistryEvent.Register<Block> event);

    /**
     * モデルを登録する
     * @param event
     */
    void registerModel(ModelRegistryEvent event);
}
