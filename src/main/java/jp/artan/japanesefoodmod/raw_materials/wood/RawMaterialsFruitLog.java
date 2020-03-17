package jp.artan.japanesefoodmod.raw_materials.wood;

import jp.artan.japanesefoodmod.common.wood.FruitLog;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;

public class RawMaterialsFruitLog extends FruitLog {
    public RawMaterialsFruitLog(String name) {
        super(name);
        this.setCreativeTab(JapaneseFoodRawMaterials.creativeTab);
    }
}
