package com.chrismin13.vanillaadditions.abilities;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.utils.BlockUtils;
import java.util.ArrayList;
import java.util.Collection;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public abstract interface HammerAbilities
{
  public static final boolean onlyBreakSameType = VanillaAdditions.getInstance().getConfig().getBoolean("hammer.only-break-same-type");
  
  public void onUse(Block block, BlockFace face, CustomItemStack cStack, Player player) {
    ArrayList<Block> blocks = new ArrayList();
    switch (1.$SwitchMap$org$bukkit$block$BlockFace[face.ordinal()]) {
    case 1: 
    case 2: 
      blocks.add(block.getRelative(1, 0, 0));
      blocks.add(block.getRelative(1, 0, 1));
      blocks.add(block.getRelative(1, 0, -1));
      blocks.add(block.getRelative(-1, 0, 0));
      blocks.add(block.getRelative(-1, 0, 1));
      blocks.add(block.getRelative(-1, 0, -1));
      blocks.add(block.getRelative(0, 0, 1));
      blocks.add(block.getRelative(0, 0, -1));
      break;
    case 3: 
    case 4: 
      blocks.add(block.getRelative(0, 1, 0));
      blocks.add(block.getRelative(0, 1, 1));
      blocks.add(block.getRelative(0, 1, -1));
      blocks.add(block.getRelative(0, -1, 0));
      blocks.add(block.getRelative(0, -1, 1));
      blocks.add(block.getRelative(0, -1, -1));
      blocks.add(block.getRelative(0, 0, 1));
      blocks.add(block.getRelative(0, 0, -1));
      break;
    case 5: 
    case 6: 
      blocks.add(block.getRelative(1, 0, 0));
      blocks.add(block.getRelative(1, 1, 0));
      blocks.add(block.getRelative(1, -1, 0));
      blocks.add(block.getRelative(-1, 0, 0));
      blocks.add(block.getRelative(-1, 1, 0));
      blocks.add(block.getRelative(-1, -1, 0));
      blocks.add(block.getRelative(0, 1, 0));
      blocks.add(block.getRelative(0, -1, 0));
      break;
    }
    
    
    for (Block blockToBreak : blocks) {
      if (shouldBreakBlock(blockToBreak, block.getType(), cStack)) {
        BlockUtils.breakBlock(blockToBreak, cStack, player);
      }
    }
  }
  
  public boolean shouldBreakBlock(Block blockToBreak, Material originalBlockMaterial, CustomItemStack cStack) {
    if (onlyBreakSameType) {
      return blockToBreak.getType().equals(originalBlockMaterial);
    }
    return !blockToBreak.getDrops(cStack.getItemStack()).isEmpty();
  }
  
  public void modifyCustomItem(CustomTool cTool, Material craftingMaterial)
  {
    modifyCustomItem(cTool, new RecipeIngredient(craftingMaterial));
  }
  
  public void modifyCustomItem(CustomTool cTool, RecipeIngredient craftingIngredient) {
    cTool.getCustomRecipes().clear();
    cTool.addAllCustomRecipes(getRecipes(craftingIngredient, new RecipeIngredient(Material.STICK)));
    cTool.addAttackSpeed(getAttackSpeed(cTool.getMaterial()));
    cTool.addAttackDamage(getAttackDamage(cTool.getMaterial()));
  }
  

  public ArrayList<CustomShapedRecipe> getRecipes(RecipeIngredient craftingIngredient, RecipeIngredient recipeIngredient)
  {
    CustomShapedRecipe recipe = new CustomShapedRecipe().setShape("111", "120", "020").setIngredient('1', craftingIngredient).setIngredient('2', recipeIngredient);
    ArrayList<CustomShapedRecipe> recipes = new ArrayList();
    recipes.add(recipe);
    recipes.add(new CustomShapedRecipe(recipe).setShape("111", "021", "020"));
    return recipes;
  }
  
  public float getAttackSpeed(Material material) {
    return MaterialUtils.getBaseSpeed(material) - 0.3F;
  }
  
  public float getAttackDamage(Material material) {
    return MaterialUtils.getBaseDamage(material) + 2.0F;
  }
}
