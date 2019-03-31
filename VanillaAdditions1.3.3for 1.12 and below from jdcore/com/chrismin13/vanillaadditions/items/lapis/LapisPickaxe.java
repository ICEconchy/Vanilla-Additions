package com.chrismin13.vanillaadditions.items.lapis;

import com.chrismin13.additionsapi.enums.ToolType;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class LapisPickaxe extends LapisItem
{
  public LapisPickaxe()
  {
    super(DamageableItem.IRON_PICKAXE, "vanilla_additions:lapis_pickaxe", "Lapis Pickaxe", "lapis_pickaxe");
    addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.INK_SACK, (byte)4), new RecipeIngredient(Material.STICK)));
  }
}
