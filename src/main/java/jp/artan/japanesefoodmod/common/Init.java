package jp.artan.japanesefoodmod.common;

import java.util.ArrayList;
import java.util.List;

import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import jp.artan.japanesefoodmod.common.potion.JapanesePotion;
import jp.artan.japanesefoodmod.common.potion.JapanesePotionType;

public class Init {
  public static List<IItemRegisterEvent> ITEMS = new ArrayList<IItemRegisterEvent>();
  public static List<IBlockRegisterEvent> BLOCKS = new ArrayList<IBlockRegisterEvent>();
  public static List<JapanesePotion> POTIONS = new ArrayList<JapanesePotion>();
  public static List<JapanesePotionType> POTION_TYPES = new ArrayList<JapanesePotionType>();
}
