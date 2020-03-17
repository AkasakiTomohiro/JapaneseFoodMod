package jp.artan.japanesefoodmod.common.wood;

import jp.artan.japanesefoodmod.common.food.JapaneseFood;

public abstract class FruitTree {
    public final JapaneseFood fruit;

    public final FruitLog log;

    public FruitTree(JapaneseFood fruit, FruitLog log){
        this.fruit = fruit;
        this.log = log;
    }
}
