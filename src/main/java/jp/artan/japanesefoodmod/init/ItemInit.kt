package jp.artan.japanesefoodmod.init

import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent
import jp.artan.japanesefoodmod.common.food.IntermediateMaterial
import jp.artan.japanesefoodmod.common.tool.CustomTool
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood
import jp.artan.japanesefoodmod.souvenir.food.SouvenirFood
import java.util.ArrayList

class ItemInit {
    companion object {
        val ITEMS = ArrayList<IItemRegisterEvent>()

        // ツール
        val GROUND_WOOD = CustomTool("ground_wood")

        // 魚
        val CLUEA_PALLASII = RawMaterialFood("clupea_pallasii", 1, 1.0F)
        val CLUEA_PALLASII_BAKED = RawMaterialFood("clupea_pallasii_baked", 1, 1.5F)
        val SQUID = RawMaterialFood("squid", 1, 0.4F)

        // 中間素材
        val COCOA_BUTTER = IntermediateMaterial("cocoa_butter")
        val ALMOND_POWDER = IntermediateMaterial("almond_powder")
        val SALT = IntermediateMaterial("salt")
        val ALCOHOL = IntermediateMaterial("alcohol")
        val SOY_SAUCE = IntermediateMaterial("soy_sauce")
        val RICE_FLOUR = IntermediateMaterial("rice_flour")
        val POPPY_SEED = IntermediateMaterial("poppy_seed")
        val CONDENSED_MILK = IntermediateMaterial("condensed_milk")

        // 加工品
        val BUTTER = RawMaterialFood("butter", 1, 0.3F)
        val RAISIN = RawMaterialFood("raisin", 1, 0.2F)
        val RUM = RawMaterialFood("rum", 1, 0.1F)
        val RUM_RAISIN = RawMaterialFood("rum_raisin", 1, 0.2F)
        val HERRING_ROE = RawMaterialFood("herring_roe", 1, 0.2F)
        val DRIED_SQUID = RawMaterialFood("dried_squid", 1, 0.6F)
        val SYRUP = RawMaterialFood("syrup", 1, 0.6F)
        val WHITE_BEAN_PASTE = RawMaterialFood("white_bean_paste", 1, 0.1F)
        val AGAR = RawMaterialFood("agar", 1, 0.1F)
        val ROASTED_SOYBEAN_FLOUR = RawMaterialFood("roasted_soybean_flour", 1, 0.1F)
        val EDAMAME = RawMaterialFood("edamame", 1, 0.1F)
        val CHOCOLATE = RawMaterialFood("chocolate", 1, 0.4F)

        // お土産
        val MARUSEI_BUTTER_SAND = SouvenirFood("marusei_butter_sand", 2, 0.5F)
        val KININ_TSUGARU_DUKE = SouvenirFood("kinin_tsugaru_duke", 1, 0.1F)
        val LE_DESERE = SouvenirFood("le_desere", 2, 0.6F)
        val KAMOMES_EGG = SouvenirFood("kamomes_egg", 2, 0.8F)
        val KOKYO = SouvenirFood("kokyo", 2, 0.4F)
        val HAGINOTSUKI = SouvenirFood("haginotsuki", 2, 0.5F)
        val KADEN_YUBESHI = SouvenirFood("kaden_yubeshi", 2, 0.5F)
        val YOSHIWARADENTYU = SouvenirFood("yoshiwaradentyu", 2, 1.0F)
        val KOIN_MANAKA = SouvenirFood("koin_monaka", 2, 0.3F)
        val TABIGARASU = SouvenirFood("tabigarasu", 1, 0.2F)
        val PEANUTS_MONAKA = SouvenirFood("peanuts_monaka", 1, 1.0F)
        val SOUKA_SENBEI = SouvenirFood("souka_senbei", 2, 1.0F)
        val TOKYO_BANANA = SouvenirFood("tokyo_banana", 2, 0.5F)
        val HATO_SABLE = SouvenirFood("hato_sable", 2, 1.0F)
        val SASADANGO = SouvenirFood("sasadango", 2, 1.2F)
        val KANOKOMOTI = SouvenirFood("kanokomoti", 1, 0.6F)
        val YUUZENKOROMO = SouvenirFood("yuuzenkoromo", 1, 0.6F)
        val KIKYOSHINGENMOTI = SouvenirFood("kikyoshingenmoti", 1, 0.6F)
        val UNAGIPIE = SouvenirFood("unagipie", 1, 0.6F)
        val NOZAWANADUKE = SouvenirFood("nozawanaduke", 1, 0.6F)
        val KISIMENPIE = SouvenirFood("kisimenpie", 2, 0.8F)
        val OKIAGARIMONAKA = SouvenirFood("okiagarimonaka", 2, 0.5F)
        val HABUTAEMOTI = SouvenirFood("habutaemoti", 1, 1.0F)
        val ITOKIRIMOTI = SouvenirFood("itokirimoti", 1, 0.6F)
        val AKAHUKUMOTI = SouvenirFood("akahukumoti", 1, 0.7F)
        val AJARIMOTI = SouvenirFood("ajarimoti", 1, 0.6F)
        val BUTAMAN = SouvenirFood("551butaman", 3, 3.0F)
        val NAMAWARABIMOTI = SouvenirFood("namawarabimoti", 1, 0.6F)
        val KINZANJIMISO = SouvenirFood("kinzanjimiso", 1, 0.1F)
        val GAUFRES = SouvenirFood("gaufres", 1, 0.5F)
        val MOMIJIMANJU = SouvenirFood("momijimanju", 2, 1.0F)
        val OTEMANJU = SouvenirFood("otemanju", 1, 0.6F)
        val INABA_NO_SHIROUSHAGI = SouvenirFood("inaba_no_shiroushagi", 1, 0.5F)
        val WAKAKUSA = SouvenirFood("wakakusa", 2, 1.0F)
        val MEIKA_SHITATUDUMI = SouvenirFood("meika_shitatudumi", 1, 1.0F)
        val SYOUYUMAME = SouvenirFood("syouyumame", 1, 0.1F)
        val TOSAMEIKA_KANZASHI = SouvenirFood("tosameika_kanzashi", 1, 1.0F)
        val MARUGOTO_MIKANDAIHUKU = SouvenirFood("marugoto_mikandaihuku", 1, 1.0F)
        val TAKETIKUWA = SouvenirFood("taketikuwa", 1, 1.0F)
        val HAKATA_TORIMON = SouvenirFood("hakata_torimon", 1, 1.0F)
        val NANBANGASHI_XAVIER = SouvenirFood("nanbangashi_xavier", 1, 1.0F)
        val IKASYUMAI = SouvenirFood("ikasyumai", 1, 1.0F)
        val NAGASAKI_KAKUNIMANJU = SouvenirFood("nagasaki_kakunimanju", 1, 1.0F)
        val NANJAKORADAIHUKU = SouvenirFood("nanjakoradaihuku", 1, 1.0F)
        val HOMARENOJINDAIKO = SouvenirFood("homarenojindaiko", 1, 1.0F)
        val KASUTADON = SouvenirFood("kasutadon", 1, 1.0F)
        val BENIIMOTART = SouvenirFood("beniimotart", 1, 1.0F)
    }
}
