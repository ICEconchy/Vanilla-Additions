package com.chrismin13.vanillaadditions.items.sickles;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public abstract class AverageSickle
  extends AverageTexturedTool implements SickleAbilities
{
  public AverageSickle(DamageableItem paramDamageableItem, int paramInt, String paramString1, String paramString2, String paramString3, RecipeIngredient paramRecipeIngredient)
  {
    super(paramDamageableItem, paramInt, paramString1, paramString2, paramString3);
    
    modifyCustomItem(this, paramRecipeIngredient);
  }
  
  public AverageSickle(DamageableItem paramDamageableItem, int paramInt, String paramString1, String paramString2, String paramString3, Material paramMaterial)
  {
    this(paramDamageableItem, paramInt, paramString1, paramString2, paramString3, new RecipeIngredient(paramMaterial));
  }
}
