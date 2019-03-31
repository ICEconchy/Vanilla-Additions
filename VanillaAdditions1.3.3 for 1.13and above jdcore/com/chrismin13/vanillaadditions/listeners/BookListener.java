package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.vanillaadditions.utils.BookUtils;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class BookListener implements org.bukkit.event.Listener
{
  public BookListener() {}
  
  @org.bukkit.event.EventHandler(priority=EventPriority.HIGHEST)
  public void onItemFrameInteract(PlayerInteractEntityEvent paramPlayerInteractEntityEvent)
  {
    List localList = com.chrismin13.vanillaadditions.Items.config.getStringList("enabled-mechanics");
    if ((paramPlayerInteractEntityEvent.isCancelled()) || (paramPlayerInteractEntityEvent.getPlayer().isSneaking()) || (!localList.contains("OPEN_BOOK_IN_ITEM_FRAME"))) {
      return;
    }
    if (!paramPlayerInteractEntityEvent.getRightClicked().getType().equals(EntityType.ITEM_FRAME)) {
      return;
    }
    ItemFrame localItemFrame = (ItemFrame)paramPlayerInteractEntityEvent.getRightClicked();
    ItemStack localItemStack = localItemFrame.getItem();
    
    if ((localItemStack == null) || (!localItemStack.getType().equals(Material.WRITTEN_BOOK))) {
      return;
    }
    BookUtils.openBook(localItemStack, paramPlayerInteractEntityEvent.getPlayer());
    paramPlayerInteractEntityEvent.setCancelled(true);
  }
}
