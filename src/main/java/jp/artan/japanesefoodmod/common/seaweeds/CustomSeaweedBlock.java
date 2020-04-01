package jp.artan.japanesefoodmod.common.seaweeds;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CustomSeaweedBlock extends Block implements IBlockRegisterEvent, IShearable {
    private final String name;
    private JapaneseFood item;
    public static boolean fruitRemoval = false;// This is for Dynamic Trees since the fruits grow back completely

    /**
     * なんのブロックの上に木を生成するか
     */
    public final Block topBlock;

    /**
     * 生成確立
     * @note 100を指定すると1％の確立で生成される
     */
    private final int genChance;

    public CustomSeaweedBlock(String name, Block topBlock, int chance) {
        super(Material.PLANTS);
        this.setTickRandomly(true);
        setSoundType(SoundType.WOOD);
        this.name = name + "_fruit_block";
        this.setUnlocalizedName(this.name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.name);
        this.topBlock = topBlock;
        this.genChance = chance;

        BlockInit.BLOCKS.add(this);
    }

    public int getGenChance(Biome biome) {
        return this.genChance;
    }

    /**
     * 指定したバイオームで生成してよいか
     * @param biome バイオーム
     * @return 生成してよいか
     */
    public boolean getEnableBiome(Biome biome){
        return biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(JapaneseFood item) {
        this.item = item;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        return 5f;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (!this.canBlockStay(worldIn, pos)) {
            this.dropBlock(worldIn, pos, state);
        }

    }

    private boolean canBlockStay(World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.up()).getMaterial().isSolid();
    }

    private void dropBlock(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(worldIn, pos, state, 0);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
                 int fortune) {
        drops.add(new ItemStack(getItem(), 1));
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        final Block leafBlock = world.getBlockState(pos.up()).getBlock();

        return isSuitableSoilBlock(leafBlock);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    private boolean isSuitableSoilBlock(Block leafBlock) {
        return leafBlock == Blocks.LEAVES || leafBlock == Blocks.LEAVES2;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, 0));
        return ret;
    }

    @Override
    public void registerBlock(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodMod.MODID, this.name), "inventory"));
    }

    @Override
    public void registerItemBlocks(RegistryEvent.Register<Item> event) {
        // 何もしない
    }
}
