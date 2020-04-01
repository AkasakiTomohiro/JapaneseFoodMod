package jp.artan.japanesefoodmod.common.proxy;

import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenCustomSeaweed;
import jp.artan.japanesefoodmod.init.BlockInit;
import jp.artan.japanesefoodmod.init.Init;
import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.event.clock.RightClickHarvesting;
import jp.artan.japanesefoodmod.common.potion.CommonPotion;
import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.common.world.tree.WorldGenCustomTrees;
import jp.artan.japanesefoodmod.init.ItemInit;
import jp.artan.japanesefoodmod.init.RecipeInit;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
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
public abstract class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.preInit");

        GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenCustomSeaweed(), 0);
    }

    public void init(FMLInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.init");
        RecipeInit.smelting(event);
        RecipeInit.registerOreDictionaryEntries(event);

        RightClickHarvesting.instance.register();
    }

    public void postInit(FMLPostInitializationEvent event) {
        JapaneseFoodMod.logger.info("CommonProxy.postInit");
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerItems");
        ItemInit.ITEMS.forEach(f -> f.registerItem(event));
        BlockInit.BLOCKS.forEach(f -> f.registerItemBlocks(event));
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerBlocks");
        BlockInit.BLOCKS.forEach(f -> f.registerBlock(event));
    }

    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerEntities");
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        JapaneseFoodMod.logger.info("CommonProxy.registerEnchantments");
    }

    public static CommonPotion potion = new CommonPotion("test", false, 0xFFFFFF);

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
        Init.BIOMES.forEach(f -> event.getRegistry().register(f));
    }

    @SubscribeEvent
    public void decorateBiome(DecorateBiomeEvent.Decorate event) {
//        World world = event.getWorld();
//        Biome biome = world.getBiomeForCoordsBody(event.getPos());
//        Random rand = event.getRand();
//        if(event.getType() == DecorateBiomeEvent.Decorate.EventType.TREE) {
//            if(biome == Biomes.PLAINS) {
//            }
//        }
    }

    @SubscribeEvent
    public void onLootTablesLoaded(LootTableLoadEvent event) {
        if (event.getName().equals(LootTableList.GAMEPLAY_FISHING)) {
            JapaneseFoodMod.logger.info("LootTableList.GAMEPLAY_FISHING");
            final LootPool pool = event.getTable().getPool("main");
            if (pool != null) {
                LootEntry entry = new LootEntryTable(new ResourceLocation("japanesefoodmod:gameplay/fishing"), 100, -10,
                        new LootCondition[0], "japanesefoodmod");
                pool.addEntry(entry);
            }
        } else if(event.getName().equals(LootTableList.ENTITIES_SQUID)) {
            JapaneseFoodMod.logger.info("LootTableList.ENTITIES_SQUID");
            final LootPool pool = event.getTable().getPool("main");
            if (pool != null) {
                LootEntry entry = new LootEntryTable(new ResourceLocation("japanesefoodmod:gameplay/entities/squid"), 100, -10,
                        new LootCondition[0], "japanesefoodmod");
                pool.addEntry(entry);
            }
        }
    }

    public abstract void setGraphicsLevel(FruitLeaves leaves);
}
