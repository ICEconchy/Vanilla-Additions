package com.chrismin13.vanillaadditions.items.doubleaxes;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class AverageDoubleAxe
  extends AverageTexturedTool
  implements DoubleAxeAbilities
{
  public AverageDoubleAxe(DamageableItem paramDamageableItem, int paramInt, String paramString1, String paramString2, String paramString3, Material paramMaterial)
  {
    super(paramDamageableItem, paramInt, paramString1, paramString2, paramString3);
    
    modifyCustomItem(this, paramMaterial);
  }
}
