package jp.artan.japanesefoodmod.common.seaweeds

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent
import jp.artan.japanesefoodmod.common.food.JapaneseFood
import jp.artan.japanesefoodmod.init.BlockInit
import net.minecraft.block.*
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.init.Biomes
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.NonNullList
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.AxisAlignedBB
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraft.world.biome.Biome
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.IShearable
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import java.util.ArrayList

/**
 * 海藻ブロックを作成するクラス
 * @apiNote
 * ./blockstates/${name}_seaweed_block.json
 *      ブロックの設置向きの回転角度を記述
 * ./models/block/seaweed/${name}_seaweed_block.json
 *      ブロックのテクスチャ情報を規定
 * ./textures/block/seaweed/${name}_seaweed_block.png
 *      テクスチャ
 * @note genChance 生成確立 100を指定すると1％の確立で生成される
 */
abstract class CustomSeaweedBlock(name: String, val genChance: Int) : Block(Material.PLANTS), IBlockRegisterEvent, IShearable {
    val name: String = name + "_seaweed_block"
    lateinit var item: JapaneseFood

    /**
     * なんのブロックの上に木を生成するか
     */
    val topBlock: Block = Blocks.GRAVEL

    init {
        this.setTickRandomly(true)
        setSoundType(SoundType.WOOD)
        this.setUnlocalizedName(name)
        this.setRegistryName(JapaneseFoodMod.MODID, name)

        BlockInit.BLOCKS.add(this)
    }

    fun getGenChance(biome: Biome): Int {
        return this.genChance
    }

    /**
     * 指定したバイオームで生成してよいか
     * @param biome バイオーム
     * @return 生成してよいか
     */
    fun getEnableBiome(biome: Biome): Boolean {
        return biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN
    }

    override fun getCollisionBoundingBox(blockState: IBlockState, worldIn: IBlockAccess, pos: BlockPos): AxisAlignedBB {
        return NULL_AABB!!
    }

    override fun getBlockHardness(blockState: IBlockState, worldIn: World, pos: BlockPos): Float {
        return 5f
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
        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3)
        this.dropBlockAsItem(worldIn, pos, state, 0)
    }

    override fun getDrops(drops: NonNullList<ItemStack>, world: IBlockAccess, pos: BlockPos, state: IBlockState,
                          fortune: Int) {
        drops.add(ItemStack(item, 1))
    }

    override fun canPlaceBlockAt(world: World, pos: BlockPos): Boolean {
        val leafBlock = world.getBlockState(pos.up()).getBlock()

        return isSuitableSoilBlock(leafBlock)
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

    override fun isShearable(item: ItemStack, world: IBlockAccess, pos: BlockPos): Boolean {
        return true
    }

    override fun onSheared(item: ItemStack, world: IBlockAccess, pos: BlockPos, fortune: Int): ArrayList<ItemStack> {
        val ret: ArrayList<ItemStack> = ArrayList()
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
