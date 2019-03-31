package com.chrismin13.vanillaadditions.items.coal;

import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class CoalSword extends CoalItem
{
  public CoalSword()
  {
    super(DamageableItem.WOODEN_SWORD, "vanilla_additions:coal_sword", "Coal Sword", "coal_sword");
    
    addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.COAL, Material.STICK));
  }
  
  public int getCoalAmount()
  {
    return 2;
  }
  
  public int getStickAmount()
  {
    return 1;
  }
}
