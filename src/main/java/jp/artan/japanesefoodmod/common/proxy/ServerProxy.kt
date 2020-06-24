package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.SERVER)
class ServerProxy : CommonProxy() {

    override fun preInit(event: FMLPreInitializationEvent) {
        super.preInit(event);
        JapaneseFoodMod.logger.info("ServerProxy.preInit");
    }

    override fun setGraphicsLevel(leaves: FruitLeaves) {}
}
