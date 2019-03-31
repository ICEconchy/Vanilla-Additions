package com.chrismin13.vanillaadditions.items.sickles;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.slime.SlimeItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class SlimeSickle
  extends SlimeItem implements SickleAbilities
{
  public SlimeSickle()
  {
    super(DamageableItem.WOODEN_HOE, "vanilla_additions:slime_sickle", "Slime Sickle", "slime_sickle");
    
    modifyCustomItem(this, new RecipeIngredient(Material.SLIME_BALL));
  }
  
  public int getBreakRadius()
  {
    return 1;
  }
}
