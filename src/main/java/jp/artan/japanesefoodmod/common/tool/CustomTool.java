package jp.artan.japanesefoodmod.common.tool;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import jp.artan.japanesefoodmod.init.ItemInit;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

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
public class CustomTool extends Item implements IItemRegisterEvent {
    public final String name;
    public CustomTool(String name) {
        super();
        this.name = name;

        this.setRegistryName(JapaneseFoodMod.MODID, this.name);
        this.setUnlocalizedName(this.name);
        this.setCreativeTab(CreativeTabsInit.toolCreativeTab);
        this.setMaxStackSize(1);
        this.setContainerItem(this);

        ItemInit.ITEMS.add(this);
    }

    /**
     * アイテムを登録する
     *
     * @param event
     */
    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    /**
     * モデルを登録する
     *
     * @param event
     */
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodMod.MODID, this.name), "inventory"));
    }
}
