package com.chrismin13.vanillaadditions.items.sickles;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneSickle
  extends RedstoneItem implements SickleAbilities
{
  public RedstoneSickle()
  {
    super(DamageableItem.STONE_HOE, "vanilla_additions:redstone_sickle", "Redstone Sickle", "redstone_sickle");
    
    modifyCustomItem(this, new RecipeIngredient(Material.REDSTONE));
  }
  
  public int getBreakRadius()
  {
    return 2;
  }
}
