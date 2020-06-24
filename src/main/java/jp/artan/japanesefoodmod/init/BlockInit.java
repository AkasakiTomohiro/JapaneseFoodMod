package jp.artan.japanesefoodmod.init;

import jp.artan.japanesefoodmod.common.crop.CropsWithSeeds;
import jp.artan.japanesefoodmod.common.crop.SameCropAsSeed;
import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.seaweeds.CustomSeaweeds;
import jp.artan.japanesefoodmod.common.wood.FruitTree;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropsWithSeeds;
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameWaterCropsWithSeeds;
import jp.artan.japanesefoodmod.raw_materials.food.soy.Soy;
import jp.artan.japanesefoodmod.raw_materials.seaweed.RawMaterialSeaweed;
import jp.artan.japanesefoodmod.raw_materials.wood.RawMaterialsFruitTree;
import jp.artan.japanesefoodmod.raw_materials.world.seaweed.LaminariaceaeGen;
import jp.artan.japanesefoodmod.raw_materials.world.seaweed.OgonoriGen;
import jp.artan.japanesefoodmod.raw_materials.world.seaweed.TengsaGen;
import jp.artan.japanesefoodmod.raw_materials.world.tree.DefaultTreeSupplier;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static List<IBlockRegisterEvent> BLOCKS = new ArrayList<IBlockRegisterEvent>();
    public static List<FruitTree> FRUIT_TREES = new ArrayList<FruitTree>();

    // 果樹
    public static final FruitTree BANANA = new RawMaterialsFruitTree("banana", 1, 0.3F, new DefaultTreeSupplier());
    public static final FruitTree GRAPE = new RawMaterialsFruitTree("grape", 1, 0.3F, new DefaultTreeSupplier());
    public static final FruitTree ALMOND = new RawMaterialsFruitTree("almond", 1, 0.2F, new DefaultTreeSupplier());
    public static final FruitTree JUGLANS = new RawMaterialsFruitTree("juglans", 1, 0.2F, new DefaultTreeSupplier());
    public static final FruitTree CITRON = new RawMaterialsFruitTree("citron", 1, 0.2F, new DefaultTreeSupplier());
    public static final FruitTree ORANGE = new RawMaterialsFruitTree("orange", 1, 0.2F, new DefaultTreeSupplier());
    public static final FruitTree MANDARIN_ORANGE = new RawMaterialsFruitTree("mandarin_orange", 1, 0.2F,
            new DefaultTreeSupplier());
    public static final FruitTree CHESTNUT = new RawMaterialsFruitTree("chestnut", 1, 0.2F, new DefaultTreeSupplier());

    // 作物　種と作物が同じタイプ
    public static final SameCropAsSeed SOY = new Soy();
    public static final SameCropAsSeed WHITE_GREEN_BEANS = new RawMaterialSameCropAsSeed("white_green_beans", 1, 0.2F);
    public static final SameCropAsSeed WHITE_RED_BEANS = new RawMaterialSameCropAsSeed("white_red_beans", 1, 0.2F);
    public static final SameCropAsSeed RED_BEANS = new RawMaterialSameCropAsSeed("red_beans", 1, 0.2F);
    public static final SameCropAsSeed PEANUTS = new RawMaterialSameCropAsSeed("peanuts", 1, 0.2F);
    public static final SameCropAsSeed CHILI = new RawMaterialSameCropAsSeed("chili", 1, 0.1F);
    public static final SameCropAsSeed TEBOUMAME = new RawMaterialSameCropAsSeed("teboumame", 1, 0.2F);
    public static final SameCropAsSeed ONION = new RawMaterialSameCropAsSeed("onion", 1, 0.1F);
    public static final SameCropAsSeed GINGER = new RawMaterialSameCropAsSeed("ginger", 1, 0.1F);
    public static final SameCropAsSeed BROAD_BEANS = new RawMaterialSameCropAsSeed("broad_beans", 1, 0.1F);
    public static final SameCropAsSeed YAM = new RawMaterialSameCropAsSeed("yam", 1, 0.1F);
    public static final SameCropAsSeed GARLIC = new RawMaterialSameCropAsSeed("garlic", 1, 0.1F);
    public static final SameCropAsSeed RED_POTATO = new RawMaterialSameCropAsSeed("red_potato", 1, 0.1F);
    // 作物　種と作物が異なるタイプ
    public static final CropsWithSeeds RADISH = new RawMaterialSameCropsWithSeeds("radish", 1, 0.4F);
    public static final CropsWithSeeds NOZAWANA = new RawMaterialSameCropsWithSeeds("nozawana", 1, 0.2F);
    public static final CropsWithSeeds EGGPLANT = new RawMaterialSameCropsWithSeeds("eggplant", 1, 0.2F);
    public static final CropsWithSeeds SHISO = new RawMaterialSameCropsWithSeeds("shiso", 1, 0.1F);
    public static final CropsWithSeeds STRAWBERRY = new RawMaterialSameCropsWithSeeds("strawberry", 1, 0.2F);
    public static final CropsWithSeeds BARLEY = new RawMaterialSameCropsWithSeeds("barley", 1, 1.0F);
    // 作物　種と作物が異なるタイプの水上作物
    public static final CropsWithSeeds GLUTINOUS_RICE = new RawMaterialSameWaterCropsWithSeeds("glutinous_rice", 1,
            0.2F);
    public static final CropsWithSeeds RICE = new RawMaterialSameWaterCropsWithSeeds("rice", 1, 1.0F);

    // 海藻
    public static final CustomSeaweeds SEAWEEDS = new RawMaterialSeaweed("laminariaceae", 1, 0.1F, 10,
            new LaminariaceaeGen());
    public static final CustomSeaweeds TENGSA = new RawMaterialSeaweed("tengsa", 1, 0.1F, 10, new TengsaGen());
    public static final CustomSeaweeds OGONORI = new RawMaterialSeaweed("ogonori", 1, 0.1F, 10, new OgonoriGen());
}
