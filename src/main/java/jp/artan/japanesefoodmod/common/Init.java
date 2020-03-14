package jp.artan.japanesefoodmod.common;

import java.util.ArrayList;
import java.util.List;

import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import jp.artan.japanesefoodmod.common.event.IItemRegisterEvent;

public class Init {
  public static List<IItemRegisterEvent> ITEMS = new ArrayList<IItemRegisterEvent>();
  public static List<IBlockRegisterEvent> BLOCKS = new ArrayList<IBlockRegisterEvent>();
}
