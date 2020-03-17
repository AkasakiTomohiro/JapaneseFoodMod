package jp.artan.japanesefoodmod.common.wood;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;

/**
 * 果樹を追加するクラス
 * @apiNote
 * ./blockstates/${name}_log.json
 *      ブロックの設置向きの回転角度を記述
 * ./lang/en_us.lang　言語設定
 *      item.${name}.name=XXXXX
 *      tile.${name}_log.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      item.${name}.name=XXXXX
 *      tile.${name}_log.name=XXXXX
 * ./models/block/${name}_log.json
 *      ブロックの側面と上下のテクスチャ情報を規定
 * ./models/item/${name}.json
 * ./models/item/${name}_log.json
 *      ブロックの情報を記述
 * ./textures/block/${name}_log_side.png
 * ./textures/block/${name}_log_top.png
 *      ブロックの情報を記述
 * ./textures/item/${name}.png
 *      アイテムのテクスチャ情報を記述
 */
public abstract class FruitTree {
    public final JapaneseFood fruit;

    public final FruitLog log;

    public final FruitLeaves leaves;

    public FruitTree(JapaneseFood fruit, FruitLog log, FruitLeaves leaves){
        this.fruit = fruit;
        this.log = log;
        this.leaves = leaves;
    }
}
