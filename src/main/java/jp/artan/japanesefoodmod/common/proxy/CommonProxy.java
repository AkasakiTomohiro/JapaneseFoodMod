package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import jp.artan.japanesefoodmod.souvenir.JapaneseFoodSouvenir;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.preInit");
    }

    public void init(FMLInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.init");
        JapaneseFoodRawMaterials.init(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.postInit");
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerItems");
        JapaneseFoodRawMaterials.registerItems(event);
        JapaneseFoodSouvenir.registerItems(event);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerBlocks");
        JapaneseFoodRawMaterials.registerBlocks(event);
        JapaneseFoodSouvenir.registerBlocks(event);
    }

    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerEntities");
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerEnchantments");
    }

    @SubscribeEvent
    public void registerPotions(RegistryEvent.Register<Potion> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerPotions");
    }

    @SubscribeEvent
    public void registerPotionType(RegistryEvent.Register<PotionType> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerPotionType");
    }

    @SubscribeEvent
    public void registerBiome(RegistryEvent.Register<Biome> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerBiome");
    }
}
