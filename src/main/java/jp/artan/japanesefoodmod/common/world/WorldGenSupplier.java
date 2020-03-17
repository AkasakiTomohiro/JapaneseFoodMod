package jp.artan.japanesefoodmod.common.world;

import jp.artan.japanesefoodmod.common.wood.FruitLeaves;
import jp.artan.japanesefoodmod.common.wood.FruitLog;

public abstract class WorldGenSupplier {
    public abstract WorldGenFruitTrees getWorldGenerate(boolean parShouldNotify);
    public abstract void setIBlockState(FruitLog log, FruitLeaves leaves);
}
