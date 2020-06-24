package jp.artan.japanesefoodmod.init

import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropAsSeed
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameCropsWithSeeds
import jp.artan.japanesefoodmod.raw_materials.crop.RawMaterialSameWaterCropsWithSeeds
import jp.artan.japanesefoodmod.raw_materials.food.soy.Soy
import jp.artan.japanesefoodmod.raw_materials.seaweed.RawMaterialSeaweed
import jp.artan.japanesefoodmod.raw_materials.wood.RawMaterialsFruitTree
import jp.artan.japanesefoodmod.raw_materials.world.seaweed.LaminariaceaeGen
import jp.artan.japanesefoodmod.raw_materials.world.seaweed.OgonoriGen
import jp.artan.japanesefoodmod.raw_materials.world.seaweed.TengsaGen
import jp.artan.japanesefoodmod.raw_materials.world.tree.AlmondTreeSupplier
import jp.artan.japanesefoodmod.raw_materials.world.tree.BananaTreeSupplier
import jp.artan.japanesefoodmod.raw_materials.world.tree.GrapeTreeSupplier
import jp.artan.japanesefoodmod.raw_materials.world.tree.JuglansTreeSupplier
import java.util.ArrayList

class BlockInit {
    companion object {
        val BLOCKS = ArrayList<IBlockRegisterEvent>()

        // 果樹
        val BANANA = RawMaterialsFruitTree("banana", 1, 0.3F, BananaTreeSupplier())
        val GRAPE = RawMaterialsFruitTree("grape", 1, 0.3F, GrapeTreeSupplier())
        val ALMOND = RawMaterialsFruitTree("almond", 1, 0.2F, AlmondTreeSupplier())
        val JUGLANS = RawMaterialsFruitTree("juglans", 1, 0.2F, JuglansTreeSupplier())
        val CITRON = RawMaterialsFruitTree("citron", 1, 0.2F, JuglansTreeSupplier())
        val ORANGE = RawMaterialsFruitTree("orange", 1, 0.2F, JuglansTreeSupplier())
        val MANDARIN_ORANGE = RawMaterialsFruitTree("mandarin_orange", 1, 0.2F, JuglansTreeSupplier())
        val CHESTNUT = RawMaterialsFruitTree("chestnut", 1, 0.2F, JuglansTreeSupplier())

        // 作物　種と作物が同じタイプ
        val SOY = Soy()
        val WHITE_GREEN_BEANS = RawMaterialSameCropAsSeed("white_green_beans", 1, 0.2F)
        val WHITE_RED_BEANS = RawMaterialSameCropAsSeed("white_red_beans", 1, 0.2F)
        val RED_BEANS = RawMaterialSameCropAsSeed("red_beans", 1, 0.2F)
        val PEANUTS = RawMaterialSameCropAsSeed("peanuts", 1, 0.2F)
        val CHILI = RawMaterialSameCropAsSeed("chili", 1, 0.1F)
        val TEBOUMAME = RawMaterialSameCropAsSeed("teboumame", 1, 0.2F)
        val ONION = RawMaterialSameCropAsSeed("onion", 1, 0.1F)
        val GINGER = RawMaterialSameCropAsSeed("ginger", 1, 0.1F)
        val BROAD_BEANS = RawMaterialSameCropAsSeed("broad_beans", 1, 0.1F)
        val YAM = RawMaterialSameCropAsSeed("yam", 1, 0.1F)
        val GARLIC = RawMaterialSameCropAsSeed("garlic", 1, 0.1F)
        val RED_POTATO = RawMaterialSameCropAsSeed("red_potato", 1, 0.1F)

        // 作物　種と作物が異なるタイプ
        val RADISH = RawMaterialSameCropsWithSeeds("radish", 1, 0.4F)
        val NOZAWANA = RawMaterialSameCropsWithSeeds("nozawana", 1, 0.2F)
        val EGGPLANT = RawMaterialSameCropsWithSeeds("eggplant", 1, 0.2F)
        val SHISO = RawMaterialSameCropsWithSeeds("shiso", 1, 0.1F)
        val STRAWBERRY = RawMaterialSameCropsWithSeeds("strawberry", 1, 0.2F)
        val BARLEY = RawMaterialSameCropsWithSeeds("barley", 1, 1.0F)

        // 作物　種と作物が異なるタイプの水上作物
        val GLUTINOUS_RICE = RawMaterialSameWaterCropsWithSeeds("glutinous_rice", 1, 0.2F)
        val RICE = RawMaterialSameWaterCropsWithSeeds("rice", 1, 1.0F)

        // 海藻
        val SEAWEEDS = RawMaterialSeaweed("laminariaceae", 1, 0.1F, 10, LaminariaceaeGen())
        val TENGSA = RawMaterialSeaweed("tengsa", 1, 0.1F, 10, TengsaGen())
        val OGONORI = RawMaterialSeaweed("ogonori", 1, 0.1F, 10, OgonoriGen())
    }
}
