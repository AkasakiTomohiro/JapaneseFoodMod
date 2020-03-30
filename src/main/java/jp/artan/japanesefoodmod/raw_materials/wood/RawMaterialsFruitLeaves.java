package jp.artan.japanesefoodmod.raw_materials.wood;

import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;

public class RawMaterialsFruitLeaves extends FruitLeaves {

    public RawMaterialsFruitLeaves(String name) {
        super(name);
        this.setCreativeTab(CreativeTabsInit.fruitTreeCreativeTab);
    }
}
