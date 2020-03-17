package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.SERVER)
public class ServerProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        JapaneseFoodMod.logger.info("ServerProxy.preInit");
    }

    public void setGraphicsLevel(FruitLeaves leaves){

    }
}
