package jp.artan.japanesefoodmod.common.food;

import jp.artan.japanesefoodmod.init.Init;
import jp.artan.japanesefoodmod.JapaneseFoodMod;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

/**
 * 食べ物の共通クラス
 * @apiNote
 * ./lang/en_us.lang　言語設定
 *      item.${name}.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      item.${name}.name=XXXXX
 * ./models/item/${name}.json
 *      アイテムのテクスチャ情報を記述
 * ./textures/item/${name}.png
 *      アイテムのテクスチャ情報を記述
 */
public abstract class JapaneseFood extends ItemFood implements IItemRegisterEvent {

    protected final String Name;

    /**
     * コンストラクタ
     * 
     * @param name       食べ物の名前(※英字小文字のみ)
     * @param amount     回復する満腹度
     * @param saturation 回復する隠し満腹度
     */
    public JapaneseFood(String name, int amount, float saturation) {
        super(amount, saturation, false);
        this.Name = name;
        this.setUnlocalizedName(this.Name);
        this.setRegistryName(JapaneseFoodMod.MODID, this.Name);

        Init.ITEMS.add(this);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        // if (player.isPotionActive(MobEffects.LUCK)) {
        //     player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1200, 3));
        // }

         player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 1200, 3));
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
