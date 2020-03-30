package jp.artan.japanesefoodmod.common.world.biome;

import jp.artan.japanesefoodmod.init.Init;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.BiomeDictionary.Type;

public class FruitForestBiome extends CustomBiome {
    public FruitForestBiome() {
        super("fruit_forest", Blocks.GRASS, Blocks.DIRT, new BiomeProperties("FruitForest").setBaseHeight(1.0F)
                .setHeightVariation(1.0F).setRainDisabled().setTemperature(1.0F), BiomeType.WARM, Type.FOREST);

        Init.BIOMES.add(this);
    }
}
