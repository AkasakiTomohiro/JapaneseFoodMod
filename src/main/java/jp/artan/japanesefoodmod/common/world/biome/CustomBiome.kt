package jp.artan.japanesefoodmod.common.world.biome;

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.wood.FruitTree
import jp.artan.japanesefoodmod.init.BiomeInit
import net.minecraft.block.Block
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeDecorator
import net.minecraft.world.gen.feature.WorldGenAbstractTree
import net.minecraftforge.common.BiomeDictionary
import net.minecraftforge.common.BiomeDictionary.Type
import net.minecraftforge.common.BiomeManager
import net.minecraftforge.common.BiomeManager.BiomeEntry
import net.minecraftforge.fml.common.registry.ForgeRegistries
import java.util.*


open class CustomBiome(val name: String, topBlock: Block, fillerBlock: Block, properties: Biome.BiomeProperties,
                       biomeType: BiomeManager.BiomeType, vararg types: Type) : Biome(properties) {
    companion object {
        val fruits = ArrayList<FruitTree>()
    }

    init {
        this.topBlock = topBlock.defaultState
        this.fillerBlock = fillerBlock.defaultState

        this.setRegistryName(JapaneseFoodMod.MODID, name)

        ForgeRegistries.BIOMES.register(this)
        BiomeDictionary.addTypes(this, *types)
        BiomeManager.addBiome(biomeType, BiomeEntry(this, 1000))
        BiomeManager.addSpawnBiome(this)
        BiomeManager.addStrongholdBiome(this)

        BiomeInit.BIOMES.add(this)
    }

    override fun createBiomeDecorator(): BiomeDecorator {
        val biomeDecorator = CustomBiomeDecorator();

        biomeDecorator.waterlilyPerChunk = 0;
        biomeDecorator.treesPerChunk = 10;
        biomeDecorator.extraTreeChance = 0.1F;
        biomeDecorator.flowersPerChunk = 100;
        biomeDecorator.grassPerChunk = 2;
        biomeDecorator.deadBushPerChunk = 0;
        biomeDecorator.mushroomsPerChunk = 0;
        biomeDecorator.reedsPerChunk = 0;
        biomeDecorator.cactiPerChunk = 0;
        biomeDecorator.gravelPatchesPerChunk = 1;
        biomeDecorator.sandPatchesPerChunk = 3;
        biomeDecorator.clayPerChunk = 1;
        biomeDecorator.bigMushroomsPerChunk = 0;
        biomeDecorator.generateFalls = true;

        return getModdedBiomeDecorator(biomeDecorator);
    }

    override fun getRandomTreeFeature(rand: Random): WorldGenAbstractTree {
        val index = rand.nextInt(fruits.size)
        return fruits.get(index).sapling.supplier.getWorldGenerate(false);
    }

}
