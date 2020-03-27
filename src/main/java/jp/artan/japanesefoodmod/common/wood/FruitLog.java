package jp.artan.japanesefoodmod.common.wood;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.Init;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

/**
 * 原木ブロックを作成するクラス
 * @apiNote
 * ./blockstates/${name}_log.json
 *      ブロックの設置向きの回転角度を記述
 * ./lang/en_us.lang　言語設定
 *      tile.${name}_log.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      tile.${name}_log.name=XXXXX
 * ./models/block/trees/${name}_log.json
 *      ブロックの側面と上下のテクスチャ情報を規定
 * ./models/item/${name}_log.json
 *      ブロックの情報を記述
 * ./textures/block/trees/${name}_log_side.png
 * ./textures/block/trees/${name}_log_top.png
 *      テクスチャ
 */
public abstract class FruitLog extends BlockLog implements IBlockRegisterEvent {
    private final String name;

    public FruitLog(String name) {
        super();
        this.setDefaultState(blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        this.name = name + "_log";
        ;
        this.setUnlocalizedName(this.name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.name);

        Init.BLOCKS.add(this);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return Blocks.LOG.getDefaultState().getMapColor(worldIn, pos);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = this.getDefaultState();

        switch (meta & 12) {
            case 0:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return state;
    }

    @Override
    @SuppressWarnings("incomplete-switch")
    public int getMetaFromState(IBlockState state) {
        int meta = 0;

        switch (state.getValue(LOG_AXIS)) {
            case X:
                meta |= 4;
                break;
            case Z:
                meta |= 8;
                break;
            case NONE:
                meta |= 12;
        }

        return meta;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { LOG_AXIS });
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this), 1);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
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
        event.getRegistry().register(new ItemBlock(this) {
            @Override
            public int getItemBurnTime(ItemStack itemStack) {
                return 300;
            }
        }.setUnlocalizedName(name).setRegistryName(JapaneseFoodMod.MODID, name));
    }
}
