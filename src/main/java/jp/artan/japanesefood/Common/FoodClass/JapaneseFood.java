package jp.artan.japanesefood.Common.FoodClass;

import jp.artan.japanesefood.RawMaterials.JapaneseFoodRawMaterialsMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

/**
 * 食べ物の共通クラス
 */
public abstract class JapaneseFood extends ItemFood {

    protected final String Name;

    /**
     * コンストラクタ
     * @param name 食べ物の名前(※英字小文字のみ)
     * @param amount 回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public JapaneseFood(String name, int amount, float saturation) {
        super(amount, saturation, false);
        this.Name = name;
        setUnlocalizedName(this.Name);
    }

    /**
     * アイテムを登録する
     * @param event
     */
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    /**
     * モデルを登録する
     * @param event
     */
    public abstract void registerModel(ModelRegistryEvent event);
}
