package jp.artan.japanesefoodmod.raw_materials.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

public class RawMaterialPlant extends JapaneseFoodPlant {
    public RawMaterialPlant(String name) {
        super(name);
        this.setCreativeTab(JapaneseFoodRawMaterials.creativeTab);
    }

    @Override
    public void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(this);
    }
}
