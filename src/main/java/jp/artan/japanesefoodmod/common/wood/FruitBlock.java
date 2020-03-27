package jp.artan.japanesefoodmod.common.wood;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * フルーツブロックを作成するクラス
 * @apiNote
 * ./blockstates/${name}_fruit_block.json
 *      ブロックの設置向きの回転角度を記述
 * ./models/block/fruits/${name}_fruit_block_${Age(0~2)}.json
 *      ブロックのテクスチャ情報を規定
 * ./textures/block/fruits/${name}_fruit_block_${Age(0~2)}.png
 *      テクスチャ
 */
public abstract class FruitBlock extends Block implements IGrowable, IBlockRegisterEvent, IShearable {
    private final String name;
    private static final int MATURE_AGE = 2;
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, MATURE_AGE);
    private Item fruitItem;
    public static boolean fruitRemoval = false;// This is for Dynamic Trees since the fruits grow back completely

    public FruitBlock(String name) {
        super(Material.PLANTS);
        this.setTickRandomly(true);
        setSoundType(SoundType.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
        this.name = name + "_fruit_block";
        this.setUnlocalizedName(this.name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.name);

        Init.BLOCKS.add(this);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }

    public Item getFruitItem() {
        return fruitItem;
    }

    public void setFruitItem(Item fruitItem) {
        this.fruitItem = fruitItem;
    }

    public boolean isMature(IBlockState state) {
        return getMetaFromState(state) >= MATURE_AGE;
    }

    public PropertyInteger getAgeProperty() {
        return AGE;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        if (getMetaFromState(blockState) >= MATURE_AGE) {
            return 2f;
        } else {
            return 5f;
        }
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
        if (!(state.getValue(AGE) != 3)) {

        }
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(worldIn, pos, state, 0);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
            int fortune) {
        if (getMetaFromState(state) >= MATURE_AGE) {
            if (!fruitRemoval) {
                drops.add(new ItemStack(getFruitItem(), 1));
            }
            drops.add(new ItemStack(getFruitItem(), 1));
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        final Block leafBlock = world.getBlockState(pos.up()).getBlock();

        return isSuitableSoilBlock(leafBlock);
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
        validatePosition(worldIn, pos);
    }

    public void validatePosition(World world, BlockPos pos) {

        if (!this.canPlaceBlockAt(world, pos)) {
            world.setBlockToAir(pos);
        }
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
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(AGE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(AGE);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, AGE);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        int i = state.getValue(AGE);

        if (i < MATURE_AGE && rand.nextInt(1) == 0) {
            state = state.withProperty(AGE, i + 1);
            worldIn.setBlockState(pos, state, 2);
        }

        super.updateTick(worldIn, pos, state, rand);

    }

    private void grow(World worldIn, BlockPos pos, IBlockState state) {
        int i = state.getValue(AGE) + MathHelper.getInt(worldIn.rand, 1, 2);
        if (i > MATURE_AGE) {
            i = MATURE_AGE;
        }
        worldIn.setBlockState(pos, state.withProperty(AGE, i), 2);
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return state.getValue(AGE) < MATURE_AGE;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        this.grow(worldIn, pos, state);
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
