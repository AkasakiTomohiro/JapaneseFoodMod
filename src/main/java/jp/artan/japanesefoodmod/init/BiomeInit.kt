package jp.artan.japanesefoodmod.init

import jp.artan.japanesefoodmod.common.world.biome.CustomBiome
import jp.artan.japanesefoodmod.common.world.biome.FruitForestBiome
import jp.artan.japanesefoodmod.common.world.type.WorldTypeFruitsForest
import java.util.ArrayList

class BiomeInit {
    companion object {
        val BIOMES = ArrayList<CustomBiome>()

        // バイオーム
        val FRUIT_FOREST_BIOME = FruitForestBiome()

        // ワールドタイプ
        val FRUITS_FOREST_WORLD_TYPE = WorldTypeFruitsForest()
    }
}
