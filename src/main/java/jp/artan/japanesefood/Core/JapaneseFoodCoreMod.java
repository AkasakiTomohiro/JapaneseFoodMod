package jp.artan.japanesefood.Core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = JapaneseFoodCoreMod.MODID, name = JapaneseFoodCoreMod.NAME, version = JapaneseFoodCoreMod.VERSION, dependencies = JapaneseFoodCoreMod.DEPENDENCIES)
public class JapaneseFoodCoreMod
{
    public static final String MODID = "japanesefoodcore";
    public static final String NAME = "Japanese Food Core Mod";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required:forge@[14.23.5.2838,);";

    private static Logger logger;

    public static CreativeTabs creativeTab = new JapaneseFoodCoreCreativeTab("Japanese Food Raw Materials");


    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        JapaneseFoodRawMaterials.registerItem(event);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        JapaneseFoodRawMaterials.registerModel(event);
    }
}
