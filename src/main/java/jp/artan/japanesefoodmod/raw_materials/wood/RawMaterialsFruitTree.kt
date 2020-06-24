package jp.artan.japanesefoodmod.raw_materials.wood

import jp.artan.japanesefoodmod.common.wood.FruitTree
import jp.artan.japanesefoodmod.common.world.tree.WorldGenSupplier
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood

class RawMaterialsFruitTree(name: String, amount: Int, saturation: Float, supplier: WorldGenSupplier) :
        FruitTree(RawMaterialFood(name, amount, saturation), RawMaterialsFruitLog(name), RawMaterialsFruitLeaves(name),
                RawMaterialsFruitSapling(name, supplier), RawMaterialsFruitBlock(name)) {
    init {
        this.leaves.sapling = this.sapling
        this.fruitBlock.fruitItem = this.fruit
        supplier.setIBlockState(this.log, this.leaves, this.fruitBlock)
    }
}
