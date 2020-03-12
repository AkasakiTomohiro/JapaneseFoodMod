package jp.artan.japanesefood.Common.FoodClass;

import jp.artan.japanesefood.Common.Event.IBlockRegisterEvent;
import jp.artan.japanesefood.Common.Event.IItemRegisterEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public abstract class SameCropAsSeed implements IItemRegisterEvent, IBlockRegisterEvent {

    public final JapaneseFoodPlant Plant;

    public final JapaneseFoodSeed Seed;

    /**
     * コンストラクタ
     * @param seed 種
     */
    public SameCropAsSeed(JapaneseFoodSeed seed) {
        this.Seed = seed;
        this.Plant = this.Seed.Plant;
        this.Seed.Plant.setSeed(this.Seed);
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
    }
}
