package jp.artan.japanesefoodmod.raw_materials.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodSeed;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;

public class RawMaterialSeed extends JapaneseFoodSeed {
    public RawMaterialSeed(String name, JapaneseFoodPlant block) {
        super(name, block);
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab);
    }
}
