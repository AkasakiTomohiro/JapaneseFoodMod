package jp.artan.japanesefoodmod.raw_materials.fish;

import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import jp.artan.japanesefoodmod.raw_materials.JapaneseFoodRawMaterials;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RawMaterialFish {

    public final JapaneseFish ROW;
    public final JapaneseFish COOKED;

    public RawMaterialFish(String name) {
        ROW = new JapaneseFish(name + "_row", false);
        COOKED = new JapaneseFish(name + "_baked", true);
    }

    public void registerSmelting() {
        for (int i = 0; i < JapaneseFishType.getMetaDataLength(); i++) {
            ItemStack itemStack = new ItemStack(ROW, 1, i);
            JapaneseFishType fish = JapaneseFishType.byItemStack(itemStack);
            if (fish.canCook()) {
                GameRegistry.addSmelting(itemStack, new ItemStack(COOKED, 1, i), 0.4F);
            }
        }
    }
}

class JapaneseFish extends ItemFood implements IItemRegisterEvent {
    /** Indicates whether this fish is "cooked" or not. */
    private final boolean cooked;
    public final String Name;

    public JapaneseFish(String name, boolean cooked) {
        super(0, 0.0F, false);
        this.cooked = cooked;
        this.Name = name;
        this.setUnlocalizedName(this.Name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.Name);
        this.setCreativeTab(JapaneseFoodRawMaterials.creativeTab);
        this.setHasSubtypes(true);

        Init.ITEMS.add(this);
    }

    /**
     * アイテムを登録する
     *
     * @param event
     */
    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    /**
     * モデルを登録する
     *
     * @param event
     */
    public void registerModel(ModelRegistryEvent event) {
        for (int i = 0; i < JapaneseFishType.getMetaDataLength(); i++) {
            ItemStack itemStack = new ItemStack(this, 1, i);
            ModelLoader.setCustomModelResourceLocation(itemStack.getItem(), i, new ModelResourceLocation(
                    new ResourceLocation(JapaneseFoodMod.MODID, this.getUnlocalizedName(itemStack)), "inventory"));
        }
    }

    public int getHealAmount(ItemStack stack) {
        JapaneseFishType type = JapaneseFishType.byItemStack(stack);
        return this.cooked && type.canCook() ? type.getCookedHealAmount() : type.getUncookedHealAmount();
    }

    public float getSaturationModifier(ItemStack stack) {
        JapaneseFishType type = JapaneseFishType.byItemStack(stack);
        return this.cooked && type.canCook() ? type.getCookedSaturationModifier()
                : type.getUncookedSaturationModifier();
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        // JapaneseFishType itemfishfood$fishtype = JapaneseFishType.byItemStack(stack);

        // 食べたものに応じてポーションを付与する場合はこれを利用する
        // if (itemfishfood$fishtype == JapaneseFishType.PUFFERFISH)
        // {
        // player.addPotionEffect(new PotionEffect(MobEffects.POISON, 1200, 3));
        // player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
        // player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300, 1));
        // }

        super.onFoodEaten(stack, worldIn, player);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns
     * 16 items)
     */
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            for (JapaneseFishType type : JapaneseFishType.values()) {
                if (!this.cooked || type.canCook()) {
                    items.add(new ItemStack(this, 1, type.getMetadata()));
                }
            }
        }
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack
     * so different stacks can have different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack) {
        JapaneseFishType type = JapaneseFishType.byItemStack(stack);
        return this.Name + "_" + type.getUnlocalizedName();
    }
}
