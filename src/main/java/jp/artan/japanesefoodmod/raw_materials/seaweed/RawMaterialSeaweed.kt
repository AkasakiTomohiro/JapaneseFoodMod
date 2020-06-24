package jp.artan.japanesefoodmod.raw_materials.seaweed

import jp.artan.japanesefoodmod.common.seaweeds.CustomSeaweeds
import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenSeaweed
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood

class RawMaterialSeaweed(name: String, amount: Int, saturation: Float, chance: Int, worldGen: WorldGenSeaweed) :
        CustomSeaweeds(RawMaterialFood(name, amount, saturation), RawMaterialSeaweedBlock(name, chance), worldGen) {

}
