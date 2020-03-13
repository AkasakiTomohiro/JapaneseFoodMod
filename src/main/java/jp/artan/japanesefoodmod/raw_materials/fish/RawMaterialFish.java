package jp.artan.japanesefoodmod.raw_materials.fish;

import com.google.common.collect.Maps;
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
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

import java.util.Map;

public class RawMaterialFish extends ItemFood implements IItemRegisterEvent {
    /** Indicates whether this fish is "cooked" or not. */
    private final boolean cooked;
    private final String Name;

    public RawMaterialFish(String name, boolean cooked)
    {
        super(0, 0.0F, false);
        this.cooked = cooked;
        this.Name = name;
        this.setUnlocalizedName(this.Name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.Name);
        this.setCreativeTab(JapaneseFoodRawMaterials.creativeTab);
    }

    public int getHealAmount(ItemStack stack)
    {
        JapaneseFishType itemfishfood$fishtype = JapaneseFishType.byItemStack(stack);
        return this.cooked && itemfishfood$fishtype.canCook() ? itemfishfood$fishtype.getCookedHealAmount() : itemfishfood$fishtype.getUncookedHealAmount();
    }

    public float getSaturationModifier(ItemStack stack)
    {
        JapaneseFishType itemfishfood$fishtype = JapaneseFishType.byItemStack(stack);
        return this.cooked && itemfishfood$fishtype.canCook() ? itemfishfood$fishtype.getCookedSaturationModifier() : itemfishfood$fishtype.getUncookedSaturationModifier();
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        JapaneseFishType itemfishfood$fishtype = JapaneseFishType.byItemStack(stack);

        // 食べたものに応じてポーションを付与する場合はこれを利用する
//        if (itemfishfood$fishtype == JapaneseFishType.PUFFERFISH)
//        {
//            player.addPotionEffect(new PotionEffect(MobEffects.POISON, 1200, 3));
//            player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 300, 2));
//            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300, 1));
//        }

        super.onFoodEaten(stack, worldIn, player);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            for (JapaneseFishType itemfishfood$fishtype : JapaneseFishType.values())
            {
                if (!this.cooked || itemfishfood$fishtype.canCook())
                {
                    items.add(new ItemStack(this, 1, itemfishfood$fishtype.getMetadata()));
                }
            }
        }
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        JapaneseFishType itemfishfood$fishtype = JapaneseFishType.byItemStack(stack);
        return this.getUnlocalizedName() + "." + itemfishfood$fishtype.getUnlocalizedName() + "." + (this.cooked && itemfishfood$fishtype.canCook() ? "cooked" : "raw");
    }

    public enum JapaneseFishType
    {
        TEST(0, "cod", 2, 0.1F, 5, 0.6F);

        /** Maps an item damage value for an ItemStack to the corresponding FishType value. */
        private static final Map<Integer, JapaneseFishType> META_LOOKUP = Maps.<Integer, JapaneseFishType>newHashMap();
        /** The item damage value on an ItemStack that represents this fish type */
        private final int meta;
        /**
         * The value that this fish type uses to replace "XYZ" in: "fish.XYZ.raw" / "fish.XYZ.cooked" for the
         * unlocalized name and "fish_XYZ_raw" / "fish_XYZ_cooked" for the icon string.
         */
        private final String unlocalizedName;
        /** The amount that eating the uncooked version of this fish should heal the player. */
        private final int uncookedHealAmount;
        /** The saturation modifier to apply to the heal amount when the player eats the uncooked version of this fish. */
        private final float uncookedSaturationModifier;
        /** The amount that eating the cooked version of this fish should heal the player. */
        private final int cookedHealAmount;
        /** The saturation modifier to apply to the heal amount when the player eats the cooked version of this fish. */
        private final float cookedSaturationModifier;
        /** Indicates whether this type of fish has "raw" and "cooked" variants */
        private final boolean cookable;

        private JapaneseFishType(int meta, String unlocalizedName, int uncookedHeal, float uncookedSaturation, int cookedHeal, float cookedSaturation)
        {
            this.meta = meta;
            this.unlocalizedName = unlocalizedName;
            this.uncookedHealAmount = uncookedHeal;
            this.uncookedSaturationModifier = uncookedSaturation;
            this.cookedHealAmount = cookedHeal;
            this.cookedSaturationModifier = cookedSaturation;
            this.cookable = true;
        }

        private JapaneseFishType(int meta, String unlocalizedName, int uncookedHeal, float uncookedSaturation)
        {
            this.meta = meta;
            this.unlocalizedName = unlocalizedName;
            this.uncookedHealAmount = uncookedHeal;
            this.uncookedSaturationModifier = uncookedSaturation;
            this.cookedHealAmount = 0;
            this.cookedSaturationModifier = 0.0F;
            this.cookable = false;
        }

        /**
         * Gets the item damage value on an ItemStack that represents this fish type
         */
        public int getMetadata()
        {
            return this.meta;
        }

        /**
         * Gets the value that this fish type uses to replace "XYZ" in: "fish.XYZ.raw" / "fish.XYZ.cooked" for the
         * unlocalized name and "fish_XYZ_raw" / "fish_XYZ_cooked" for the icon string.
         */
        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        /**
         * Gets the amount that eating the uncooked version of this fish should heal the player.
         */
        public int getUncookedHealAmount()
        {
            return this.uncookedHealAmount;
        }

        /**
         * Gets the saturation modifier to apply to the heal amount when the player eats the uncooked version of this
         * fish.
         */
        public float getUncookedSaturationModifier()
        {
            return this.uncookedSaturationModifier;
        }

        /**
         * Gets the amount that eating the cooked version of this fish should heal the player.
         */
        public int getCookedHealAmount()
        {
            return this.cookedHealAmount;
        }

        /**
         * Gets the saturation modifier to apply to the heal amount when the player eats the cooked version of this
         * fish.
         */
        public float getCookedSaturationModifier()
        {
            return this.cookedSaturationModifier;
        }

        /**
         * Gets a value indicating whether this type of fish has "raw" and "cooked" variants.
         */
        public boolean canCook()
        {
            return this.cookable;
        }

        /**
         * Gets the corresponding FishType value for the given item damage value of an ItemStack, defaulting to COD for
         * unrecognized damage values.
         */
        public static JapaneseFishType byMetadata(int meta)
        {
            JapaneseFishType itemfishfood$fishtype = META_LOOKUP.get(Integer.valueOf(meta));
            return itemfishfood$fishtype == null ? TEST : itemfishfood$fishtype;
        }

        /**
         * Gets the FishType that corresponds to the given ItemStack, defaulting to COD if the given ItemStack does not
         * actually contain a fish.
         */
        public static JapaneseFishType byItemStack(ItemStack stack)
        {
            return stack.getItem() instanceof RawMaterialFish ? byMetadata(stack.getMetadata()) : TEST;
        }

        static
        {
            for (JapaneseFishType itemfishfood$fishtype : values())
            {
                META_LOOKUP.put(Integer.valueOf(itemfishfood$fishtype.getMetadata()), itemfishfood$fishtype);
            }
        }
    }

    /**
     * アイテムを登録する
     * @param event
     */
    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    /**
     * モデルを登録する
     * @param event
     */
    public void registerModel(ModelRegistryEvent event){
        ModelLoader.setCustomModelResourceLocation(
                this,
                0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodMod.MODID, this.Name), "inventory"));
    }
}