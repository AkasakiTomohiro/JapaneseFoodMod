package jp.artan.japanesefoodmod.common.food;

import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public abstract class JapaneseFoodPlant extends BlockCrops {
    protected Item Seed;
    protected Item Food;
    protected final String Name;

    public JapaneseFoodPlant(String name) {
        super();
        this.Name = name + "_plant";
        this.setUnlocalizedName(this.Name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.Name);

        Init.BLOCKS.add(this);
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
