package com.chrismin13.vanillaadditions.items;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.items.CustomLeatherArmor;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import org.bukkit.Color;
import org.bukkit.Material;

public class AverageLeatherArmor
  extends CustomLeatherArmor
{
  public AverageLeatherArmor(ArmorType paramArmorType, int paramInt, String paramString1, String paramString2, Color paramColor)
  {
    super(paramArmorType, 1, (short)0, paramString1, paramColor);
    

    setDisplayName(paramString2);
    setUnbreakable(Boolean.valueOf(true));
    setFakeDurability(paramInt);
    setEnchantable(true);
    setUnbreakableVisibility(false);
    setCombinedInCrafting(true);
  }
  
  public AverageLeatherArmor(ArmorType paramArmorType, int paramInt, String paramString1, String paramString2, Color paramColor, RecipeIngredient paramRecipeIngredient)
  {
    this(paramArmorType, paramInt, paramString1, paramString2, paramColor);
    
    addAllCustomRecipes(getArmorType().getCustomShapedRecipe(paramRecipeIngredient));
  }
  
  public AverageLeatherArmor(ArmorType paramArmorType, int paramInt, String paramString1, String paramString2, Color paramColor, RecipeIngredient paramRecipeIngredient, double paramDouble1, double paramDouble2)
  {
    this(paramArmorType, paramInt, paramString1, paramString2, paramColor, paramRecipeIngredient);
    
    addArmor(paramDouble1);
    addArmorToughness(paramDouble2);
  }
  
  public AverageLeatherArmor(ArmorType paramArmorType, int paramInt, String paramString1, String paramString2, Color paramColor, Material paramMaterial)
  {
    this(paramArmorType, paramInt, paramString1, paramString2, paramColor);
    
    addAllCustomRecipes(getArmorType().getCustomShapedRecipe(paramMaterial));
  }
  
  public AverageLeatherArmor(ArmorType paramArmorType, int paramInt, String paramString1, String paramString2, Color paramColor, Material paramMaterial, double paramDouble1, double paramDouble2)
  {
    this(paramArmorType, paramInt, paramString1, paramString2, paramColor, paramMaterial);
    
    addArmor(paramDouble1);
    addArmorToughness(paramDouble2);
  }
}
