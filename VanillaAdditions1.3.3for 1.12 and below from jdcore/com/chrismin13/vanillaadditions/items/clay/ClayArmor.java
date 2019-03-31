package com.chrismin13.vanillaadditions.items.clay;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import org.bukkit.Color;
import org.bukkit.Material;

public class ClayArmor extends AverageLeatherArmor
{
  public ClayArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, paramArmorType.getGoldMaterial().getMaxDurability(), "vanilla_additions:clay_" + paramArmorType
      .toString().toLowerCase(), "Clay " + paramArmorType
      .toIngameString(), Color.fromRGB(165, 169, 185), Material.CLAY_BALL, 
      MaterialUtils.getBaseArmor(paramArmorType.getLeatherMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getLeatherMaterial()));
  }
}
