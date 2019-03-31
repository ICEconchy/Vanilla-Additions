package com.chrismin13.vanillaadditions.items.emerald;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import org.bukkit.Color;
import org.bukkit.Material;

public class EmeraldArmor extends AverageLeatherArmor
{
  public EmeraldArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, paramArmorType.getDiamondMaterial().getMaxDurability() * 2 + 1, "vanilla_additions:emerald_" + paramArmorType.toString().toLowerCase(), "Emerald " + paramArmorType.toIngameString(), Color.fromRGB(0, 255, 76), Material.EMERALD, 
      MaterialUtils.getBaseArmor(paramArmorType.getDiamondMaterial()), MaterialUtils.getBaseArmorToughness(paramArmorType.getDiamondMaterial()));
  }
}
