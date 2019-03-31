package com.chrismin13.vanillaadditions.items.sickles;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedSickle
  extends WoodBasedItem implements SickleAbilities
{
  public WoodBasedSickle(Material paramMaterial, String paramString1, String paramString2, String paramString3)
  {
    super(DamageableItem.WOODEN_HOE, paramString1, paramString2, paramString3, "wooden_sickle");
    
    modifyCustomItem(this, new RecipeIngredient(paramMaterial));
  }
  
  public int getBreakRadius()
  {
    return 1;
  }
}
