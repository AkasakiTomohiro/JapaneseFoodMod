package jp.artan.japanesefood.souvenir.food;

import jp.artan.japanesefood.common.food.JapaneseFood;
import jp.artan.japanesefood.raw_materials.JapaneseFoodRawMaterialsMod;
import jp.artan.japanesefood.souvenir.JapaneseFoodSouvenirMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class SouvenirFood extends JapaneseFood {

    /**
     * コンストラクタ
     * @param name 食べ物の名前(※英字小文字のみ)
     * @param amount 回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public SouvenirFood(String name, int amount, float saturation) {
        super(name, amount, saturation);
        this.setCreativeTab(JapaneseFoodSouvenirMod.creativeTab);
        this.setRegistryName(JapaneseFoodSouvenirMod.MODID, name);
    }

    @Override
    public void registerModel(ModelRegistryEvent event){
        ModelLoader.setCustomModelResourceLocation(
                this,
                0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodSouvenirMod.MODID, this.Name), "inventory"));
    }
}
