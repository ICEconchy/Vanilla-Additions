package com.chrismin13.vanillaadditions.items.netherrack;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import org.bukkit.Color;
import org.bukkit.Material;

public class NetherrackArmor extends AverageLeatherArmor
{
  public NetherrackArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, paramArmorType.getLeatherMaterial().getMaxDurability() / 2, "vanilla_additions:netherrack_" + paramArmorType
      .toString().toLowerCase(), "Netherrack " + paramArmorType
      .toIngameString(), Color.fromRGB(166, 89, 89), Material.NETHERRACK, 
      MaterialUtils.getBaseArmor(paramArmorType.getChainmailMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getChainmailMaterial()));
  }
}
