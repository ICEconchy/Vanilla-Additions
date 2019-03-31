package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.vanillaadditions.Items;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpongeListener implements org.bukkit.event.Listener
{
  public SpongeListener() {}
  
  @EventHandler(priority=EventPriority.HIGH)
  public void onBlockPlace(BlockPlaceEvent paramBlockPlaceEvent)
  {
    if (paramBlockPlaceEvent.isCancelled()) {
      return;
    }
    if (Items.config.getStringList("enabled-mechanics") == null)
      return;
    List localList = Items.config.getStringList("enabled-mechanics");
    
    Block localBlock = paramBlockPlaceEvent.getBlock();
    Material localMaterial = localBlock.getType();
    Biome localBiome = localBlock.getBiome();
    
    if (localBiome == Biome.NETHER)
    {
      if ((localList.contains("WET_SPONGE_TO_SPONGE")) && (localMaterial == Material.WET_SPONGE)) {
        localBlock.setType(Material.SPONGE);
        Location localLocation = localBlock.getLocation();
        localBlock.getWorld().spawnParticle(org.bukkit.Particle.SMOKE_LARGE, localLocation.getX() - 0.5D, localLocation.getY() + 0.5D, localLocation.getZ() + 0.5D, 10);
      }
    }
  }
}
