package jp.artan.japanesefoodmod.raw_materials.wood;

import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.common.world.WorldGenSupplier;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood;

public class RawMaterialsFruitTree extends FruitTree {

    public RawMaterialsFruitTree(String name, int amount, float saturation, WorldGenSupplier supplier) {
        super(new RawMaterialFood(name, amount, saturation), new RawMaterialsFruitLog(name),
                new RawMaterialsFruitLeaves(name), new RawMaterialsFruitSapling(name, supplier),
                new RawMaterialsFruitBlock(name));
        this.leaves.setItemDropped(this.sapling);
        this.fruitBlock.setFruitItem(this.fruit);
        supplier.setIBlockState(this.log, this.leaves, this.fruitBlock);
    }
}
