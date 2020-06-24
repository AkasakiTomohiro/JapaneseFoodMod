package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.init.BlockInit;
import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.init.ItemInit;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
class ClientProxy : CommonProxy() {

    override fun preInit(event: FMLPreInitializationEvent) {
        super.preInit(event);
        JapaneseFoodMod.logger.info("ClientProxy.preInit");
    }

    /**
     * モデルを登録するイベント
     *
     * @param event
     */
    @SubscribeEvent
    fun registerModels(event: ModelRegistryEvent) {
        JapaneseFoodMod.logger.info("ClientProxy.registerModels");
        ItemInit.ITEMS.forEach {
            it.registerModel(event)
        }
        BlockInit.BLOCKS.forEach {
            it.registerModel(event)
        }
    }

    override fun setGraphicsLevel(leaves: FruitLeaves) {
        leaves.setGraphicsLevel(true);
    }
}
