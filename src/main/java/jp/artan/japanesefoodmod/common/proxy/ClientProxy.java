package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        JapaneseFoodMod.logger.info("ClientProxy.preInit");
    }

    /**
     * モデルを登録するイベント
     * 
     * @param event
     */
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        JapaneseFoodMod.logger.info("ClientProxy.registerModels");

        Init.ITEMS.forEach(f -> f.registerModel(event));
        Init.BLOCKS.forEach(f -> f.registerModel(event));
    }
}
