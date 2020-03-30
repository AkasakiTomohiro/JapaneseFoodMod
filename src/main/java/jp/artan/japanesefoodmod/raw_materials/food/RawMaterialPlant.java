package jp.artan.japanesefoodmod.raw_materials.food;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;

public class RawMaterialPlant extends JapaneseFoodPlant {
    public RawMaterialPlant(String name) {
        super(name);
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab);
    }
}
