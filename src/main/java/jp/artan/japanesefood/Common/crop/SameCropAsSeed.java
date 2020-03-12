package jp.artan.japanesefood.Common.crop;

import jp.artan.japanesefood.Common.Event.IBlockRegisterEvent;
import jp.artan.japanesefood.Common.Event.IItemRegisterEvent;
import jp.artan.japanesefood.Common.FoodClass.JapaneseFoodAsSeed;
import jp.artan.japanesefood.Common.FoodClass.JapaneseFoodPlant;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public abstract class SameCropAsSeed implements IItemRegisterEvent, IBlockRegisterEvent {

    public final JapaneseFoodPlant Plant;

    public final JapaneseFoodAsSeed Seed;

    /**
     * コンストラクタ
     * @param seed 種
     */
    public SameCropAsSeed(JapaneseFoodAsSeed seed) {
        this.Seed = seed;
        this.Plant = this.Seed.Plant;
        this.Seed.Plant.setSeed(this.Seed);
        this.Seed.Plant.setFood(this.Seed);
    }

    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        this.Seed.registerItem(event);
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
