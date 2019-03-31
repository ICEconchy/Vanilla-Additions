package com.chrismin13.vanillaadditions.items.redstone;

import com.chrismin13.additionsapi.enums.ToolType;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneShovel extends RedstoneItem
{
  public final String A = "57082REMOVE";
  public final String B = "656308121REMOVE";
  
  public RedstoneShovel() {
    super(DamageableItem.STONE_SHOVEL, "vanilla_additions:redstone_shovel", "Redstone Shovel", "redstone_shovel");
    
    addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.REDSTONE, Material.STICK));
  }
}
