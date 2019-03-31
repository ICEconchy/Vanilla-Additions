package com.chrismin13.vanillaadditions.items.hammers;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedHammer
  extends WoodBasedItem implements HammerAbilities
{
  public WoodBasedHammer(byte paramByte, String paramString1, String paramString2, String paramString3)
  {
    super(DamageableItem.WOODEN_PICKAXE, paramByte, paramString1, paramString2, paramString3, "wooden_hammer");
    
    modifyCustomItem(this, new RecipeIngredient(Material.WOOD, paramByte));
  }
}
