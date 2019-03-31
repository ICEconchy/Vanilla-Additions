package com.chrismin13.vanillaadditions.items.obsidian;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;
import org.bukkit.Color;
import org.bukkit.Material;

public class ObsidianArmor extends AverageLeatherArmor
{
  public ObsidianArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, paramArmorType.getDiamondMaterial().getMaxDurability() * 4 + 3, "vanilla_additions:obsidian_" + paramArmorType.toString().toLowerCase(), "Obsidian " + paramArmorType.toIngameString(), Color.fromRGB(24, 17, 37), Material.OBSIDIAN, 
      MaterialUtils.getBaseArmor(paramArmorType.getIronMaterial()), MaterialUtils.getBaseArmorToughness(paramArmorType.getIronMaterial()));
    addAttribute(Attributes.AttributeType.GENERIC_KNOCKBACK_RESISTANCE, 0.1D, Attributes.Operation.ADD_NUMBER);
  }
}
