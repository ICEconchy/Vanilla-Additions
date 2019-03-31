package com.chrismin13.vanillaadditions.utils;

import org.bukkit.Chunk;
import org.bukkit.Location;

public class SlimeChunkUtils
{
  public SlimeChunkUtils() {}
  
  public static boolean isSlimeChunk(Location paramLocation)
  {
    Chunk localChunk = paramLocation.getChunk();
    int i = localChunk.getX();
    int j = localChunk.getZ();
    Long localLong = Long.valueOf(paramLocation.getWorld().getSeed());
    

    java.util.Random localRandom = new java.util.Random(localLong.longValue() + i * i * 4987142 + i * 5947611 + j * j * 4392871L + j * 389711 ^ 0x3AD8025F);
    if (localRandom.nextInt(10) == 0) {
      return true;
    }
    org.bukkit.block.Biome localBiome = paramLocation.getBlock().getBiome();
    if (localBiome.equals(org.bukkit.block.Biome.SWAMPLAND)) {
      return true;
    }
    return false;
  }
}
