package jp.artan.japanesefood.Common.FoodClass;

import jp.artan.japanesefood.Common.Event.IBlockRegisterEvent;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.item.Item;
import net.minecraftforge.common.IPlantable;

public abstract class JapaneseFoodPlant extends BlockCrops implements IPlantable, IGrowable, IBlockRegisterEvent {
    protected Item Seed;
    protected Item Food;
    protected final String Name;

    public JapaneseFoodPlant(String name) {
        super();
        this.Name = name + "_crop_block";
        this.setUnlocalizedName(this.Name);
    }

    public void setSeed(Item seed) {
        this.Seed = seed;
    }

    public void setFood(Item food) {
        this.Food = food;
    }

    @Override
    public Item getSeed() {
        return this.Seed;
    }

    @Override
    public Item getCrop() {
        return this.Food;
    }
}
