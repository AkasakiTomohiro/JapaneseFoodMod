package jp.artan.japanesefoodmod.common;

import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import jp.artan.japanesefoodmod.souvenir.JapaneseFoodSouvenir;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = JapaneseFoodMod.MODID, name = JapaneseFoodMod.NAME, version = JapaneseFoodMod.VERSION, dependencies = JapaneseFoodMod.DEPENDENCIES)
public class JapaneseFoodMod
{
    public static final String MODID = "japanesefoodmod";
    public static final String NAME = "Japanese Food Mod";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required:forge@[14.23.5.2838,);";


    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        JapaneseFoodRawMaterials.registerItems(event);
        JapaneseFoodSouvenir.registerItems(event);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        JapaneseFoodRawMaterials.registerBlocks(event);
        JapaneseFoodSouvenir.registerBlocks(event);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        JapaneseFoodRawMaterials.registerModels(event);
        JapaneseFoodSouvenir.registerModels(event);
    }
}
