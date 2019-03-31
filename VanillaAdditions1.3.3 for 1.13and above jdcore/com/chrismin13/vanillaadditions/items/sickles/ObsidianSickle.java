package com.chrismin13.vanillaadditions.items.sickles;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianSickle
  extends ObsidianItem implements SickleAbilities
{
  public ObsidianSickle()
  {
    super(DamageableItem.IRON_HOE, "vanilla_additions:obsidian_sickle", "Obsidian Sickle", "obsidian_sickle");
    
    modifyCustomItem(this, new RecipeIngredient(Material.OBSIDIAN));
  }
  
  public int getBreakRadius()
  {
    return 3;
  }
}
