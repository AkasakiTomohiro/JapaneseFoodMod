package jp.artan.japanesefoodmod.common.wood;

import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.init.BlockInit;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.world.tree.WorldGenSupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import java.util.Random;

/**
 * 原木ブロックを作成するクラス
 * @apiNote
 * ./blockstates/${name}_sapling.json
 *      ブロックの設置向きの回転角度を記述
 * ./lang/en_us.lang　言語設定
 *      tile.${name}_sapling.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      tile.${name}_sapling.name=XXXXX
 * ./models/block/trees/${name}_sapling.json
 *      ブロックのテクスチャ情報を規定
 * ./models/item/${name}_sapling.json
 *      ブロックの情報を記述
 * ./textures/block/trees/${name}_sapling.png
 *      テクスチャ
 */
abstract class FruitSapling(Name: String, val supplier: WorldGenSupplier) : BlockBush(), IGrowable, IBlockRegisterEvent {
    val name = Name + "_sapling"

    companion object {
        val STAGE = PropertyInteger.create("stage", 0, 1)
        val SAPLING_AABB = AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421)
    }

    init {
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.setUnlocalizedName(this.name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.name);

        BlockInit.BLOCKS.add(this);
    }

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos)
            : AxisAlignedBB {
        return SAPLING_AABB;
    }

    override fun updateTick(worldIn: World, pos: BlockPos, state: IBlockState, rand: Random) {
        if (!worldIn.isRemote) {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0) {
                grow(worldIn, rand, pos, state);
            }
        }
    }

    fun generateTree(worldIn: World, pos: BlockPos, state: IBlockState, rand: Random) {
        if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        val worldgenerator = supplier.getWorldGenerate(true);

        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);

        worldgenerator.generate(worldIn, rand, pos);
    }

    override fun canGrow(worldIn: World, pos: BlockPos, state: IBlockState, isClient: Boolean): Boolean {
        return true;
    }

    override fun canUseBonemeal(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState): Boolean {
        return worldIn.rand.nextFloat() < 0.45;
    }

    override fun grow(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState) {
        if (state.getValue(STAGE) == 0) {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        } else {
            generateTree(worldIn, pos, state, rand);
        }
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return getDefaultState().withProperty(STAGE, Integer.valueOf((meta and 8) ushr 3));
    }

    override fun getMetaFromState(state: IBlockState): Int {
        var i = 0;
        i = i or state.getValue(STAGE) shl 3;
        return i;
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, STAGE);
    }

    override fun registerBlock(event: RegistryEvent.Register<Block>) {
        event.getRegistry().register(this);
    }

    override fun registerModel(event: ModelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                ModelResourceLocation(ResourceLocation(JapaneseFoodMod.MODID, this.name), "inventory"));
    }

    override fun registerItemBlocks(event: RegistryEvent.Register<Item>) {
        val name = getRegistryName()?.getResourcePath()
        event.getRegistry().register(BurnItem(name, this))
    }

    class BurnItem(name: String?, block: Block) : ItemBlock(block) {
        init {
            this.setUnlocalizedName(name)
            this.setRegistryName(JapaneseFoodMod.MODID, name)
        }

        override fun getItemBurnTime(itemStack: ItemStack): Int {
            return 100
        }
    }
}
