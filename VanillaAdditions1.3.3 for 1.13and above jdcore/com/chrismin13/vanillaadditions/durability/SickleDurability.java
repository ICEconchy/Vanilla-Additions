package com.chrismin13.vanillaadditions.durability;

import com.chrismin13.additionsapi.durability.ItemDurability;
import org.bukkit.Material;

public class SickleDurability extends ItemDurability
{
  public SickleDurability()
  {
    addSpecialBlock(Material.WHEAT, 1);
    addSpecialBlock(Material.CARROTS, 1);
    addSpecialBlock(Material.POTATOES, 1);
    addSpecialBlock(Material.BEETROOTS, 1);
    addSpecialBlock(Material.NETHER_WART, 1);
    setBlockBreak(1);
    setEntityHit(2);
  }
}
