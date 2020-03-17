package jp.artan.japanesefoodmod.common.crop;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodPlant;
import jp.artan.japanesefoodmod.common.food.JapaneseFoodSeed;

/**
 * 種と作物が異なる作物を作成するクラス
 * @apiNote
 * ./blockstates/${name}_plant.json
 *      成長段階に合わせたブロックの情報を記述（０～７の８段階）
 * ./lang/en_us.lang　言語設定
 *      item.${name}.name=XXXXX
 *      item.${name}_seeds.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      item.${name}.name=XXXXX
 *      item.${name}_seeds.name=XXXXX
 * ./models/block/${name}_plant${Age(0~7)}.json
 *      成長段階に合わせたブロックのテクスチャ情報を記述
 * ./models/item/${name}_plant.json
 *      ブロックの情報を記述
 * ./models/item/${name}.json
 * ./models/item/${name}_seeds.json
 *      アイテムのテクスチャ情報を記述
 * ./textures/block/${name}_plant${Age(0~7)}.png
 *      ブロックの情報を記述
 * ./textures/item/${name}.png
 * ./textures/item/${name}_seeds.png
 *      アイテムのテクスチャ情報を記述
 */
public abstract class CropsWithSeeds {

    public final JapaneseFoodPlant Plant;

    public final JapaneseFoodSeed Seed;

    public final JapaneseFood Food;

    /**
     * コンストラクタ
     * 
     * @param seed 種
     */
    public CropsWithSeeds(JapaneseFood food, JapaneseFoodSeed seed) {
        this.Food = food;
        this.Seed = seed;
        this.Plant = this.Seed.Plant;
        this.Seed.Plant.setSeed(this.Seed);
        this.Seed.Plant.setFood(this.Food);
    }
}
