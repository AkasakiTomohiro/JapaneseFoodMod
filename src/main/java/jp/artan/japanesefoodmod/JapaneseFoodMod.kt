package jp.artan.japanesefoodmod;

import jp.artan.japanesefoodmod.common.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = JapaneseFoodMod.MODID, name = JapaneseFoodMod.NAME, version = JapaneseFoodMod.VERSION, dependencies = JapaneseFoodMod.DEPENDENCIES)
class JapaneseFoodMod {
    companion object {
        const val MODID = "japanesefoodmod";
        const val NAME = "Japanese Food Mod";
        const val VERSION = "1.0";
        const val DEPENDENCIES = "required:forge@[14.23.5.2838,);";
        const val CLIENT_PROXY = "jp.artan." + MODID + ".common.proxy.ClientProxy";
        const val SERVER_PROXY = "jp.artan." + MODID + ".common.proxy.ServerProxy";
        lateinit var logger: Logger

        @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
        lateinit var proxy: CommonProxy

        @Mod.Instance(MODID)
        lateinit var instance: JapaneseFoodMod
    }

    @Mod.EventHandler
    fun construct(event: FMLConstructionEvent) {
        MinecraftForge.EVENT_BUS.register(proxy);
        MinecraftForge.TERRAIN_GEN_BUS.register(proxy);
    }

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.getModLog();
        logger.info("JapaneseFoodMod.preInit");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        logger.info("JapaneseFoodMod.init");
        proxy.init(event);
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        logger.info("JapaneseFoodMod.postInit");
        proxy.postInit(event);
    }
}
