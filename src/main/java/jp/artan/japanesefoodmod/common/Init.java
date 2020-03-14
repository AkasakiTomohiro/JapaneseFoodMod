package jp.artan.japanesefoodmod.common;

import java.util.ArrayList;
import java.util.List;

import jp.artan.japanesefoodmod.common.event.IBlockRegisterEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Init {
  public static List<Item> ITEMS = new ArrayList<Item>();
  public static List<IBlockRegisterEvent> BLOCKS = new ArrayList<IBlockRegisterEvent>();
}
