package jp.artan.japanesefoodmod.common.food

import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent
import jp.artan.japanesefoodmod.init.ItemInit
import net.minecraft.block.state.IBlockState
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemSeeds
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.ResourceLocation
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.common.EnumPlantType
import net.minecraftforge.event.RegistryEvent

/**
 * 種の共通クラス
 * @apiNote
 * ./lang/en_us.lang　言語設定
 *      item.${name}_seeds.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      item.${name}_seeds.name=XXXXX
 * ./models/item/${name}_seeds.json
 *      アイテムのテクスチャ情報を記述
 * ./textures/item/${name}_seeds.png
 *      アイテムのテクスチャ情報を記述
 */
abstract class JapaneseFoodSeed(name: String, val Plant: JapaneseFoodPlant) : ItemSeeds(Plant, Blocks.FARMLAND), IItemRegisterEvent {
    val Name: String = name + "_seeds"

    init {
        this.setUnlocalizedName(this.Name)
        this.setRegistryName(JapaneseFoodMod.MODID, this.Name)

        ItemInit.ITEMS.add(this)
    }

    override fun onItemUse(player: EntityPlayer, worldIn: World, pos: BlockPos, hand: EnumHand,
                           facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): EnumActionResult {
        val stack = player.getHeldItem(hand)
        val state = worldIn.getBlockState(pos)

        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack)
                && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this)
                && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), this.Plant.getDefaultState())
            if (player.capabilities.isCreativeMode || !worldIn.isRemote) {
                stack.shrink(1)
            }
            return EnumActionResult.SUCCESS
        }
        return EnumActionResult.FAIL
    }

    override fun getPlantType(world: IBlockAccess, pos: BlockPos): EnumPlantType {
        return EnumPlantType.Crop
    }

    override fun getPlant(world: IBlockAccess, pos: BlockPos): IBlockState {
        return this.Plant.getDefaultState()
    }

    /**
     * アイテムを登録する
     *
     * @param event
     */
    override fun registerItem(event: RegistryEvent.Register<Item>) {
        event.getRegistry().register(this)
    }

    /**
     * モデルを登録する
     *
     * @param event
     */
    override fun registerModel(event: ModelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                ModelResourceLocation(ResourceLocation(JapaneseFoodMod.MODID, this.Name), "inventory"))
    }

}
