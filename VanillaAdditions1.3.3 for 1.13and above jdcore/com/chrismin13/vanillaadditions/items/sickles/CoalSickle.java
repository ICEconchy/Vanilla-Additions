package com.chrismin13.vanillaadditions.items.sickles;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.coal.CoalItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class CoalSickle
  extends CoalItem implements SickleAbilities
{
  public CoalSickle()
  {
    super(DamageableItem.WOODEN_HOE, "vanilla_additions:coal_sickle", "Coal Sickle", "coal_sickle");
    
    modifyCustomItem(this, new RecipeIngredient(Material.COAL));
  }
  
  public int getBreakRadius()
  {
    return 1;
  }
  
  public int getCoalAmount()
  {
    return 3;
  }
  
  public int getStickAmount()
  {
    return 1;
  }
}
