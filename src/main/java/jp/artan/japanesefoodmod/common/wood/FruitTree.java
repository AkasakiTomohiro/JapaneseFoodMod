package jp.artan.japanesefoodmod.common.wood;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * 果樹を追加するクラス
 * @apiNote
 * ./blockstates/${name}_log.json
 * ./blockstates/${name}_leaves.json
 * ./blockstates/${name}_sapling.json
 *      ブロックの設置向きの回転角度を記述
 * ./lang/en_us.lang　言語設定
 *      item.${name}.name=XXXXX
 *      tile.${name}_log.name=XXXXX
 *      tile.${name}_leaves.name=XXXXX
 *      tile.${name}_sapling.name=XXXXX
 * ./lang/ja_JP.lang　言語設定
 *      item.${name}.name=XXXXX
 *      tile.${name}_log.name=XXXXX
 *      tile.${name}_leaves.name=XXXXX
 *      tile.${name}_sapling.name=XXXXX
 * ./models/block/${name}_log.json
 * ./models/block/${name}_leaves.json
 * ./models/block/${name}_sapling.json
 *      ブロックの側面と上下のテクスチャ情報を規定
 * ./models/item/${name}.json
 * ./models/item/${name}_log.json
 * ./models/item/${name}_leaves.json
 * ./models/item/${name}_sapling.json
 *      ブロックの情報を記述
 * ./textures/block/${name}_log_side.png
 * ./textures/block/${name}_log_top.png
 * ./textures/block/${name}_leaves.png
 * ./textures/block/${name}_sapling.png
 * ./textures/item/${name}.png
 *      テクスチャ
 */
public abstract class FruitTree {
    public final JapaneseFood fruit;

    public final FruitLog log;

    public final FruitLeaves leaves;

    public final FruitSapling sapling;

    public FruitTree(JapaneseFood fruit, FruitLog log, FruitLeaves leaves, FruitSapling sapling){
        this.fruit = fruit;
        this.log = log;
        this.leaves = leaves;
        this.sapling = sapling;
    }

    public void registerOreDictionaryEntries() {
        OreDictionary.registerOre("logWood", new ItemStack(this.log, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("treeLeaves", this.leaves);
        OreDictionary.registerOre("treeSapling", this.sapling);
    }
}
