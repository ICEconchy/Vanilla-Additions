package com.chrismin13.vanillaadditions.items;

import com.chrismin13.additionsapi.enums.ToolType;
import com.chrismin13.additionsapi.items.textured.CustomTexturedTool;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class AverageTexturedTool
  extends CustomTexturedTool
{
  public AverageTexturedTool(DamageableItem paramDamageableItem, int paramInt, Material paramMaterial1, Material paramMaterial2, String paramString1, String paramString2, String paramString3)
  {
    this(paramDamageableItem, paramInt, paramString1, paramString2, paramString3);
    
    addAllCustomRecipes(getToolType().getCustomShapedRecipe(paramMaterial1, paramMaterial2));
  }
  

  public AverageTexturedTool(DamageableItem paramDamageableItem, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    super(paramDamageableItem, paramString1, paramString3);
    

    setDisplayName(paramString2);
    setUnbreakable(Boolean.valueOf(true));
    setFakeDurability(paramInt);
    setEnchantable(true);
    setToolLikeAttributes(Boolean.valueOf(true));
    setUnbreakableVisibility(false);
    setAttributeVisibility(false);
    setCombinedInCrafting(true);
  }
}
