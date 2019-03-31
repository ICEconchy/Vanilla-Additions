package com.chrismin13.vanillaadditions.items.chisels;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineItem;
import org.bukkit.Material;
import us.fihgu.toolbox.item.DamageableItem;

public class PrismarineChisel
  extends PrismarineItem implements ChiselAbilities
{
  public PrismarineChisel()
  {
    super(DamageableItem.DIAMOND_PICKAXE, "vanilla_additions:prismarine_chisel", "Prismarine Chisel", "prismarine_chisel");
    
    modifyCustomItem(this, Material.PRISMARINE_SHARD);
  }
}
