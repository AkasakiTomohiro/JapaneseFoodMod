package jp.artan.japanesefoodmod.raw_materials.seaweed;

import jp.artan.japanesefoodmod.common.seaweeds.CustomSeaweeds;
import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenSeaweed;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood;

public class RawMaterialSeaweed extends CustomSeaweeds {
    public RawMaterialSeaweed(String name, int amount, float saturation, int chance, WorldGenSeaweed worldGen) {
        super(new RawMaterialFood(name, amount, saturation), new RawMaterialSeaweedBlock(name, chance), worldGen);
    }
}
