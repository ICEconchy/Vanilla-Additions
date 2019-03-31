package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.utils.NumberUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CoalItemsListener implements org.bukkit.event.Listener
{
  public CoalItemsListener() {}
  
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent paramPlayerMoveEvent)
  {
    if (paramPlayerMoveEvent.isCancelled())
      return;
    Player localPlayer = paramPlayerMoveEvent.getPlayer();
    PlayerInventory localPlayerInventory = localPlayer.getInventory();
    
    if (!localPlayer.hasPotionEffect(PotionEffectType.BLINDNESS)) {
      for (org.bukkit.inventory.ItemStack localItemStack : localPlayerInventory.getArmorContents()) {
        if ((AdditionsAPI.isCustomItem(localItemStack)) && 
          (AdditionsAPI.getIdName(localItemStack).contains("vanilla_additions:coal_")) && 
          (NumberUtils.calculateChance(0.005D))) {
          localPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0), false);
          return;
        }
      }
    }
  }
}
