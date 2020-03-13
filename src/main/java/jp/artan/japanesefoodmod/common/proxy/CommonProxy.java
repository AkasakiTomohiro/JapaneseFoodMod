package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import jp.artan.japanesefoodmod.souvenir.JapaneseFoodSouvenir;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.preInit");
    }

    public void init(FMLInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.init");
    }

    public void postInit(FMLPostInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.postInit");
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerRecipes");
        JapaneseFoodRawMaterials.registerRecipes(event);
        JapaneseFoodSouvenir.registerRecipes(event);
    }
}
