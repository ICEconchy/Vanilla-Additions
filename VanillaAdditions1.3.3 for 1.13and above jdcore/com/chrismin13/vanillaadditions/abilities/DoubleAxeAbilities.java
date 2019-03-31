package com.chrismin13.vanillaadditions.abilities;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.utils.TreeFeller;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public abstract interface DoubleAxeAbilities
{
  public void chopTree(Player player, Block block, CustomItemStack cStack)
  {
    TreeFeller.chop(block, player, cStack);
  }
  
  public void modifyCustomItem(CustomTool cTool, Material craftingMaterial) {
    modifyCustomItem(cTool, new RecipeIngredient(craftingMaterial));
  }
  
  public void modifyCustomItem(CustomTool cTool, RecipeIngredient craftingIngredient) {
    cTool.getCustomRecipes().clear();
    cTool.addAttackSpeed(getAttackSpeed(cTool.getMaterial()));
    cTool.addAttackDamage(MaterialUtils.getBaseDamage(cTool.getMaterial()));
    cTool.addCustomRecipe(getRecipe(craftingIngredient, new RecipeIngredient(Material.STICK)));
  }
  
  public float getAttackSpeed(Material material) {
    return MaterialUtils.getBaseSpeed(material) - 0.3F;
  }
  
  public CustomShapedRecipe getRecipe(RecipeIngredient craftingIngredient, RecipeIngredient recipeIngredient) {
    return 
      new CustomShapedRecipe().setShape("111", "121", "020").setIngredient('1', craftingIngredient).setIngredient('2', recipeIngredient);
  }
}
