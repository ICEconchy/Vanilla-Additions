package com.chrismin13.vanillaadditions.items.coal;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;


public abstract class CoalItem
  extends AverageTexturedTool
{
  public CoalItem(DamageableItem paramDamageableItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramDamageableItem, Material.STONE_SWORD.getMaxDurability(), paramString1, paramString2, paramString3);
    setBurnTime(getStickAmount() * 100 + getCoalAmount() * 800);
  }
  
  public abstract int getCoalAmount();
  
  public abstract int getStickAmount();
}
