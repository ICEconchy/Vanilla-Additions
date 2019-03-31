package com.chrismin13.vanillaadditions.items.endstone;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.abilities.StoneArmorAbilities;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import org.bukkit.Color;
import org.bukkit.Material;

public class EndStoneArmor extends AverageLeatherArmor implements StoneArmorAbilities
{
  public EndStoneArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, paramArmorType.getIronMaterial().getMaxDurability(), "vanilla_additions:end_stone_" + paramArmorType
      .toString().toLowerCase(), "End Stone " + paramArmorType
      .toIngameString(), Color.fromRGB(237, 237, 154), Material.END_STONE, 
      MaterialUtils.getBaseArmor(paramArmorType.getChainmailMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getChainmailMaterial()));
    modifyCustomItem(this);
  }
}
