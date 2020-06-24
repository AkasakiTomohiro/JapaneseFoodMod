package jp.artan.japanesefoodmod.common.wood

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.init.BlockInit
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent
import net.minecraft.block.Block
import net.minecraft.block.IGrowable
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.block.properties.PropertyInteger
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.NonNullList
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.MathHelper
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.IShearable
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import java.util.ArrayList
import java.util.Random

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
abstract class FruitBlock(Name: String) : Block(Material.PLANTS), IGrowable, IBlockRegisterEvent, IShearable {
    val name: String = Name + "_fruit_block"
    lateinit var fruitItem: Item

    companion object {
        const val MATURE_AGE = 2
        const val fruitRemoval = false // This is for Dynamic Trees since the fruits grow back completely
        val AGE = PropertyInteger.create("age", 0, MATURE_AGE)
    }

    init {
        this.setTickRandomly(true)
        setSoundType(SoundType.WOOD)
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0))
        this.setUnlocalizedName(this.name)
        this.setRegistryName(JapaneseFoodMod.MODID, this.name)

        BlockInit.BLOCKS.add(this)
    }


    override fun getCollisionBoundingBox(blockState: IBlockState, worldIn: IBlockAccess, pos: BlockPos): AxisAlignedBB {
        return NULL_AABB!!
    }

    fun isMature(state: IBlockState): Boolean {
        return getMetaFromState(state) >= MATURE_AGE
    }

    fun getAgeProperty(): PropertyInteger {
        return AGE
    }

    override fun getBlockHardness(blockState: IBlockState, worldIn: World, pos: BlockPos): Float {
        if (getMetaFromState(blockState) >= MATURE_AGE) {
            return 2f
        } else {
            return 5f
        }
    }

    override fun getBoundingBox(state: IBlockState, source: IBlockAccess, pos: BlockPos): AxisAlignedBB {
        return AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0)
    }

    override fun neighborChanged(state: IBlockState, worldIn: World, pos: BlockPos, blockIn: Block, fromPos: BlockPos) {
        if (!this.canBlockStay(worldIn, pos)) {
            this.dropBlock(worldIn, pos, state)
        }
    }

    private fun canBlockStay(worldIn: World, pos: BlockPos): Boolean {
        return worldIn.getBlockState(pos.up()).getMaterial().isSolid()
    }

    private fun dropBlock(worldIn: World, pos: BlockPos, state: IBlockState) {
        if (!(state.getValue(AGE) != 3)) {

        }
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3)
        this.dropBlockAsItem(worldIn, pos, state, 0)
    }

    override fun getDrops(drops: NonNullList<ItemStack>, world: IBlockAccess, pos: BlockPos, state: IBlockState,
                          fortune: Int) {
        if (getMetaFromState(state) >= MATURE_AGE) {
            if (!fruitRemoval) {
                drops.add(ItemStack(fruitItem, 1))
            }
            drops.add(ItemStack(fruitItem, 1))
        }
    }

    override fun canPlaceBlockAt(world: World, pos: BlockPos): Boolean {
        val leafBlock = world.getBlockState(pos.up()).getBlock()

        return isSuitableSoilBlock(leafBlock)
    }

    fun neighborChanged(state: IBlockState, worldIn: World, pos: BlockPos, blockIn: Block) {
        validatePosition(worldIn, pos)
    }

    fun validatePosition(world: World, pos: BlockPos) {

        if (!this.canPlaceBlockAt(world, pos)) {
            world.setBlockToAir(pos)
        }
    }

    override fun isOpaqueCube(state: IBlockState): Boolean {
        return false
    }

    override fun isFullCube(state: IBlockState): Boolean {
        return false
    }

    private fun isSuitableSoilBlock(leafBlock: Block): Boolean {
        return leafBlock == Blocks.LEAVES || leafBlock == Blocks.LEAVES2
    }

    @SideOnly(Side.CLIENT)
    override fun getBlockLayer(): BlockRenderLayer {
        return BlockRenderLayer.CUTOUT
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return this.getDefaultState().withProperty(AGE, meta)
    }

    override fun getMetaFromState(state: IBlockState): Int {
        return state.getValue(AGE)
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, AGE)
    }

    override fun updateTick(worldIn: World, pos: BlockPos, state: IBlockState, rand: Random) {
        val i = state.getValue(AGE)

        if (i < MATURE_AGE && rand.nextInt(1) == 0) {
            worldIn.setBlockState(pos, state.withProperty(AGE, i + 1), 2)
        }

        super.updateTick(worldIn, pos, state.withProperty(AGE, i + 1), rand)

    }

    private fun grow(worldIn: World, pos: BlockPos, state: IBlockState) {
        var i = state.getValue(AGE) + MathHelper.getInt(worldIn.rand, 1, 2)
        if (i > MATURE_AGE) {
            i = MATURE_AGE
        }
        worldIn.setBlockState(pos, state.withProperty(AGE, i), 2)
    }

    override fun canGrow(worldIn: World, pos: BlockPos, state: IBlockState, isClient: Boolean): Boolean {
        return state.getValue(AGE) < MATURE_AGE
    }

    override fun canUseBonemeal(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState): Boolean {
        return true
    }

    override fun grow(worldIn: World, rand: Random, pos: BlockPos, state: IBlockState) {
        this.grow(worldIn, pos, state)
    }

    override fun isShearable(item: ItemStack, world: IBlockAccess, pos: BlockPos): Boolean {
        return true
    }

    override fun onSheared(item: ItemStack, world: IBlockAccess, pos: BlockPos, fortune: Int): ArrayList<ItemStack> {
        val ret = ArrayList<ItemStack>()
        ret.add(ItemStack(this, 1, 0))
        return ret
    }

    override fun registerBlock(event: RegistryEvent.Register<Block>) {
        event.getRegistry().register(this)
    }

    override fun registerModel(event: ModelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                ModelResourceLocation(ResourceLocation(JapaneseFoodMod.MODID, this.name), "inventory"))
    }

    override fun registerItemBlocks(event: RegistryEvent.Register<Item>) {
        // 何もしない
    }
}
