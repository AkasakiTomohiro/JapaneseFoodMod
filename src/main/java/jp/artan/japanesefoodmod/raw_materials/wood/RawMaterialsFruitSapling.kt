package jp.artan.japanesefoodmod.raw_materials.wood

import jp.artan.japanesefoodmod.common.wood.FruitSapling
import jp.artan.japanesefoodmod.common.world.tree.WorldGenSupplier
import jp.artan.japanesefoodmod.init.CreativeTabsInit

class RawMaterialsFruitSapling(name: String, supplier: WorldGenSupplier) : FruitSapling(name, supplier) {
    init {
        this.setCreativeTab(CreativeTabsInit.fruitTreeCreativeTab)
    }
}
