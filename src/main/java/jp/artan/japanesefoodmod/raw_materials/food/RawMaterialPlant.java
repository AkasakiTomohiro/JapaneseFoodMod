package jp.artan.japanesefoodmod.raw_materials.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;

public class RawMaterialPlant extends JapaneseFoodPlant {
    public RawMaterialPlant(String name) {
        super(name);
        this.setCreativeTab(JapaneseFoodRawMaterials.creativeTab);
    }
}
