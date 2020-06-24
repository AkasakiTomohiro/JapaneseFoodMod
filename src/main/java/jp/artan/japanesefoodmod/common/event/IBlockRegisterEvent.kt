package jp.artan.japanesefoodmod.common.event

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent

interface IBlockRegisterEvent {

    /**
     * ブロックを追加
     *
     * @param event
     */
    fun registerBlock(event: RegistryEvent.Register<Block>)

    /**
     * モデルを追加
     *
     * @param event
     */
    fun registerModel(event: ModelRegistryEvent)

    /**
     * ブロックをアイテムとして取得するときに実装
     *
     * @param event
     */
    fun registerItemBlocks(event: RegistryEvent.Register<Item>)
}
