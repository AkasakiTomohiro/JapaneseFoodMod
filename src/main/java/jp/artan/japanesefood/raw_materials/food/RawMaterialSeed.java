package jp.artan.japanesefood.raw_materials.food;

import jp.artan.japanesefood.common.food.JapaneseFoodPlant;
import jp.artan.japanesefood.common.food.JapaneseFoodSeed;
import jp.artan.japanesefood.raw_materials.JapaneseFoodRawMaterialsMod;
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
