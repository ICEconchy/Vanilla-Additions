package com.chrismin13.vanillaadditions.items.lapis;

import com.chrismin13.additionsapi.enums.ToolType;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class LapisHoe extends LapisItem
{
  public LapisHoe()
  {
    super(DamageableItem.IRON_HOE, "vanilla_additions:lapis_hoe", "Lapis Hoe", "lapis_hoe");
    addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.INK_SACK, (byte)4), new RecipeIngredient(Material.STICK)));
  }
}
