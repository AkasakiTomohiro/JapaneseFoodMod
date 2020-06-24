package jp.artan.japanesefoodmod.common.wood

import java.util.*
import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent
import jp.artan.japanesefoodmod.init.BlockInit
import net.minecraft.block.Block
import net.minecraft.block.BlockLeaves
import net.minecraft.block.BlockPlanks.EnumType
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.stats.StatList
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.NonNullList
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent

/**
 * 原木ブロックを作成するクラス
 * @apiNote
 * ./blockstates/${name}_leaves.json
 *      ブロックの設置向きの回転角度を記述
 * ./lang/en_us.lang　言語設定
 *      tile.${name}_leaves.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      tile.${name}_leaves.name=XXXXX
 * ./models/block/trees/${name}_leaves.json
 *      ブロックのテクスチャ情報を規定
 * ./models/item/${name}_leaves.json
 *      ブロックの情報を記述
 * ./textures/block/trees/${name}_leaves.png
 *      テクスチャ
 */
abstract class FruitLeaves(Name: String) : BlockLeaves(), IBlockRegisterEvent {
    val name: String = Name + "_leaves"
    lateinit var sapling: Block

    init {
        this.setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, true)
                .withProperty(DECAYABLE, true))

        this.setUnlocalizedName(this.name)
        this.setRegistryName(JapaneseFoodMod.MODID, this.name)
        JapaneseFoodMod.proxy.setGraphicsLevel(this)

        BlockInit.BLOCKS.add(this)
    }

    override fun dropApple(worldIn: World, pos: BlockPos, state: IBlockState, chance: Int) {
        // 何もしない
    }

    override fun getItemDropped(state: IBlockState, rand: Random, fortune: Int): Item {
        return Item.getItemFromBlock(this.sapling)
    }

    override fun getSubBlocks(itemIn: CreativeTabs, items: NonNullList<ItemStack>) {
        items.add(ItemStack(this))
    }

    override fun getSilkTouchDrop(state: IBlockState): ItemStack {
        return ItemStack(Item.getItemFromBlock(this))
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        return defaultState.withProperty(DECAYABLE, (meta and 4 === 0)).withProperty(CHECK_DECAY,
                (meta and 8 > 0))
    }

    override fun getMetaFromState(state: IBlockState): Int {
        var i = 0

        if (!state.getValue(DECAYABLE)) {
            i = i or 4
        }

        if (state.getValue(CHECK_DECAY)) {
            i = i or 8
        }

        return i
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, CHECK_DECAY, DECAYABLE)
    }

    override fun damageDropped(state: IBlockState): Int {
        return 0
    }

    override fun harvestBlock(worldIn: World, player: EntityPlayer, pos: BlockPos, state: IBlockState, te: TileEntity?, stack: ItemStack) {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
            player.addStat(StatList.getBlockStats(this))
        } else {
            super.harvestBlock(worldIn, player, pos, state, te, stack)
        }
    }

    override fun onSheared(
        item: ItemStack,
        world: net.minecraft.world.IBlockAccess,
        pos: BlockPos,
        fortune: Int
    ): NonNullList<ItemStack> {
        return NonNullList.withSize(1, ItemStack(this))
    }

    override fun getWoodType(meta: Int): EnumType? {
        return null
    }

    override fun registerBlock(event: RegistryEvent.Register<Block>) {
        event.getRegistry().register(this)
    }

    override fun registerModel(event: ModelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                ModelResourceLocation(ResourceLocation(JapaneseFoodMod.MODID, this.name), "inventory"))
    }

    override fun registerItemBlocks(event: RegistryEvent.Register<Item>) {
        val name = getRegistryName()?.getResourcePath()
        event.getRegistry().register(
                ItemBlock(this).setUnlocalizedName(name).setRegistryName(JapaneseFoodMod.MODID, this.name))
    }

}
