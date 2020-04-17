package jp.artan.japanesefoodmod.raw_materials.food.soy;

import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.init.CreativeTabsInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class SoyPlant extends JapaneseFoodPlant {
    public SoyPlant(String name) {
        super(name);
        this.setCreativeTab(CreativeTabsInit.rawMaterialsCreativeTab);
    }

    // この関数で途中の作物でもドロップさせることができる
    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
            int fortune) {
        Random rand = world instanceof World ? ((World) world).rand : RANDOM;
        int age = getAge(state);

        int count = quantityDropped(state, fortune, rand);
        for (int i = 0; i < count; i++) {
            Item item = this.getItemDropped(state, rand, fortune);
            if (item != Items.AIR) {
                if (age >= getMaxAge()) {
                    drops.add(new ItemStack(item, 1, this.damageDropped(state)));
                } else if (age == getMaxAge() - 1) {
                    drops.add(new ItemStack(Items.APPLE, 1));
                    drops.add(new ItemStack(Items.APPLE, 1));
                }
            }
        }
    }
}
