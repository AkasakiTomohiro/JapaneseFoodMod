package jp.artan.japanesefoodmod.common.seaweeds;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenSeaweed;

public abstract class CustomSeaweeds {

    public final CustomSeaweedBlock block;
    public final WorldGenSeaweed worldGen;
    public final JapaneseFood food;

    public CustomSeaweeds(JapaneseFood food, CustomSeaweedBlock block, WorldGenSeaweed worldGen) {
        this.food = food;
        this.block = block;
        this.worldGen = worldGen;

        this.block.setItem(this.food);
        this.worldGen.setBlockStateWood(this.block);
    }

    public WorldGenSeaweed getWorldGenerator(Boolean flag) {
        return this.worldGen;
    }
}
