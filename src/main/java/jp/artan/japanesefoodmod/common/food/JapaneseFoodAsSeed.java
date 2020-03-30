package jp.artan.japanesefoodmod.common.food;

import jp.artan.japanesefoodmod.init.Init;
import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.RegistryEvent;

/**
 * 食べられる種の共通クラス
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
public abstract class JapaneseFoodAsSeed extends ItemFood implements IPlantable, IItemRegisterEvent {

    public JapaneseFoodPlant Plant;
    protected final String Name;

    /**
     * コンストラクタ
     * 
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public JapaneseFoodAsSeed(String name, int amount, float saturation, JapaneseFoodPlant plant) {
        super(amount, saturation, false);
        this.Name = name + "_seeds";

        this.setUnlocalizedName(this.Name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.Name);
        this.Plant = plant;

        Init.ITEMS.add(this);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
            EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        IBlockState state = worldIn.getBlockState(pos);

        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack)
                && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this)
                && worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), this.Plant.getDefaultState());
            if (player.capabilities.isCreativeMode || !worldIn.isRemote) {
                stack.shrink(1);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return this.Plant.getDefaultState();
    }

    /**
     * アイテムを登録する
     *
     * @param event
     */
    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    /**
     * モデルを登録する
     *
     * @param event
     */
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(new ResourceLocation(JapaneseFoodMod.MODID, this.Name), "inventory"));
    }
}
