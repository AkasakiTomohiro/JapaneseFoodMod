package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import jp.artan.japanesefoodmod.souvenir.JapaneseFoodSouvenir;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        JapaneseFoodMod.logger.info("ClientProxy.preInit");
    }

    /**
     * モデルを登録するイベント
     * @param event
     */
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        JapaneseFoodMod.logger.info("ClientProxy.registerModels");
        JapaneseFoodRawMaterials.registerModels(event);
        JapaneseFoodSouvenir.registerModels(event);
    }
}
