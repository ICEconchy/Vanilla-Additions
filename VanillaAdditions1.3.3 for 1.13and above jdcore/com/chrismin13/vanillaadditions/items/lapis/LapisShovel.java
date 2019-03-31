package com.chrismin13.vanillaadditions.items.lapis;

import com.chrismin13.additionsapi.enums.ToolType;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class LapisShovel extends LapisItem
{
  public LapisShovel()
  {
    super(DamageableItem.IRON_SHOVEL, "vanilla_additions:lapis_shovel", "Lapis Shovel", "lapis_shovel");
    addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.LAPIS_LAZULI), new RecipeIngredient(Material.STICK)));
  }
}
