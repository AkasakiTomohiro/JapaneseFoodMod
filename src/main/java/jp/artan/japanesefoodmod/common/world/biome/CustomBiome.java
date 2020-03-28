package jp.artan.japanesefoodmod.common.world.biome;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.Init;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CustomBiome extends Biome {
    protected final String name;

    public CustomBiome(String name, Block topBlock, Block fillerBlock, BiomeProperties properties,
            BiomeManager.BiomeType biomeType, Type... types) {
        super(properties);

        this.topBlock = topBlock.getDefaultState();
        this.fillerBlock = fillerBlock.getDefaultState();

        this.name = name;
        this.setRegistryName(JapaneseFoodMod.MODID, this.name);

        ForgeRegistries.BIOMES.register(this);
        BiomeDictionary.addTypes(this, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(this, 1000));
        BiomeManager.addSpawnBiome(this);
        BiomeManager.addStrongholdBiome(this);

        Init.BIOMES.add(this);
    }

    @Override
    public BiomeDecorator createBiomeDecorator()
    {
        BiomeDecorator biomeDecorator = new CustomBiomeDecorator();

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
}
