package jp.artan.japanesefoodmod.common.world.biome

import net.minecraft.init.Blocks
import net.minecraftforge.common.BiomeManager.BiomeType
import net.minecraftforge.common.BiomeDictionary.Type

class FruitForestBiome() : CustomBiome("fruit_forest", Blocks.GRASS, Blocks.DIRT, BiomeProperties("FruitForest").setBaseHeight(1.0F)
        .setHeightVariation(1.0F).setRainDisabled().setTemperature(1.0F), BiomeType.WARM, Type.FOREST) {
}
