package com.chrismin13.vanillaadditions.abilities;

import com.chrismin13.additionsapi.items.CustomArmor;
import com.comphenix.attribute.Attributes.Operation;

public abstract interface StoneArmorAbilities
{
  public void modifyCustomItem(CustomArmor cArmor)
  {
    cArmor.addAttribute(com.comphenix.attribute.Attributes.AttributeType.GENERIC_MOVEMENT_SPEED, -0.07999999821186066D, Attributes.Operation.ADD_PERCENTAGE);
  }
}
