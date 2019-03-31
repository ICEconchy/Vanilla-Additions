package com.chrismin13.vanillaadditions.items.redstone;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;


public class RedstoneItem
  extends AverageTexturedTool
{
  public RedstoneItem(DamageableItem paramDamageableItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramDamageableItem, Material.STONE_SWORD.getMaxDurability(), paramString1, paramString2, paramString3);
  }
}
