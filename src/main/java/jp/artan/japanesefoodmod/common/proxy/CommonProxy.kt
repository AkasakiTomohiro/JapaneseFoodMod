package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenCustomSeaweed;
import jp.artan.japanesefoodmod.init.*;
import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.event.clock.RightClickHarvesting;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.common.world.tree.WorldGenCustomTrees;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid = JapaneseFoodMod.MODID)
abstract class CommonProxy {

    open fun preInit(event: FMLPreInitializationEvent) {
        JapaneseFoodMod.logger.info("CommonProxy.preInit");

        GameRegistry.registerWorldGenerator(WorldGenCustomTrees(), 0);
        GameRegistry.registerWorldGenerator(WorldGenCustomSeaweed(), 0);
    }

    fun init(event: FMLInitializationEvent) {
        JapaneseFoodMod.logger.info("CommonProxy.init");
        RecipeInit.smelting(event);
        RecipeInit.registerOreDictionaryEntries(event);

        RightClickHarvesting.instance.register();
    }

    fun postInit(event: FMLPostInitializationEvent) {
        JapaneseFoodMod.logger.info("CommonProxy.postInit");
    }

    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>) {
        JapaneseFoodMod.logger.info("CommonProxy.registerItems");
        ItemInit.ITEMS.forEach {
            it.registerItem(event)
        }
        BlockInit.BLOCKS.forEach {
            it.registerItemBlocks(event)
        }
    }

    @SubscribeEvent
    fun registerBlocks(event: RegistryEvent.Register<Block>) {
        JapaneseFoodMod.logger.info("CommonProxy.registerBlocks");
        BlockInit.BLOCKS.forEach {
            it.registerBlock(event)
        }
    }

    @SubscribeEvent
    fun registerEntities(event: RegistryEvent.Register<EntityEntry>) {
        JapaneseFoodMod.logger.info("CommonProxy.registerEntities");
    }

    @SubscribeEvent
    fun registerEnchantments(event: RegistryEvent.Register<Enchantment>) {
        JapaneseFoodMod.logger.info("CommonProxy.registerEnchantments");
    }

    @SubscribeEvent
    fun registerPotions(event: RegistryEvent.Register<Potion>) {
        JapaneseFoodMod.logger.info("CommonProxy.registerPotions");
    }

    @SubscribeEvent
    fun registerPotionType(event: RegistryEvent.Register<PotionType>) {
        JapaneseFoodMod.logger.info("CommonProxy.registerPotionType");
    }

    @SubscribeEvent
    fun registerBiome(event: RegistryEvent.Register<Biome>) {
        JapaneseFoodMod.logger.info("CommonProxy.registerBiome");
        BiomeInit.BIOMES.forEach {
            event.getRegistry().register(it)
        }
    }

    @SubscribeEvent
    fun decorateBiome(event: DecorateBiomeEvent.Decorate) {
//        World world = event.getWorld();
//        Biome biome = world.getBiomeForCoordsBody(event.getPos());
//        Random rand = event.getRand();
//        if(event.getType() == DecorateBiomeEvent.Decorate.EventType.TREE) {
//            if(biome == Biomes.PLAINS) {
//            }
//        }
    }

    @SubscribeEvent
    fun onLootTablesLoaded(event: LootTableLoadEvent) {
        if (event.getName().equals(LootTableList.GAMEPLAY_FISHING)) {
            JapaneseFoodMod.logger.info("LootTableList.GAMEPLAY_FISHING");
            val pool = event.getTable().getPool("main");
            if (pool != null) {
                val entry = LootEntryTable(ResourceLocation("japanesefoodmod:gameplay/fishing"), 100, -10,
                        CreateLootCondition.create(), "japanesefoodmod");
                pool.addEntry(entry);
            }
        } else if (event.getName().equals(LootTableList.ENTITIES_SQUID)) {
            JapaneseFoodMod.logger.info("LootTableList.ENTITIES_SQUID");
            val pool = event.getTable().getPool("main");
            if (pool != null) {
                val entry = LootEntryTable(ResourceLocation("japanesefoodmod:gameplay/entities/squid"), 100, -10,
                        CreateLootCondition.create(), "japanesefoodmod");
                pool.addEntry(entry);
            }
        }
    }

    abstract fun setGraphicsLevel(leaves: FruitLeaves)
}
