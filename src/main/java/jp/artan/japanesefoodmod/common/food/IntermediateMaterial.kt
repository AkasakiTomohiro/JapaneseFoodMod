package jp.artan.japanesefoodmod.common.food

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

class IntermediateMaterial(val name: String) : Item(), IItemRegisterEvent {
    init {
        this.setUnlocalizedName(this.name)
        this.setRegistryName(JapaneseFoodMod.MODID, this.name)
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab)

        ItemInit.ITEMS.add(this)
    }

    /**
     * アイテムを登録する
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
