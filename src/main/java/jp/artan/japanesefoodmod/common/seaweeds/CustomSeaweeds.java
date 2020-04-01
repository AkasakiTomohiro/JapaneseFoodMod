package jp.artan.japanesefoodmod.common.seaweeds;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.common.world.seaweed.WorldGenSeaweed;

/**
 * 海藻ブロックを作成するクラス
 * @apiNote
 * ./blockstates/${name}_seaweed_block.json
 *      ブロックの設置向きの回転角度を記述
 * ./lang/en_us.lang　言語設定
 *      tile.${name}.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      tile.${name}.name=XXXXX
 * ./models/block/seaweed/${name}_seaweed_block.json
 *      ブロックのテクスチャ情報を規定
 * ./models/item/${name}.json
 *      アイテムのテクスチャ情報を規定
 * ./textures/blocks/seaweed/${name}_seaweed_block.png
 *      テクスチャ
 * ./textures/items/${name}.png
 *      テクスチャ
 */
public abstract class CustomSeaweeds {

    public final CustomSeaweedBlock block;
    public final WorldGenSeaweed worldGen;
    public final JapaneseFood food;

    public CustomSeaweeds(JapaneseFood food, CustomSeaweedBlock block, WorldGenSeaweed worldGen) {
        this.food = food;
        this.block = block;
        this.worldGen = worldGen;

        this.block.setItem(this.food);
        this.worldGen.setBlockStateWood(this.block);
    }

    public WorldGenSeaweed getWorldGenerator(Boolean flag) {
        return this.worldGen;
    }
}
