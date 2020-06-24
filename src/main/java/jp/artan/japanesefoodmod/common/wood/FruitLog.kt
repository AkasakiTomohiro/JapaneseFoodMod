package jp.artan.japanesefoodmod.common.wood

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.init.BlockInit
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent
import net.minecraft.block.Block
import net.minecraft.block.BlockLog
import net.minecraft.block.material.MapColor
import net.minecraft.block.state.BlockStateContainer
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemStack
import net.minecraft.util.NonNullList
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent

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
abstract class FruitLog(Name: String) : BlockLog(), IBlockRegisterEvent {
    val name: String = Name + "_log"

    init {
        this.setDefaultState(blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y))
        this.setUnlocalizedName(this.name)
        this.setRegistryName(JapaneseFoodMod.MODID, this.name)

        BlockInit.BLOCKS.add(this)
    }

    override fun getMapColor(state: IBlockState, worldIn: IBlockAccess, pos: BlockPos): MapColor {
        return Blocks.LOG.getDefaultState().getMapColor(worldIn, pos)
    }

    override fun getSubBlocks(itemIn: CreativeTabs, items: NonNullList<ItemStack>) {
        items.add(ItemStack(this))
    }

    override fun getStateFromMeta(meta: Int): IBlockState {
        var state = this.getDefaultState()

        state = when (meta and 12) {
            0 -> state.withProperty(LOG_AXIS, EnumAxis.Y)
            4 -> state.withProperty(LOG_AXIS, EnumAxis.X)
            8 -> state.withProperty(LOG_AXIS, EnumAxis.Z)
            else -> state.withProperty(LOG_AXIS, EnumAxis.NONE)
        }

        return state
    }

    @SuppressWarnings("incomplete-switch")
    override fun getMetaFromState(state: IBlockState): Int {
        var meta = 0

        meta = when (state.getValue(LOG_AXIS)) {
            EnumAxis.X -> meta or 4
            EnumAxis.Z -> meta or 8
            EnumAxis.NONE -> meta or 12
            else -> 0
        }

        return meta
    }

    override fun createBlockState(): BlockStateContainer {
        return BlockStateContainer(this, LOG_AXIS)
    }

    override fun getSilkTouchDrop(state: IBlockState): ItemStack {
        return ItemStack(Item.getItemFromBlock(this), 1)
    }

    override fun damageDropped(state: IBlockState): Int {
        return 0
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
        event.getRegistry().register(BurnItem(name, this))
    }

    class BurnItem(name: String?, block: Block) : ItemBlock(block) {
        init {
            this.setUnlocalizedName(name)
            this.setRegistryName(JapaneseFoodMod.MODID, name)
        }

        override fun getItemBurnTime(itemStack: ItemStack): Int {
            return 300
        }
    }
}
