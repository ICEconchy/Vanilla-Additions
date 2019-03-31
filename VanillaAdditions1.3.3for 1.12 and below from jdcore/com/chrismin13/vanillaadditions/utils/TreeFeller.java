package com.chrismin13.vanillaadditions.utils;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import java.util.LinkedList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;


public class TreeFeller
{
  private static JavaPlugin plugin = ;
  
  public TreeFeller() {}
  
  public static boolean chop(Block paramBlock, Player paramPlayer, CustomItemStack paramCustomItemStack) { LinkedList localLinkedList = new LinkedList();
    Block localBlock = getHighestLog(paramBlock);
    if (isTree(localBlock, paramPlayer, paramBlock)) {
      getBlocksToChop(paramBlock, localBlock, localLinkedList);
      popLogs(localLinkedList, paramBlock.getWorld(), paramPlayer, paramCustomItemStack);
      return true;
    }
    return false;
  }
  
  public static void getBlocksToChop(Block paramBlock1, Block paramBlock2, List<Block> paramList)
  {
    while (paramBlock1.getY() <= paramBlock2.getY()) {
      if (!paramList.contains(paramBlock1)) {
        paramList.add(paramBlock1);
      }
      getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.NORTH));
      getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.NORTH_EAST));
      getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.EAST));
      getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.SOUTH_EAST));
      getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.SOUTH));
      getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.SOUTH_WEST));
      getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.WEST));
      getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.NORTH_WEST));
      if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH))) {
        getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH));
      }
      if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST))) {
        getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST));
      }
      if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.EAST))) {
        getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
      }
      if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST))) {
        getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST));
      }
      if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH))) {
        getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH));
      }
      if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST))) {
        getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST));
      }
      if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.WEST))) {
        getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
      }
      if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST))) {
        getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST));
      }
      if ((paramBlock1.getData() == 3) || (paramBlock1.getData() == 7) || (paramBlock1.getData() == 11) || 
        (paramBlock1.getData() == 15)) {
        if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH, 2))) {
          getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH, 2));
        }
        if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST, 2))) {
          getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST, 2));
        }
        if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.EAST, 2))) {
          getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.EAST, 2));
        }
        if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST, 2))) {
          getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST, 2));
        }
        if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH, 2))) {
          getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH, 2));
        }
        if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST, 2))) {
          getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST, 2));
        }
        if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.WEST, 2))) {
          getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.WEST, 2));
        }
        if (!paramList.contains(paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST, 2))) {
          getBranches(paramBlock1, paramList, paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST, 2));
        }
      }
      if (((paramList.contains(paramBlock1.getRelative(BlockFace.UP))) || 
        (paramBlock1.getRelative(BlockFace.UP).getType() != Material.LOG)) && 
        (paramBlock1.getRelative(BlockFace.UP).getType() != Material.LOG_2)) {
        break;
      }
      paramBlock1 = paramBlock1.getRelative(BlockFace.UP);
    }
  }
  
  public static void getBranches(Block paramBlock1, List<Block> paramList, Block paramBlock2) {
    if ((!paramList.contains(paramBlock2)) && ((paramBlock2.getType() == Material.LOG) || (paramBlock2.getType() == Material.LOG_2))) {
      getBlocksToChop(paramBlock2, getHighestLog(paramBlock2), paramList);
    }
  }
  
  public static Block getHighestLog(Block paramBlock) {
    int i = 1;
    while (i != 0) {
      if ((paramBlock.getRelative(BlockFace.UP).getType().equals(Material.LOG)) || 
        (paramBlock.getRelative(BlockFace.UP).getType().equals(Material.LOG_2)) || 
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().equals(Material.LOG)) || 
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().equals(Material.LOG_2)) || 
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().equals(Material.LOG)) || 
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().equals(Material.LOG_2)) || 
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().equals(Material.LOG)) || 
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().equals(Material.LOG_2)) || 
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().equals(Material.LOG)) || 
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().equals(Material.LOG_2)) || 
        
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType().equals(Material.LOG)) || 
        
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType().equals(Material.LOG_2)) || 
        
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType().equals(Material.LOG)) || 
        
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType().equals(Material.LOG_2)) || 
        
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType().equals(Material.LOG)) || 
        
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType().equals(Material.LOG_2)) || 
        
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType().equals(Material.LOG)) || 
        
        (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType().equals(Material.LOG_2))) {
        if ((paramBlock.getRelative(BlockFace.UP).getType().equals(Material.LOG)) || 
          (paramBlock.getRelative(BlockFace.UP).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP);
        } else if ((paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().equals(Material.LOG)) || 
        
          (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH);
        } else if ((paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().equals(Material.LOG)) || 
        
          (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.EAST);
        } else if ((paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().equals(Material.LOG)) || 
        
          (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH);
        } else if ((paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().equals(Material.LOG)) || 
        
          (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.WEST);
        }
        else if ((paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType().equals(Material.LOG)) || 
        
          (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST);
        }
        else if ((paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType().equals(Material.LOG)) || 
        
          (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST);
        }
        else if ((paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType().equals(Material.LOG)) || 
        
          (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST);
        }
        else if ((paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType().equals(Material.LOG)) || 
        
          (paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType().equals(Material.LOG_2))) {
          paramBlock = paramBlock.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST);
        }
      } else {
        i = 0;
      }
    }
    return paramBlock;
  }
  
  public static boolean isTree(Block paramBlock1, Player paramPlayer, Block paramBlock2)
  {
    int i = 0;
    if ((paramBlock1.getRelative(BlockFace.UP).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.UP).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.DOWN).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.DOWN).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.NORTH).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.NORTH).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.EAST).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.EAST).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.SOUTH).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.SOUTH).getType() == Material.LEAVES_2)) {
      i++;
    }
    if ((paramBlock1.getRelative(BlockFace.WEST).getType() == Material.LEAVES) || 
      (paramBlock1.getRelative(BlockFace.WEST).getType() == Material.LEAVES_2)) {
      i++;
    }
    if (i >= 2) {
      return true;
    }
    if (paramBlock1.getData() == 1) {
      paramBlock1 = paramBlock1.getRelative(BlockFace.UP);
      if ((paramBlock1.getRelative(BlockFace.UP).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.UP).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.NORTH).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.NORTH).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.EAST).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.EAST).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.SOUTH).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.SOUTH).getType() == Material.LEAVES_2)) {
        i++;
      }
      if ((paramBlock1.getRelative(BlockFace.WEST).getType() == Material.LEAVES) || 
        (paramBlock1.getRelative(BlockFace.WEST).getType() == Material.LEAVES_2)) {
        i++;
      }
      if (i >= 2) {
        return true;
      }
    }
    return false;
  }
  
  public static void popLogs(List<Block> paramList, World paramWorld, final Player paramPlayer, final CustomItemStack paramCustomItemStack)
  {
    Long localLong = Long.valueOf(0L);
    

    for (int i = 0; i < paramList.size(); i++) {
      localLong = Long.valueOf(localLong.longValue() + 1L);
      Block localBlock = (Block)paramList.get(i);
      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
      {
        public void run() {
          if (BlockUtils.breakBlock(TreeFeller.this, paramCustomItemStack, paramPlayer)) {
            TreeFeller.popLeaves(TreeFeller.this, paramCustomItemStack, paramPlayer);

          }
          

        }
        


      }, localLong.longValue());
    }
  }
  
  public static void popLeaves(Block paramBlock, final CustomItemStack paramCustomItemStack, final Player paramPlayer) {
    Long localLong = Long.valueOf(0L);
    

    for (int i = -3; i < 4; i++) {
      for (int j = -3; j < 4; j++) {
        for (int k = -3; k < 4; k++) {
          Block localBlock = paramBlock.getRelative(j, i, k);
          if ((localBlock.getType().equals(Material.LEAVES)) || (localBlock.getType().equals(Material.LEAVES_2))) {
            localLong = Long.valueOf(localLong.longValue() + 1L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
            {
              public void run()
              {
                BlockUtils.breakBlock(TreeFeller.this, paramCustomItemStack, paramPlayer, true);


              }
              



            }, localLong.longValue() / 5L);
          }
        }
      }
    }
  }
  
  public boolean isLoneLog(Block paramBlock) {
    if ((paramBlock.getRelative(BlockFace.UP).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.UP).getType() == Material.LOG_2)) {
      return false;
    }
    if (paramBlock.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
      return false;
    }
    if (hasHorizontalCompany(paramBlock)) {
      return false;
    }
    if (hasHorizontalCompany(paramBlock.getRelative(BlockFace.UP))) {
      return false;
    }
    if (hasHorizontalCompany(paramBlock.getRelative(BlockFace.DOWN))) {
      return false;
    }
    return true;
  }
  
  public boolean hasHorizontalCompany(Block paramBlock) {
    if ((paramBlock.getRelative(BlockFace.NORTH).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.NORTH).getType() == Material.LOG_2)) {
      return true;
    }
    if ((paramBlock.getRelative(BlockFace.NORTH_EAST).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.NORTH_EAST).getType() == Material.LOG_2)) {
      return true;
    }
    if ((paramBlock.getRelative(BlockFace.EAST).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.EAST).getType() == Material.LOG_2)) {
      return true;
    }
    if ((paramBlock.getRelative(BlockFace.SOUTH_EAST).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.SOUTH_EAST).getType() == Material.LOG_2)) {
      return true;
    }
    if ((paramBlock.getRelative(BlockFace.SOUTH).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.SOUTH).getType() == Material.LOG_2)) {
      return true;
    }
    if ((paramBlock.getRelative(BlockFace.SOUTH_WEST).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.SOUTH_WEST).getType() == Material.LOG_2)) {
      return true;
    }
    if ((paramBlock.getRelative(BlockFace.WEST).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.WEST).getType() == Material.LOG_2)) {
      return true;
    }
    if ((paramBlock.getRelative(BlockFace.NORTH_WEST).getType() == Material.LOG) || 
      (paramBlock.getRelative(BlockFace.NORTH_WEST).getType() == Material.LOG_2)) {
      return true;
    }
    return false;
  }
}
