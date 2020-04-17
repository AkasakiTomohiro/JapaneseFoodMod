package jp.artan.japanesefoodmod.init;

import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import jp.artan.japanesefoodmod.common.food.IntermediateMaterial;
import jp.artan.japanesefoodmod.common.food.JapaneseFood;
import jp.artan.japanesefoodmod.common.tool.CustomTool;
import jp.artan.japanesefoodmod.raw_materials.food.RawMaterialFood;
import jp.artan.japanesefoodmod.souvenir.food.SouvenirFood;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static List<IItemRegisterEvent> ITEMS = new ArrayList<IItemRegisterEvent>();

    // ツール
    public static final CustomTool GROUND_WOOD = new CustomTool("ground_wood");

    // 魚
    public static final JapaneseFood CLUEA_PALLASII = new RawMaterialFood("clupea_pallasii", 1, 1.0F);
    public static final JapaneseFood CLUEA_PALLASII_BAKED = new RawMaterialFood("clupea_pallasii_baked", 1, 1.5F);
    public static final JapaneseFood SQUID = new RawMaterialFood("squid", 1, 0.4F);

    // 中間素材
    public static final IntermediateMaterial COCOA_BUTTER = new IntermediateMaterial("cocoa_butter");
    public static final IntermediateMaterial ALMOND_POWDER = new IntermediateMaterial("almond_powder");
    public static final IntermediateMaterial SALT = new IntermediateMaterial("salt");
    public static final IntermediateMaterial ALCOHOL = new IntermediateMaterial("alcohol");
    public static final IntermediateMaterial SOY_SAUCE = new IntermediateMaterial("soy_sauce");
    public static final IntermediateMaterial RICE_FLOUR = new IntermediateMaterial("rice_flour");
    public static final IntermediateMaterial POPPY_SEED = new IntermediateMaterial("poppy_seed");
    public static final IntermediateMaterial CONDENSED_MILK = new IntermediateMaterial("condensed_milk");

    // 加工品
    public static final JapaneseFood BUTTER = new RawMaterialFood("butter", 1, 0.3F);
    public static final JapaneseFood RAISIN = new RawMaterialFood("raisin", 1, 0.2F);
    public static final JapaneseFood RUM = new RawMaterialFood("rum", 1, 0.1F);
    public static final JapaneseFood RUM_RAISIN = new RawMaterialFood("rum_raisin", 1, 0.2F);
    public static final JapaneseFood HERRING_ROE = new RawMaterialFood("herring_roe", 1, 0.2F);
    public static final JapaneseFood DRIED_SQUID = new RawMaterialFood("dried_squid", 1, 0.6F);
    public static final JapaneseFood SYRUP = new RawMaterialFood("syrup", 1, 0.6F);
    public static final JapaneseFood WHITE_BEAN_PASTE = new RawMaterialFood("white_bean_paste", 1, 0.1F);
    public static final JapaneseFood AGAR = new RawMaterialFood("agar", 1, 0.1F);
    public static final JapaneseFood ROASTED_SOYBEAN_FLOUR = new RawMaterialFood("roasted_soybean_flour", 1, 0.1F);
    public static final JapaneseFood EDAMAME = new RawMaterialFood("edamame", 1, 0.1F);

    // お土産
    public static final JapaneseFood MARUSEI_BUTTER_SAND = new SouvenirFood("marusei_butter_sand", 2, 0.5F);
    public static final JapaneseFood KININ_TSUGARU_DUKE = new SouvenirFood("kinin_tsugaru_duke", 1, 0.1F);
    public static final JapaneseFood LE_DESERE = new SouvenirFood("le_desere", 2, 0.6F);
    public static final JapaneseFood KAMOMES_EGG = new SouvenirFood("kamomes_egg", 2, 0.8F);
    public static final JapaneseFood KOKYO = new SouvenirFood("kokyo", 2, 0.4F);
    public static final JapaneseFood HAGINOTSUKI = new SouvenirFood("haginotsuki", 2, 0.5F);
    public static final JapaneseFood KADEN_YUBESHI = new SouvenirFood("kaden_yubeshi", 2, 0.5F);
    public static final JapaneseFood YOSHIWARADENTYU = new SouvenirFood("yoshiwaradentyu", 2, 1.0F);
    public static final JapaneseFood KOIN_MANAKA = new SouvenirFood("koin_monaka", 2, 0.3F);
    public static final JapaneseFood TABIGARASU = new SouvenirFood("tabigarasu", 1, 0.2F);
    public static final JapaneseFood PEANUTS_MONAKA = new SouvenirFood("peanuts_monaka", 1, 1.0F);
    public static final JapaneseFood SOUKA_SENBEI = new SouvenirFood("souka_senbei", 2, 1.0F);
    public static final JapaneseFood TOKYO_BANANA = new SouvenirFood("tokyo_banana", 2, 0.5F);
    public static final JapaneseFood HATO_SABLE = new SouvenirFood("hato_sable", 2, 1.0F);
    public static final JapaneseFood SASADANGO = new SouvenirFood("sasadango", 2, 1.2F);
    public static final JapaneseFood KANOKOMOTI = new SouvenirFood("kanokomoti", 1, 0.6F);
    public static final JapaneseFood YUUZENKOROMO = new SouvenirFood("yuuzenkoromo", 1, 0.6F);
    public static final JapaneseFood KIKYOSHINGENMOTI = new SouvenirFood("kikyoshingenmoti", 1, 0.6F);
    public static final JapaneseFood UNAGIPIE = new SouvenirFood("unagipie", 1, 0.6F);
    public static final JapaneseFood NOZAWANADUKE = new SouvenirFood("nozawanaduke", 1, 0.6F);
    public static final JapaneseFood KISIMENPIE = new SouvenirFood("kisimenpie", 2, 0.8F);
    public static final JapaneseFood OKIAGARIMONAKA = new SouvenirFood("okiagarimonaka", 2, 0.5F);
    public static final JapaneseFood HABUTAEMOTI = new SouvenirFood("habutaemoti", 1, 1.0F);
    public static final JapaneseFood ITOKIRIMOTI = new SouvenirFood("itokirimoti", 1, 0.6F);
    public static final JapaneseFood AKAHUKUMOTI = new SouvenirFood("akahukumoti", 1, 0.7F);
    public static final JapaneseFood AJARIMOTI = new SouvenirFood("ajarimoti", 1, 0.6F);
    public static final JapaneseFood BUTAMAN = new SouvenirFood("551butaman", 3, 3.0F);
    public static final JapaneseFood NAMAWARABIMOTI = new SouvenirFood("namawarabimoti", 1, 0.6F);
    public static final JapaneseFood KINZANJIMISO = new SouvenirFood("kinzanjimiso", 1, 0.1F);
    public static final JapaneseFood GAUFRES = new SouvenirFood("gaufres", 1, 0.5F);
    public static final JapaneseFood MOMIJIMANJU = new SouvenirFood("momijimanju", 2, 1.0F);
    public static final JapaneseFood OTEMANJU = new SouvenirFood("otemanju", 1, 0.6F);
    public static final JapaneseFood INABA_NO_SHIROUSHAGI = new SouvenirFood("inaba_no_shiroushagi", 1, 0.5F);
    public static final JapaneseFood WAKAKUSA = new SouvenirFood("wakakusa", 2, 1.0F);
    public static final JapaneseFood MEIKA_SHITATUDUMI = new SouvenirFood("meika_shitatudumi", 1, 1.0F);
    public static final JapaneseFood SYOUYUMAME = new SouvenirFood("syouyumame", 1, 0.1F);
    public static final JapaneseFood TOSAMEIKA_KANZASHI = new SouvenirFood("tosameika_kanzashi", 1, 1.0F);
    public static final JapaneseFood MARUGOTO_MIKANDAIHUKU = new SouvenirFood("marugoto_mikandaihuku", 1, 1.0F);
    public static final JapaneseFood TAKETIKUWA = new SouvenirFood("taketikuwa", 1, 1.0F);
    public static final JapaneseFood HAKATA_TORIMON = new SouvenirFood("hakata_torimon", 1, 1.0F);
    public static final JapaneseFood NANBANGASHI_XAVIER = new SouvenirFood("nanbangashi_xavier", 1, 1.0F);
    public static final JapaneseFood IKASYUMAI = new SouvenirFood("ikasyumai", 1, 1.0F);
    public static final JapaneseFood NAGASAKI_KAKUNIMANJU = new SouvenirFood("nagasaki_kakunimanju", 1, 1.0F);
    public static final JapaneseFood NANJAKORADAIHUKU = new SouvenirFood("nanjakoradaihuku", 1, 1.0F);
    public static final JapaneseFood HOMARENOJINDAIKO = new SouvenirFood("homarenojindaiko", 1, 1.0F);
    public static final JapaneseFood KASUTADON = new SouvenirFood("kasutadon", 1, 1.0F);
    public static final JapaneseFood BENIIMOTART = new SouvenirFood("beniimotart", 1, 1.0F);
}
