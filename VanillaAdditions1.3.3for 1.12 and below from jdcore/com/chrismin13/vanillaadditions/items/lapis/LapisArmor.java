package com.chrismin13.vanillaadditions.items.lapis;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import org.bukkit.Color;
import org.bukkit.Material;

public class LapisArmor extends AverageLeatherArmor
{
  public LapisArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, paramArmorType.getLeatherMaterial().getMaxDurability(), "vanilla_additions:lapis_" + paramArmorType
      .toString().toLowerCase(), "Lapis " + paramArmorType.toIngameString(), 
      Color.fromRGB(34, 75, 175), new RecipeIngredient(Material.INK_SACK, (byte)4), MaterialUtils.getBaseArmor(paramArmorType.getIronMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getIronMaterial()));
  }
}
