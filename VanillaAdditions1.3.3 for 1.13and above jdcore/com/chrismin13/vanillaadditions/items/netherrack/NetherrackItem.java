package com.chrismin13.vanillaadditions.items.netherrack;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;


public class NetherrackItem
  extends AverageTexturedTool
{
  public NetherrackItem(DamageableItem paramDamageableItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramDamageableItem, Material.WOODEN_SWORD.getMaxDurability(), paramString1, paramString2, paramString3);
  }
}
