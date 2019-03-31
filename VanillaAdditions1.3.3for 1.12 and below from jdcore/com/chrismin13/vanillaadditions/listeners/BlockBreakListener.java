package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.additionsapi.events.item.CustomItemBlockBreakEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.utils.BlockUtils;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockBreakListener
  implements Listener
{
  public BlockBreakListener() {}
  
  HashMap<UUID, BlockFace> lastBlockFace = new HashMap();
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onCustomItemBlockBreak(CustomItemBlockBreakEvent paramCustomItemBlockBreakEvent) {
    if (paramCustomItemBlockBreakEvent.isCancelled())
      return;
    CustomItem localCustomItem = paramCustomItemBlockBreakEvent.getCustomItem();
    CustomItemStack localCustomItemStack = paramCustomItemBlockBreakEvent.getCustomItemStack();
    BlockBreakEvent localBlockBreakEvent = paramCustomItemBlockBreakEvent.getBlockBreakEvent();
    Player localPlayer = localBlockBreakEvent.getPlayer();
    Block localBlock = localBlockBreakEvent.getBlock();
    UUID localUUID = localPlayer.getUniqueId();
    if (BlockUtils.isBlockIgnored(localBlock))
      return;
    if (((localCustomItem instanceof DoubleAxeAbilities)) && (
      (localBlock.getType().equals(Material.LOG)) || (localBlock.getType().equals(Material.LOG_2)))) {
      ((DoubleAxeAbilities)localCustomItem).chopTree(localPlayer, localBlock, localCustomItemStack);
    } else if ((localCustomItem instanceof SickleAbilities)) {
      ((SickleAbilities)localCustomItem).onUse(localBlockBreakEvent, localCustomItemStack, localBlock, localPlayer);
    } else if (((localCustomItem instanceof HammerAbilities)) && (lastBlockFace.get(localUUID) != null)) {
      ((HammerAbilities)localCustomItem).onUse(localBlock, (BlockFace)lastBlockFace.get(localUUID), localCustomItemStack, localPlayer);
    }
  }
  
  @EventHandler(priority=EventPriority.MONITOR)
  public void onInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    if (paramPlayerInteractEvent.isCancelled()) {
      return;
    }
    Action localAction = paramPlayerInteractEvent.getAction();
    Player localPlayer = paramPlayerInteractEvent.getPlayer();
    if (localAction.equals(Action.LEFT_CLICK_BLOCK)) {
      lastBlockFace.put(localPlayer.getUniqueId(), paramPlayerInteractEvent.getBlockFace());
    }
  }
}
