package jp.artan.japanesefoodmod.raw_materials.wood;

import jp.artan.japanesefoodmod.common.wood.FruitSapling;
import jp.artan.japanesefoodmod.common.world.WorldGenSupplier;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;

public class RawMaterialsFruitSapling extends FruitSapling {
    public RawMaterialsFruitSapling(String name, WorldGenSupplier supplier) {
        super(name, supplier);
        this.setCreativeTab(JapaneseFoodRawMaterials.fruitTreeCreativeTab);
    }
}
