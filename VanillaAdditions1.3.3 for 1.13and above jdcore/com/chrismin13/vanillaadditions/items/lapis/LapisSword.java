package com.chrismin13.vanillaadditions.items.lapis;

import com.chrismin13.additionsapi.enums.ToolType;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class LapisSword extends LapisItem
{
  public LapisSword()
  {
    super(DamageableItem.IRON_SWORD, "vanilla_additions:lapis_sword", "Lapis Sword", "lapis_sword");
    addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.LAPIS_LAZULI), new RecipeIngredient(Material.STICK)));
  }
}
