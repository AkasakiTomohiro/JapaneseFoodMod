package jp.artan.japanesefoodmod.common.wood;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * 原木ブロックを作成するクラス
 * @apiNote
 * ./blockstates/${name}_leaves.json
 *      ブロックの設置向きの回転角度を記述
 * ./lang/en_us.lang　言語設定
 *      tile.${name}_leaves.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      tile.${name}_leaves.name=XXXXX
 * ./models/block/${name}_leaves.json
 *      ブロックのテクスチャ情報を規定
 * ./models/item/${name}_leaves.json
 *      ブロックの情報を記述
 * ./textures/block/${name}_leaves.png
 *      テクスチャ
 */
public abstract class FruitLeaves extends BlockLeaves implements IBlockRegisterEvent {
    private final String name;
    private Block sapling;

    public FruitLeaves(String name)
    {
        super();
        this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
        this.name = name + "_leaves";;
        this.setUnlocalizedName(this.name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.name);
        JapaneseFoodMod.proxy.setGraphicsLevel(this);

        Init.BLOCKS.add(this);
    }

    public void setItemDropped(Block sapling) {
        this.sapling = sapling;
    }

    @Override
    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance)
    {
        // 何もしない
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this.sapling);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this));
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this));
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (!state.getValue(DECAYABLE).booleanValue())
        {
            i |= 4;
        }

        if (state.getValue(CHECK_DECAY).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
        {
            player.addStat(StatList.getBlockStats(this));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        return NonNullList.withSize(1, new ItemStack(this));
    }

    @Override
    public EnumType getWoodType(int meta)
    {
        return null;
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
        String name = getRegistryName().getResourcePath();
        event.getRegistry().register(new ItemBlock(this).setUnlocalizedName(name).setRegistryName(JapaneseFoodMod.MODID, this.name));
    }
}
