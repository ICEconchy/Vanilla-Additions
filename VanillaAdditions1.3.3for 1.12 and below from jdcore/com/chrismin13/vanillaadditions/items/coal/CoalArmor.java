package com.chrismin13.vanillaadditions.items.coal;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import org.bukkit.Color;
import org.bukkit.Material;

public class CoalArmor extends AverageLeatherArmor
{
  public CoalArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, 0, "vanilla_additions:coal_" + paramArmorType.toString().toLowerCase(), "Coal " + paramArmorType
      .toIngameString(), Color.fromRGB(46, 46, 46), Material.COAL, 
      MaterialUtils.getBaseArmor(paramArmorType.getLeatherMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getLeatherMaterial()));
    setUnbreakable(Boolean.valueOf(false));
  }
}
