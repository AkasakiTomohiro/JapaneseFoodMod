package jp.artan.japanesefoodmod.common.crop

import jp.artan.japanesefoodmod.common.food.JapaneseFoodAsSeed
import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant

/**
 * 種と作物が同じ作物を作成するクラス
 * @apiNote
 * ./blockstates/${name}_plant.json
 *      成長段階に合わせたブロックの情報を記述（０～７の８段階）
 * ./lang/en_us.lang　言語設定
 *      item.${name}_seeds.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      item.${name}_seeds.name=XXXXX
 * ./models/block/${name}_plant_${Age(0~7)}.json
 *      成長段階に合わせたブロックのテクスチャ情報を記述
 * ./models/item/${name}_plant.json
 *      ブロックの情報を記述
 * ./models/item/${name}_seeds.json
 *      アイテムのテクスチャ情報を記述
 * ./textures/block/${name}_plant_${Age(0~7)}.png
 *      ブロックの情報を記述
 * ./textures/item/${name}_seeds.png
 *      アイテムのテクスチャ情報を記述
 * @param seed 種
 */
abstract class SameCropAsSeed(val Seed: JapaneseFoodAsSeed) {

    val Plant: JapaneseFoodPlant = this.Seed.Plant

    init {
        this.Seed.Plant.setSeed(this.Seed)
        this.Seed.Plant.setFood(this.Seed)
    }

}
