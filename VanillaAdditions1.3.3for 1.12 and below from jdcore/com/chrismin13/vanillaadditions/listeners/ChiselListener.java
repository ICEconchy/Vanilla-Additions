package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.additionsapi.events.item.CustomItemBlockBreakEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.utils.PermissionUtils;
import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.permissions.ChiselPermissions;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;

public class ChiselListener implements org.bukkit.event.Listener
{
  public ChiselListener() {}
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onBlockBreak(CustomItemBlockBreakEvent paramCustomItemBlockBreakEvent)
  {
    if (paramCustomItemBlockBreakEvent.isCancelled()) {
      return;
    }
    CustomItemStack localCustomItemStack = paramCustomItemBlockBreakEvent.getCustomItemStack();
    if (!(localCustomItemStack.getCustomItem() instanceof ChiselAbilities)) {
      return;
    }
    BlockBreakEvent localBlockBreakEvent = paramCustomItemBlockBreakEvent.getBlockBreakEvent();
    Block localBlock = localBlockBreakEvent.getBlock();
    CustomItem localCustomItem = localCustomItemStack.getCustomItem();
    ChiselAbilities localChiselAbilities = (ChiselAbilities)localCustomItem;
    if (!(localCustomItem.getPermissions() instanceof ChiselPermissions))
      return;
    ChiselPermissions localChiselPermissions = (ChiselPermissions)localCustomItem.getPermissions();
    Player localPlayer = localBlockBreakEvent.getPlayer();
    
    if (!PermissionUtils.allowedAction(localPlayer, localChiselPermissions.getType(), localChiselPermissions.getChisel())) {
      return;
    }
    localBlockBreakEvent.setCancelled(true);
    
    Material localMaterial = localBlock.getType();
    int i = localBlock.getData();
    localChiselAbilities.convertToChiseled(localBlock);
    
    if ((!localBlock.getType().equals(localMaterial)) || (i != localBlock.getData())) {
      localCustomItemStack.reduceDurability(localPlayer, 1);
    }
  }
}
