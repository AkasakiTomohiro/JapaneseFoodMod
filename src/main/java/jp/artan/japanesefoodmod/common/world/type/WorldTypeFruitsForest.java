package jp.artan.japanesefoodmod.common.world.type;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;

public class WorldTypeFruitsForest extends WorldType {
    public WorldTypeFruitsForest() {
        super("Fruits Forest");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world)
    {
        return new BiomeProviderFruitsForest();
    }

}
