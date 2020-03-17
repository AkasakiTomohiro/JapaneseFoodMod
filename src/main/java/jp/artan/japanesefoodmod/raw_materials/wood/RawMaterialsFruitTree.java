package jp.artan.japanesefoodmod.raw_materials.wood;

import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood;

public class RawMaterialsFruitTree extends FruitTree {
    private final String name;

    public RawMaterialsFruitTree(String name, int amount, float saturation) {
        super(new RawMaterialFood(name, amount, saturation), new RawMaterialsFruitLog(name), new RawMaterialsFruitLeaves(name));
        this.name = name;
    }
}
