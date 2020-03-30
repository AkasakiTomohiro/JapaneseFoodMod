package jp.artan.japanesefoodmod.raw_materials.wood;

import jp.artan.japanesefoodmod.common.wood.FruitSapling;
import jp.artan.japanesefoodmod.common.world.tree.WorldGenSupplier;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;

public class RawMaterialsFruitSapling extends FruitSapling {
    public RawMaterialsFruitSapling(String name, WorldGenSupplier supplier) {
        super(name, supplier);
        this.setCreativeTab(CreativeTabsInit.fruitTreeCreativeTab);
    }
}
