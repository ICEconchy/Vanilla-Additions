package com.chrismin13.vanillaadditions.items;

import com.chrismin13.additionsapi.items.textured.CustomTexturedItem;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import us.fihgu.toolbox.item.DamageableItem;

public class SlimeBucket
  extends CustomTexturedItem
{
  public SlimeBucket()
  {
    super(DamageableItem.DIAMOND_HOE, "vanilla_additions:slime_bucket", "slime_bucket");
    
    addTexture("jumping_slime_bucket");
    
    setUnbreakable(Boolean.valueOf(true));
    setDisplayName("Slime Bucket");
    setHoeAbilities(false);
    addAttribute(Attributes.AttributeType.GENERIC_ATTACK_DAMAGE, 1.0D, EquipmentSlot.HAND, Attributes.Operation.ADD_NUMBER);
    setAttributeVisibility(false);
    setUnbreakableVisibility(false);
    

    CustomShapedRecipe localCustomShapedRecipe = new CustomShapedRecipe().setIngredient('1', Material.SLIME_BALL).setIngredient('2', Material.BUCKET);
    addCustomRecipe(new CustomShapedRecipe(localCustomShapedRecipe).setShape("111", "111", "020"));
  }
}
