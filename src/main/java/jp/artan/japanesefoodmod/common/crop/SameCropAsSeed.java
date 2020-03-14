package jp.artan.japanesefoodmod.common.crop;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodAsSeed;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import net.minecraftforge.client.event.ModelRegistryEvent;

public abstract class SameCropAsSeed {

    public final JapaneseFoodPlant Plant;

    public final JapaneseFoodAsSeed Seed;

    /**
     * コンストラクタ
     * 
     * @param seed 種
     */
    public SameCropAsSeed(JapaneseFoodAsSeed seed) {
        this.Seed = seed;
        this.Plant = this.Seed.Plant;
        this.Seed.Plant.setSeed(this.Seed);
        this.Seed.Plant.setFood(this.Seed);
    }

}
