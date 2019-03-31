package com.chrismin13.vanillaadditions.items.prismarine;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;


public class PrismarineItem
  extends AverageTexturedTool
{
  public PrismarineItem(DamageableItem paramDamageableItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramDamageableItem, Material.IRON_SWORD.getMaxDurability(), paramString1, paramString2, paramString3);
  }
}
