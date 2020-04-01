package jp.artan.japanesefoodmod.init;

import jp.artan.japanesefoodmod.common.world.biome.CustomBiome;
import jp.artan.japanesefoodmod.common.world.biome.FruitForestBiome;
import jp.artan.japanesefoodmod.common.world.type.WorldTypeFruitsForest;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.List;

public class BiomeInit {
    public static List<CustomBiome> BIOMES = new ArrayList<CustomBiome>();

    // バイオーム
    public static final Biome FRUIT_FOREST_BIOME = new FruitForestBiome();

    // ワールドタイプ
    public static final WorldType FRUITS_FOREST_WORLD_TYPE = new WorldTypeFruitsForest();
}
