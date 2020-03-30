package jp.artan.japanesefoodmod.raw_materials.wood;

import jp.artan.japanesefoodmod.common.wood.FruitBlock;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;

public class RawMaterialsFruitBlock extends FruitBlock {

    public RawMaterialsFruitBlock(String name) {
        super(name);
        this.setCreativeTab(CreativeTabsInit.fruitTreeCreativeTab);
    }
}
