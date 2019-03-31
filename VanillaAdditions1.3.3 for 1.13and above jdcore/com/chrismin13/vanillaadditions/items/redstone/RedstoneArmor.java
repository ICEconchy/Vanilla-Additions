package com.chrismin13.vanillaadditions.items.redstone;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import org.bukkit.Color;
import org.bukkit.Material;

public class RedstoneArmor extends AverageLeatherArmor
{
  public RedstoneArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, 0, "vanilla_additions:redstone_" + paramArmorType
      .toString().toLowerCase(), "Redstone " + paramArmorType
      .toIngameString(), Color.fromRGB(205, 0, 0), Material.REDSTONE, 
      MaterialUtils.getBaseArmor(paramArmorType.getChainmailMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getChainmailMaterial()));
    setUnbreakable(Boolean.valueOf(false));
  }
}
