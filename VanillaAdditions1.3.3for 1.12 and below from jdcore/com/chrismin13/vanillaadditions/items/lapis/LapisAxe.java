package com.chrismin13.vanillaadditions.items.lapis;

import com.chrismin13.additionsapi.enums.ToolType;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class LapisAxe extends LapisItem
{
  public LapisAxe()
  {
    super(DamageableItem.IRON_AXE, "vanilla_additions:lapis_axe", "Lapis Axe", "lapis_axe");
    addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.INK_SACK, (byte)4), new RecipeIngredient(Material.STICK)));
  }
}
