package jp.artan.japanesefoodmod.raw_materials.food.soy

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant
import jp.artan.japanesefoodmod.init.CreativeTabsInit
import jp.artan.japanesefoodmod.init.ItemInit
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.util.NonNullList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.IBlockAccess
import net.minecraft.world.World

class SoyPlant(name: String) : JapaneseFoodPlant(name) {
    init {
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab)
    }

    // この関数で途中の作物でもドロップさせることができる
    override fun getDrops(drops: NonNullList<ItemStack>, world: IBlockAccess, pos: BlockPos, state: IBlockState,
                          fortune: Int) {
        val rand = if (world is World) world.rand else RANDOM
        val age = getAge(state)

        var count = quantityDropped(state, fortune, rand)
        for (i in 0..count step 1) {
            val item = this.getItemDropped(state, rand, fortune)
            if (item != Items.AIR) {
                if (age >= getMaxAge()) {
                    drops.add(ItemStack(item, 1, this.damageDropped(state)))
                } else if (age == getMaxAge() - 1) {
                    drops.add(ItemStack(ItemInit.EDAMAME, 1))
                    drops.add(ItemStack(ItemInit.EDAMAME, 1))
                }
            }
        }
    }
}
