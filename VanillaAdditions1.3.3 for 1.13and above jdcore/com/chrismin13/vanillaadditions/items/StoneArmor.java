package com.chrismin13.vanillaadditions.items;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.abilities.StoneArmorAbilities;
import org.bukkit.Color;
import org.bukkit.Material;

public class StoneArmor
  extends AverageLeatherArmor implements StoneArmorAbilities
{
  public StoneArmor(ArmorType paramArmorType)
  {
    super(paramArmorType, 0, "vanilla_additions:stone_" + paramArmorType
      .toString().toLowerCase(), "Stone " + paramArmorType.toIngameString(), 
      Color.fromRGB(103, 103, 103), Material.COBBLESTONE, 
      MaterialUtils.getBaseArmor(paramArmorType.getChainmailMaterial()), 
      MaterialUtils.getBaseArmorToughness(paramArmorType.getChainmailMaterial()));
    modifyCustomItem(this);
    setUnbreakable(Boolean.valueOf(false));
  }
}
