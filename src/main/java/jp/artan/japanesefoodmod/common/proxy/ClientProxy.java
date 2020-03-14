package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import jp.artan.japanesefoodmod.souvenir.JapaneseFoodSouvenir;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
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
        JapaneseFoodRawMaterials.registerModels(event);
        JapaneseFoodSouvenir.registerModels(event);

        for (Item item : Init.ITEMS) {
            ModelLoader.setCustomModelResourceLocation(item, 0,
                    new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }

        for (Block block : Init.BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
                    new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }
    }
}
