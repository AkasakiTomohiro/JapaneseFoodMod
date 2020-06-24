package jp.artan.japanesefoodmod.raw_materials.food.soy

import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFoodAsSeed

class Soy : RawMaterialSameCropAsSeed(RawMaterialFoodAsSeed("soy", 1, 0.1F, SoyPlant("soy"))) {
}
