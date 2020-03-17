package jp.artan.japanesefoodmod.common.event;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public interface IBlockRegisterEvent {

    /**
     * ブロックを追加
     *
     * @param event
     */
    void registerBlock(RegistryEvent.Register<Block> event);

    /**
     * モデルを追加
     *
     * @param event
     */
    void registerModel(ModelRegistryEvent event);

    /**
     * ブロックをアイテムとして取得するときに実装
     *
     * @param event
     */
    void registerItemBlocks(RegistryEvent.Register<Item> event);
}
