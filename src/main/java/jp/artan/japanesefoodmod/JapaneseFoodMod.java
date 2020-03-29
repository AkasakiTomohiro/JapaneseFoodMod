package jp.artan.japanesefoodmod;

import jp.artan.japanesefoodmod.common.proxy.CommonProxy;
import jp.artan.japanesefoodmod.common.world.biome.FruitForestBiome;
import jp.artan.japanesefoodmod.common.world.type.WorldTypeFruitsForest;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = JapaneseFoodMod.MODID, name = JapaneseFoodMod.NAME, version = JapaneseFoodMod.VERSION, dependencies = JapaneseFoodMod.DEPENDENCIES)
public class JapaneseFoodMod {
    public static final String MODID = "japanesefoodmod";
    public static final String NAME = "Japanese Food Mod";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required:forge@[14.23.5.2838,);";

    public static Logger logger;

    public static final String CLIENT_PROXY = "jp.artan." + MODID + ".common.proxy.ClientProxy";
    public static final String SERVER_PROXY = "jp.artan." + MODID + ".common.proxy.ServerProxy";

    // バイオーム
    public static final Biome FRUIT_FOREST_BIOME = new FruitForestBiome();
    public static final WorldType FRUITS_FOREST_WORLD_TYPE = new WorldTypeFruitsForest();

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(JapaneseFoodMod.MODID)
    public static JapaneseFoodMod instance;

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(proxy);
        MinecraftForge.TERRAIN_GEN_BUS.register(proxy);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("JapaneseFoodMod.preInit");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("JapaneseFoodMod.init");
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("JapaneseFoodMod.postInit");
        proxy.postInit(event);
    }
}
