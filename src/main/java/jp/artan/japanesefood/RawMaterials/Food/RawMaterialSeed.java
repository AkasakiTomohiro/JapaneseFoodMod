package jp.artan.japanesefood.RawMaterials.Food;

import jp.artan.japanesefood.Common.FoodClass.JapaneseFoodPlant;
import jp.artan.japanesefood.Common.FoodClass.JapaneseFoodSeed;
import jp.artan.japanesefood.RawMaterials.JapaneseFoodRawMaterialsMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class RawMaterialSeed extends JapaneseFoodSeed {
    public RawMaterialSeed(String name, JapaneseFoodPlant block) {
        super(name, block);
        this.setCreativeTab(JapaneseFoodRawMaterialsMod.creativeTab);
        this.setRegistryName(JapaneseFoodRawMaterialsMod.MODID, this.Name);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                this,
                0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodRawMaterialsMod.MODID, this.Name), "inventory"));
    }
}
