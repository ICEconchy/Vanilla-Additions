package com.chrismin13.vanillaadditions.items.chisels;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedChisel
  extends WoodBasedItem implements ChiselAbilities
{
  public WoodBasedChisel(Material paramMaterial, String paramString1, String paramString2, String paramString3)
  {
    super(DamageableItem.WOODEN_PICKAXE, paramString1, paramString2, paramString3, "wooden_chisel");
    
    modifyCustomItem(this, new RecipeIngredient(paramMaterial));
  }
}
