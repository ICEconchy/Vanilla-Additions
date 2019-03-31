package com.chrismin13.vanillaadditions.items.slime;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;
import org.bukkit.Color;
import org.bukkit.Material;

public class SlimeArmor extends AverageLeatherArmor
{
  public SlimeArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, paramArmorType.getGoldMaterial().getMaxDurability(), "vanilla_additions:slime_" + paramArmorType
      .toString().toLowerCase(), "Slime " + paramArmorType.toIngameString(), 
      Color.fromRGB(125, 200, 115), Material.SLIME_BALL, 
      MaterialUtils.getBaseArmor(paramArmorType.getLeatherMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getLeatherMaterial()));
    addAttribute(Attributes.AttributeType.GENERIC_KNOCKBACK_RESISTANCE, -0.1D, Attributes.Operation.ADD_NUMBER);
  }
}
