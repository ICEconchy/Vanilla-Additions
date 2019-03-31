package com.chrismin13.vanillaadditions.items.chisels;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.lapis.LapisItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class LapisChisel
  extends LapisItem implements ChiselAbilities
{
  public LapisChisel()
  {
    super(DamageableItem.IRON_PICKAXE, "vanilla_additions:lapis_chisel", "Lapis Chisel", "lapis_chisel");
    modifyCustomItem(this, new RecipeIngredient(Material.LAPIS_LAZULI));
  }
}
