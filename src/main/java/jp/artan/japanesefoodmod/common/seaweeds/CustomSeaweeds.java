package jp.artan.japanesefoodmod.common.seaweeds;

import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenSeaweed;
import net.minecraft.block.Block;

public class CustomSeaweeds {

    public final CustomSeaweedBlock block;
    public final WorldGenSeaweed worldGen;
    //    public final JapaneseFood food;

    public CustomSeaweeds(String name, Block topBlock, int chance) {
        //        this.food = food;
        this.block = new CustomSeaweedBlock(name, topBlock, chance);
        this.worldGen = new WorldGenSeaweed(false, this.block);
    }

    public WorldGenSeaweed getWorldGenerator(Boolean flag) {
        return this.worldGen;
    }
}
