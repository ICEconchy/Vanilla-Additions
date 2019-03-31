package com.chrismin13.vanillaadditions.items.wood;

import com.chrismin13.additionsapi.enums.ToolType;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedItem
  extends AverageTexturedTool
{
  public WoodBasedItem(DamageableItem paramDamageableItem, byte paramByte, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramDamageableItem, 59, "vanilla_additions:" + paramString1 + "_" + paramString4, paramString3, paramString2);
  }
  
  public WoodBasedItem(DamageableItem paramDamageableItem, byte paramByte, String paramString1, String paramString2, String paramString3)
  {
    super(paramDamageableItem, 59, "vanilla_additions:" + paramString1 + "_" + paramDamageableItem.toString().toLowerCase(), paramString3, paramString2);
    

    addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.WOOD, paramByte), new RecipeIngredient(Material.STICK)));
  }
}
