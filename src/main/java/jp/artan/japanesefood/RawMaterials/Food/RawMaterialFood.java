package jp.artan.japanesefood.RawMaterials.Food;

import jp.artan.japanesefood.RawMaterials.JapaneseFoodRawMaterialsMod;
import jp.artan.japanesefood.common.food.JapaneseFood;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class RawMaterialFood extends JapaneseFood {

    /**
     * コンストラクタ
     * @param name 食べ物の名前(※英字小文字のみ)
     * @param amount 回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public RawMaterialFood(String name, int amount, float saturation) {
        super(name, amount, saturation);
        this.setCreativeTab(JapaneseFoodRawMaterialsMod.creativeTab);
        this.setRegistryName(JapaneseFoodRawMaterialsMod.MODID, name);
    }

    @Override
    public void registerModel(ModelRegistryEvent event){
        ModelLoader.setCustomModelResourceLocation(
                this,
                0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodRawMaterialsMod.MODID, this.Name), "inventory"));
    }
}
