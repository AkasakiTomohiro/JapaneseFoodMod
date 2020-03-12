package jp.artan.japanesefood.raw_materials.food;

import jp.artan.japanesefood.common.food.JapaneseFoodAsSeed;
import jp.artan.japanesefood.common.food.JapaneseFoodPlant;
import jp.artan.japanesefood.raw_materials.JapaneseFoodRawMaterialsMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class RawMaterialFoodAsSeed extends JapaneseFoodAsSeed {

    /**
     * コンストラクタ
     * @param name 食べ物の名前(※英字小文字のみ)
     * @param amount 回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public RawMaterialFoodAsSeed(String name, int amount, float saturation, JapaneseFoodPlant plant) {
        super(name, amount, saturation,plant);
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
