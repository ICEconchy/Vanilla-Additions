package com.chrismin13.vanillaadditions.items.clay;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;


public class ClayItem
  extends AverageTexturedTool
{
  public ClayItem(DamageableItem paramDamageableItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramDamageableItem, Material.GOLD_SWORD.getMaxDurability(), paramString1, paramString2, paramString3);
  }
}
