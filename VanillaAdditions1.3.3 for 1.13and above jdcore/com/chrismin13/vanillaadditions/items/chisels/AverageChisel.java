package com.chrismin13.vanillaadditions.items.chisels;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class AverageChisel
  extends AverageTexturedTool
  implements ChiselAbilities
{
  public AverageChisel(DamageableItem paramDamageableItem, int paramInt, String paramString1, String paramString2, String paramString3, Material paramMaterial)
  {
    super(paramDamageableItem, paramInt, paramString1, paramString2, paramString3);
    
    modifyCustomItem(this, paramMaterial);
  }
}
