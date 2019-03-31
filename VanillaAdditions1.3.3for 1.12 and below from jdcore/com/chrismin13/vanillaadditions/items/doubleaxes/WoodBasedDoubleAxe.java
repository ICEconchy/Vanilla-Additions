package com.chrismin13.vanillaadditions.items.doubleaxes;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedDoubleAxe
  extends WoodBasedItem implements DoubleAxeAbilities
{
  public WoodBasedDoubleAxe(byte paramByte, String paramString1, String paramString2, String paramString3)
  {
    super(DamageableItem.WOODEN_AXE, paramByte, paramString1, paramString2, paramString3, "wooden_double_axe");
    
    modifyCustomItem(this, new RecipeIngredient(Material.WOOD, paramByte));
  }
}
