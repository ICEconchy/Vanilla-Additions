package com.chrismin13.vanillaadditions.items.prismarine;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import org.bukkit.Color;
import org.bukkit.Material;

public class PrismarineArmor extends AverageLeatherArmor
{
  public PrismarineArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, paramArmorType.getIronMaterial().getMaxDurability(), "vanilla_additions:prismarine_" + paramArmorType
      .toString().toLowerCase(), "Prismarine " + paramArmorType
      .toIngameString(), Color.fromRGB(116, 183, 179), Material.PRISMARINE_SHARD, 
      MaterialUtils.getBaseArmor(paramArmorType.getDiamondMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getDiamondMaterial()));
  }
}
