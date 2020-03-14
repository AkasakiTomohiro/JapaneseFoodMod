package jp.artan.japanesefoodmod.common.crop;

import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodSeed;
import net.minecraftforge.client.event.ModelRegistryEvent;

public abstract class CropsWithSeeds implements IItemRegisterEvent, IBlockRegisterEvent {

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

    @Override
    public void registerModel(ModelRegistryEvent event) {
        this.Food.registerModel(event);
        this.Seed.registerModel(event);
        this.Plant.registerModel(event);
    }
}
