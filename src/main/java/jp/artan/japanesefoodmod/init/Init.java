package jp.artan.japanesefoodmod.init;

import java.util.ArrayList;
import java.util.List;

import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;
import jp.artan.japanesefoodmod.common.potion.JapanesePotion;
import jp.artan.japanesefoodmod.common.potion.JapanesePotionType;
import jp.artan.japanesefoodmod.common.world.biome.CustomBiome;

public class Init {
  public static List<IBlockRegisterEvent> BLOCKS = new ArrayList<IBlockRegisterEvent>();
  public static List<JapanesePotion> POTIONS = new ArrayList<JapanesePotion>();
  public static List<JapanesePotionType> POTION_TYPES = new ArrayList<JapanesePotionType>();
  public static List<CustomBiome> BIOMES = new ArrayList<CustomBiome>();
}
