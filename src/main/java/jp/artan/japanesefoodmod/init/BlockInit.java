package jp.artan.japanesefoodmod.init;

import jp.artan.japanesefoodmod.common.crop.CropsWithSeeds;
import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.seaweeds.CustomSeaweeds;
import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropsWithSeeds;
import jp.artan.japanesefoodmod.raw_materials.seaweed.RawMaterialSeaweed;
import jp.artan.japanesefoodmod.raw_materials.wood.RawMaterialsFruitTree;
import jp.artan.japanesefoodmod.raw_materials.world.seaweed.LaminariaceaeGen;
import jp.artan.japanesefoodmod.raw_materials.world.tree.AlmondTreeSupplier;
import jp.artan.japanesefoodmod.raw_materials.world.tree.BananaTreeSupplier;
import jp.artan.japanesefoodmod.raw_materials.world.tree.GrapeTreeSupplier;
import jp.artan.japanesefoodmod.raw_materials.world.tree.JuglansTreeSupplier;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static List<IBlockRegisterEvent> BLOCKS = new ArrayList<IBlockRegisterEvent>();

    // 果樹
    public static final FruitTree BANANA = new RawMaterialsFruitTree("banana", 1, 0.3F, new BananaTreeSupplier());
    public static final FruitTree GRAPE = new RawMaterialsFruitTree("grape", 1, 0.3F, new GrapeTreeSupplier());
    public static final FruitTree ALMOND = new RawMaterialsFruitTree("almond", 1, 0.2F, new AlmondTreeSupplier());
    public static final FruitTree JUGLANS = new RawMaterialsFruitTree("juglans", 1, 0.2F, new JuglansTreeSupplier());

    // 作物
    public static final SameCropAsSeed SOY = new RawMaterialSameCropAsSeed("soy", 1, 0.1F);
    public static final CropsWithSeeds RADISH = new RawMaterialSameCropsWithSeeds("radish", 1, 0.4F);

    // 海藻
    public static final CustomSeaweeds SEAWEEDS = new RawMaterialSeaweed("laminariaceae", 1, 0.1F, 1, new LaminariaceaeGen());
}
