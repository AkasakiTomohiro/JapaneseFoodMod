package jp.artan.japanesefoodmod.raw_materials.wood;

import jp.artan.japanesefoodmod.common.wood.FruitBlock;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;

public class RawMaterialsFruitBlock extends FruitBlock {

    public RawMaterialsFruitBlock(String name) {
        super(name);
        this.setCreativeTab(JapaneseFoodRawMaterials.fruitTreeCreativeTab);
    }
}
