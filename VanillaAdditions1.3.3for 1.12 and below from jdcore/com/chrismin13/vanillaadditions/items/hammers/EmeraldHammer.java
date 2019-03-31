package com.chrismin13.vanillaadditions.items.hammers;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldHammer
  extends EmeraldItem implements HammerAbilities
{
  public EmeraldHammer()
  {
    super(DamageableItem.DIAMOND_PICKAXE, "vanilla_additions:emerald_hammer", "Emerald Hammer", "emerald_hammer");
    
    modifyCustomItem(this, Material.EMERALD);
  }
}
