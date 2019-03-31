package com.chrismin13.vanillaadditions.utils;

import com.chrismin13.additionsapi.items.CustomItemStack;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredListener;

public class BlockUtils
{
  public static Boolean ncpLoaded;
  public static RegisteredListener ncpListener;
  
  public BlockUtils() {}
  
  public static List<Block> getSquareRadius(Block paramBlock, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    
    org.bukkit.World localWorld = paramBlock.getWorld();
    
    int i = paramBlock.getX();
    int j = paramBlock.getY();
    int k = paramBlock.getZ();
    
    for (int m = i - paramInt; m < i + paramInt; m++) {
      for (int n = k - paramInt; n < k + paramInt; n++)
        localArrayList.add(localWorld.getBlockAt(m, j, n));
    }
    return localArrayList;
  }
  
  private static ArrayList<Block> blocksBeingBroken = new ArrayList();
  
  public static void addIgnoreBlocks(Block... paramVarArgs) {
    for (Block localBlock : paramVarArgs)
      blocksBeingBroken.add(localBlock);
  }
  
  public static void removeIgnoreBlocks(Block... paramVarArgs) {
    for (Block localBlock : paramVarArgs)
      if (blocksBeingBroken.contains(localBlock))
        blocksBeingBroken.remove(localBlock);
  }
  
  public static ArrayList<Block> getIgnoreBlocks() {
    return blocksBeingBroken;
  }
  
  public static boolean isBlockIgnored(Block paramBlock) {
    return blocksBeingBroken.contains(paramBlock);
  }
  
  public static boolean breakBlock(Block paramBlock, CustomItemStack paramCustomItemStack, Player paramPlayer) {
    return breakBlock(paramBlock, paramCustomItemStack, paramPlayer, false);
  }
  
  public static boolean breakBlock(Block paramBlock, CustomItemStack paramCustomItemStack, Player paramPlayer, boolean paramBoolean) {
    Integer localInteger;
    if ((paramBoolean) && (paramCustomItemStack.getCustomItem().hasFakeDurability())) {
      localInteger = Integer.valueOf(paramCustomItemStack.getFakeDurability());
    } else {
      localInteger = null;
    }
    addIgnoreBlocks(new Block[] { paramBlock });
    BlockBreakEvent localBlockBreakEvent = new BlockBreakEvent(paramBlock, paramPlayer);
    
    if (ncpLoaded == null) {
      if ((Bukkit.getPluginManager().isPluginEnabled("NoCheatPlus")) && (ncpListener == null)) {
        for (RegisteredListener localRegisteredListener : localBlockBreakEvent.getHandlers().getRegisteredListeners()) {
          if (localRegisteredListener.getListener().getClass().equals(fr.neatmonster.nocheatplus.checks.blockbreak.BlockBreakListener.class)) {
            ncpListener = localRegisteredListener;
            ncpLoaded = Boolean.valueOf(true);
            break;
          }
        }
      } else {
        ncpLoaded = Boolean.valueOf(false);
      }
    }
    
    if (ncpLoaded.booleanValue()) {
      localBlockBreakEvent.getHandlers().unregister(ncpListener);
    }
    Bukkit.getPluginManager().callEvent(localBlockBreakEvent);
    
    if (ncpLoaded.booleanValue()) {
      localBlockBreakEvent.getHandlers().register(ncpListener);
    }
    if (!localBlockBreakEvent.isCancelled())
      if (paramCustomItemStack.getItemStack() != null) {
        paramBlock.breakNaturally(paramCustomItemStack.getItemStack());
      } else
        paramBlock.breakNaturally();
    removeIgnoreBlocks(new Block[] { paramBlock });
    
    if (localInteger != null) {
      paramCustomItemStack.setFakeDurability(localInteger.intValue());
    }
    return !localBlockBreakEvent.isCancelled();
  }
}
