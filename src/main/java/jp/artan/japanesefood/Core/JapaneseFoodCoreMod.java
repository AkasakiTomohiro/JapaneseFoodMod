package jp.artan.japanesefood.Core;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = JapaneseFoodCoreMod.MODID, name = JapaneseFoodCoreMod.NAME, version = JapaneseFoodCoreMod.VERSION, dependencies = JapaneseFoodCoreMod.DEPENDENCIES)
public class JapaneseFoodCoreMod
{
    public static final String MODID = "japanesefoodcore";
    public static final String NAME = "Japanese Food Core Mod";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required:forge@[14.23.5.2838,);";

    private static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
