package jp.artan.japanesefoodmod.common.crop;

import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodAsSeed;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import net.minecraft.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public abstract class SameCropAsSeed implements IItemRegisterEvent, IBlockRegisterEvent {

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

    @Override
    public void registerBlock(RegistryEvent.Register<Block> event) {
        this.Plant.registerBlock(event);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        this.Seed.registerModel(event);
        this.Plant.registerModel(event);
    }
}
