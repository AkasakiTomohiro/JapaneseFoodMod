package jp.artan.japanesefoodmod.common.food;

import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public abstract class JapaneseFoodPlant extends BlockCrops implements IBlockRegisterEvent {
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

    @Override
    public void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodMod.MODID, this.Name), "inventory"));
    }
}
