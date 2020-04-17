package jp.artan.japanesefoodmod.raw_materials.food.soy;

import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFoodAsSeed;

public class Soy extends RawMaterialSameCropAsSeed {
    public Soy() {
        super(new RawMaterialFoodAsSeed("soy", 1, 0.1F, new SoyPlant("soy")));
    }
}
