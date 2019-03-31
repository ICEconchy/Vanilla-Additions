package com.chrismin13.vanillaadditions.items.doubleaxes;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.slime.SlimeItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class SlimeDoubleAxe
  extends SlimeItem implements DoubleAxeAbilities
{
  public SlimeDoubleAxe()
  {
    super(DamageableItem.WOODEN_AXE, "vanilla_additions:slime_double_axe", "Slime Double Axe", "slime_double_axe");
    
    modifyCustomItem(this, Material.SLIME_BALL);
  }
}
