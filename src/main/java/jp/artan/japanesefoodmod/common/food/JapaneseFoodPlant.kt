package jp.artan.japanesefoodmod.common.food

import jp.artan.japanesefoodmod.init.BlockInit
import jp.artan.japanesefoodmod.JapaneseFoodMod
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent
import net.minecraft.block.Block
import net.minecraft.block.BlockCrops
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.event.RegistryEvent

/**
 * 作物ブロックを作成するクラス
 * @apiNote
 * ./blockstates/${name}_plant.json
 *      成長段階に合わせたブロックの情報を記述（０～７の８段階）
 * ./models/block/plants/${name}_plant_${Age(0~7)}.json
 *      成長段階に合わせたブロックのテクスチャ情報を記述
 * ./models/item/${name}_plant.json
 *      ブロックの情報を記述
 * ./textures/block/plants/${name}_plant_${Age(0~7)}.png
 *      ブロックの情報を記述
 */
abstract class JapaneseFoodPlant(name: String) : BlockCrops(), IBlockRegisterEvent {

    lateinit var PlantSeed: Item
    lateinit var PlantFood: Item

    var Name: String = name + "_plant"

    init {
        this.setUnlocalizedName(this.Name)
        this.setRegistryName(JapaneseFoodMod.MODID, this.Name)

        BlockInit.BLOCKS.add(this)
    }

    fun setSeed(seed: Item) {
        this.PlantSeed = seed
    }

    fun setFood(food: Item) {
        this.PlantFood = food
    }

    override fun getSeed(): Item {
        return this.PlantSeed
    }

    override fun getCrop(): Item {
        return this.PlantFood
    }

    override fun registerBlock(event: RegistryEvent.Register<Block>) {
        event.getRegistry().register(this)
    }

    override fun registerModel(event: ModelRegistryEvent) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                ModelResourceLocation(ResourceLocation(JapaneseFoodMod.MODID, this.Name), "inventory"))
    }

    override fun registerItemBlocks(event: RegistryEvent.Register<Item>) {
        // 食物ブロックはアイテムとして入手不可能ブロックなので、何もしない
    }
}
