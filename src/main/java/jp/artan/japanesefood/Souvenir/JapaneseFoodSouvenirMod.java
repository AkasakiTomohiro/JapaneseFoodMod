package jp.artan.japanesefood.Souvenir;

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

@Mod(modid = JapaneseFoodSouvenirMod.MODID, name = JapaneseFoodSouvenirMod.NAME, version = JapaneseFoodSouvenirMod.VERSION, dependencies = JapaneseFoodSouvenirMod.DEPENDENCIES)
public class JapaneseFoodSouvenirMod {
    public static final String MODID = "japanesefoodsouvenir";
    public static final String NAME = "Japanese Food Souvenir Mod";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2838,);";

    public static CreativeTabs creativeTab = new SouvenirCreativeTab("JapaneseFoodSouvenir");

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
    }
}
