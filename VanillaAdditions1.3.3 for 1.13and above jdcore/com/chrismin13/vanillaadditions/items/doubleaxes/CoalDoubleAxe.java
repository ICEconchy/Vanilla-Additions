package com.chrismin13.vanillaadditions.items.doubleaxes;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.coal.CoalItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class CoalDoubleAxe
  extends CoalItem implements DoubleAxeAbilities
{
  public CoalDoubleAxe()
  {
    super(DamageableItem.WOODEN_AXE, "vanilla_additions:coal_double_axe", "Coal Double Axe", "coal_double_axe");
    
    modifyCustomItem(this, Material.COAL);
  }
  
  public int getCoalAmount()
  {
    return 5;
  }
  
  public int getStickAmount()
  {
    return 2;
  }
}
