package jp.artan.japanesefoodmod.common.crop;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodSeed;

public abstract class CropsWithSeeds {

    public final JapaneseFoodPlant Plant;

    public final JapaneseFoodSeed Seed;

    public final JapaneseFood Food;

    /**
     * コンストラクタ
     * 
     * @param seed 種
     */
    public CropsWithSeeds(JapaneseFood food, JapaneseFoodSeed seed) {
        this.Food = food;
        this.Seed = seed;
        this.Plant = this.Seed.Plant;
        this.Seed.Plant.setSeed(this.Seed);
        this.Seed.Plant.setFood(this.Food);
    }
}
