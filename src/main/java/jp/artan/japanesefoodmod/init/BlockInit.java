package jp.artan.japanesefoodmod.init;

import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.wood.RawMaterialsFruitTree;
import jp.artan.japanesefoodmod.raw_materials.world.tree.AlmondTreeSupplier;
import jp.artan.japanesefoodmod.raw_materials.world.tree.BananaTreeSupplier;
import jp.artan.japanesefoodmod.raw_materials.world.tree.GrapeTreeSupplier;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static List<IBlockRegisterEvent> BLOCKS = new ArrayList<IBlockRegisterEvent>();

    // 果樹
    public static final FruitTree BANANA = new RawMaterialsFruitTree("banana", 1, 0.3F, new BananaTreeSupplier());
    public static final FruitTree GRAPE = new RawMaterialsFruitTree("grape", 1, 0.3F, new GrapeTreeSupplier());
    public static final FruitTree ALMOND = new RawMaterialsFruitTree("almond", 1, 0.2F, new AlmondTreeSupplier());

    // 作物
    public static final SameCropAsSeed SOY = new RawMaterialSameCropAsSeed("soy", 1, 0.1F);
}
