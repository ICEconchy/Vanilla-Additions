package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.events.item.CustomItemBlockIgniteEvent;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.utils.NumberUtils;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackArmor;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackItem;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackShovel;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;

public class NetherrackItemsListener implements Listener
{
  public NetherrackItemsListener() {}
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onRightClickBlock(PlayerInteractEvent paramPlayerInteractEvent)
  {
    if ((paramPlayerInteractEvent.isCancelled()) || (!paramPlayerInteractEvent.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
      return;
    }
    Block localBlock1 = paramPlayerInteractEvent.getClickedBlock();
    BlockFace localBlockFace = paramPlayerInteractEvent.getBlockFace();
    Block localBlock2 = paramPlayerInteractEvent.getClickedBlock().getRelative(localBlockFace);
    if ((localBlock2 == null) || (localBlock2.getType() == null) || (localBlock2.getType() != Material.AIR)) {
      return;
    }
    Player localPlayer = paramPlayerInteractEvent.getPlayer();
    ItemStack localItemStack = localPlayer.getInventory().getItemInMainHand();
    if (!AdditionsAPI.isCustomItem(localItemStack)) {
      return;
    }
    CustomItemStack localCustomItemStack = new CustomItemStack(localItemStack);
    com.chrismin13.additionsapi.items.CustomItem localCustomItem = localCustomItemStack.getCustomItem();
    if (!(localCustomItem instanceof NetherrackItem)) {
      return;
    }
    Material localMaterial = localBlock1.getType();
    Byte localByte = Byte.valueOf(localBlock1.getData());
    if ((localBlockFace == BlockFace.UP) || (localBlockFace == BlockFace.EAST) || (localBlockFace == BlockFace.NORTH) || (localBlockFace == BlockFace.SOUTH) || (localBlockFace == BlockFace.WEST))
    {
      if (((localCustomItem instanceof NetherrackShovel)) && (localMaterial == Material.GRASS))
        return;
      if ((localCustomItem instanceof com.chrismin13.vanillaadditions.items.netherrack.NetherrackHoe)) { if ((localMaterial != Material.GRASS) && (localMaterial != Material.GRASS_PATH)) { if (localMaterial == Material.DIRT)
          {
            if (localByte.byteValue() == 2) {} }
        } else { return;
        }
      }
    }
    BlockIgniteEvent localBlockIgniteEvent = new BlockIgniteEvent(localBlock1, BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL, localPlayer, localBlock2);
    CustomItemBlockIgniteEvent localCustomItemBlockIgniteEvent = new CustomItemBlockIgniteEvent(localBlockIgniteEvent, localCustomItemStack);
    Bukkit.getPluginManager().callEvent(localBlockIgniteEvent);
    Bukkit.getPluginManager().callEvent(localCustomItemBlockIgniteEvent);
    if ((!localBlockIgniteEvent.isCancelled()) && (!localCustomItemBlockIgniteEvent.isCancelled())) {
      localBlock2.setType(Material.FIRE);
      localBlock2.setData((byte)0);
      localPlayer.playSound(localBlock2.getLocation(), org.bukkit.Sound.ITEM_FLINTANDSTEEL_USE, 1.0F, 1.0F);
      localCustomItemStack.reduceDurability(localPlayer, 1);
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onEnemyHit(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    if (paramEntityDamageByEntityEvent.isCancelled()) {
      return;
    }
    if (!(paramEntityDamageByEntityEvent.getEntity() instanceof Player))
      return;
    Player localPlayer = (Player)paramEntityDamageByEntityEvent.getEntity();
    Entity localEntity = paramEntityDamageByEntityEvent.getDamager();
    
    for (ItemStack localItemStack : localPlayer.getInventory().getArmorContents()) {
      if (AdditionsAPI.isCustomItem(localItemStack)) {
        CustomItemStack localCustomItemStack = new CustomItemStack(localItemStack);
        
        if (((localCustomItemStack.getCustomItem() instanceof NetherrackArmor)) && (NumberUtils.calculateChance(0.05D))) {
          localEntity.setFireTicks(NumberUtils.randomInt(40, 120));
          break;
        }
      }
    }
  }
}
