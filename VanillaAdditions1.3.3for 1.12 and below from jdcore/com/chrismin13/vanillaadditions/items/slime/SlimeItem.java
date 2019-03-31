package com.chrismin13.vanillaadditions.items.slime;

import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import us.fihgu.toolbox.item.DamageableItem;


public class SlimeItem
  extends AverageTexturedTool
{
  public SlimeItem(DamageableItem paramDamageableItem, String paramString1, String paramString2, String paramString3)
  {
    super(paramDamageableItem, Material.WOOD_SWORD.getMaxDurability(), paramString1, paramString2, paramString3);
    addAttackSpeed(MaterialUtils.getBaseSpeed(getMaterial()));
    addAttackDamage(MaterialUtils.getBaseDamage(getMaterial()));
    addAttribute(Attributes.AttributeType.GENERIC_KNOCKBACK_RESISTANCE, -0.1D, EquipmentSlot.HAND, Attributes.Operation.ADD_NUMBER);
  }
}
