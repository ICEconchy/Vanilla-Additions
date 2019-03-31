package com.chrismin13.vanillaadditions.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Slime;

public class MobUtils
{
  public MobUtils() {}
  
  public static boolean spawnSlime(Block paramBlock, BlockFace paramBlockFace)
  {
    Double localDouble1 = Double.valueOf(paramBlock.getX());
    Double localDouble2 = Double.valueOf(paramBlock.getY());
    Double localDouble3 = Double.valueOf(paramBlock.getZ());
    World localWorld = paramBlock.getWorld();
    
    switch (1.$SwitchMap$org$bukkit$block$BlockFace[paramBlockFace.ordinal()]) {
    case 1: 
      localDouble2 = Double.valueOf(localDouble2.doubleValue() + 1.0D);
      break;
    case 2: 
      localDouble2 = Double.valueOf(localDouble2.doubleValue() - 1.0D);
      break;
    case 3: 
      localDouble1 = Double.valueOf(localDouble1.doubleValue() + 1.0D);
      break;
    case 4: 
      localDouble1 = Double.valueOf(localDouble1.doubleValue() - 1.0D);
      break;
    case 5: 
      localDouble3 = Double.valueOf(localDouble3.doubleValue() + 1.0D);
      break;
    case 6: 
      localDouble3 = Double.valueOf(localDouble3.doubleValue() - 1.0D);
      break;
    }
    
    


    localDouble1 = Double.valueOf(localDouble1.doubleValue() + 0.5D);
    localDouble3 = Double.valueOf(localDouble3.doubleValue() + 0.5D);
    
    Location localLocation = new Location(localWorld, localDouble1.doubleValue(), localDouble2.doubleValue(), localDouble3.doubleValue());
    
    Block localBlock = localLocation.getBlock();
    
    if ((localBlock.getType() != org.bukkit.Material.AIR) && (!localBlock.isLiquid())) {
      return false;
    }
    Slime localSlime = (Slime)localWorld.spawnEntity(localLocation, org.bukkit.entity.EntityType.SLIME);
    localSlime.setSize(1);
    return true;
  }
}
