package jp.artan.japanesefoodmod.common.tool

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent
import jp.artan.japanesefoodmod.init.CreativeTabsInit
import jp.artan.japanesefoodmod.init.ItemInit
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent

/**
 * 単純ツールの共通クラス
 * @apiNote
 * ./lang/en_us.lang　言語設定
 *      item.${name}.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      item.${name}.name=XXXXX
 * ./models/item/${name}.json
 *      アイテムのテクスチャ情報を記述
 * ./textures/item/${name}.png
 *      アイテムのテクスチャ情報を記述
 */
class CustomTool(val name: String) : Item(), IItemRegisterEvent {
    init {
        this.setRegistryName(JapaneseFoodMod.MODID, name)
        this.setUnlocalizedName(name)
        this.setCreativeTab(CreativeTabsInit.toolCreativeTab)
        this.setMaxStackSize(1)
        this.setContainerItem(this)

        ItemInit.ITEMS.add(this)
    }

    /**
     * アイテムを登録する
     *
     * @param event
     */
    override fun registerItem(event: RegistryEvent.Register<Item>) {
        event.getRegistry().register(this)
    }

    /**
     * モデルを登録する
     *
     * @param event
     */
    override fun registerModel(event: ModelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                ModelResourceLocation(ResourceLocation(JapaneseFoodMod.MODID, this.name), "inventory"))
    }
}
