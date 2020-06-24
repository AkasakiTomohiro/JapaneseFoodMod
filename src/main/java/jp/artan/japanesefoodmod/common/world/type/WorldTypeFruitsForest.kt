package jp.artan.japanesefoodmod.common.world.type

import net.minecraft.world.World
import net.minecraft.world.WorldType
import net.minecraft.world.biome.BiomeProvider

class WorldTypeFruitsForest : WorldType("Fruits Forest") {
    override fun getBiomeProvider(world: World): BiomeProvider {
        return BiomeProviderFruitsForest()
    }
}
