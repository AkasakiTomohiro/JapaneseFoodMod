package jp.artan.japanesefoodmod.common;

import jp.artan.japanesefoodmod.common.proxy.CommonProxy;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import jp.artan.japanesefoodmod.souvenir.JapaneseFoodSouvenir;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = JapaneseFoodMod.MODID, name = JapaneseFoodMod.NAME, version = JapaneseFoodMod.VERSION, dependencies = JapaneseFoodMod.DEPENDENCIES)
public class JapaneseFoodMod
{
    public static final String MODID = "japanesefoodmod";
    public static final String NAME = "Japanese Food Mod";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required:forge@[14.23.5.2838,);";

    public static Logger logger;

    public static final String CLIENT_PROXY = "jp.artan." + MODID + ".common.proxy.ClientProxy";
    public static final String SERVER_PROXY = "jp.artan." + MODID + ".common.proxy.ServerProxy";

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.Instance(JapaneseFoodMod.MODID)
    public static JapaneseFoodMod instance;

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    /**
     * アイテムを登録するイベント
     * @param event
     */
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        JapaneseFoodMod.logger.info("registerItems");
        JapaneseFoodRawMaterials.registerItems(event);
        JapaneseFoodSouvenir.registerItems(event);
    }

    /**
     * ブロックを登録するイベント
     * @param event
     */
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        JapaneseFoodMod.logger.info("registerBlocks");
        JapaneseFoodRawMaterials.registerBlocks(event);
        JapaneseFoodSouvenir.registerBlocks(event);
    }

    /**
     * モデルを登録するイベント
     * @param event
     */
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        JapaneseFoodMod.logger.info("registerModels");
        JapaneseFoodRawMaterials.registerModels(event);
        JapaneseFoodSouvenir.registerModels(event);
    }
}
