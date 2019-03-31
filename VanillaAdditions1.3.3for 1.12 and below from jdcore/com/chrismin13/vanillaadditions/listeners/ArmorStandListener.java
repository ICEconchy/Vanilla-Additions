package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.vanillaadditions.Items;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ArmorStandListener implements org.bukkit.event.Listener
{
  public ArmorStandListener() {}
  
  @EventHandler
  public void onArmorStandPlace(CreatureSpawnEvent paramCreatureSpawnEvent)
  {
    if ((Items.config == null) || (Items.config.getStringList("enabled-mechanics") == null))
      return;
    List localList = Items.config.getStringList("enabled-mechanics");
    if ((paramCreatureSpawnEvent.isCancelled()) || (paramCreatureSpawnEvent.getEntityType() == null) || 
      (!paramCreatureSpawnEvent.getEntityType().equals(EntityType.ARMOR_STAND)) || (localList == null) || 
      (localList.isEmpty()) || 
      (!localList.contains("ARMOR_STANDS_WITH_ARMS"))) {
      return;
    }
    ArmorStand localArmorStand = (ArmorStand)paramCreatureSpawnEvent.getEntity();
    if (!localArmorStand.hasArms())
      localArmorStand.setArms(true);
  }
  
  @EventHandler(priority=org.bukkit.event.EventPriority.MONITOR)
  public void onArmorStandItemAdd(PlayerInteractAtEntityEvent paramPlayerInteractAtEntityEvent) {
    List localList = Items.config.getStringList("enabled-mechanics");
    if ((paramPlayerInteractAtEntityEvent.isCancelled()) || (!localList.contains("ARMOR_STAND_ITEM_IN_OFF_HAND")) || 
      (!paramPlayerInteractAtEntityEvent.getRightClicked().getType().equals(EntityType.ARMOR_STAND)) || (paramPlayerInteractAtEntityEvent.getHand() == null) || 
      (!paramPlayerInteractAtEntityEvent.getHand().equals(EquipmentSlot.HAND))) {
      return;
    }
    ArmorStand localArmorStand = (ArmorStand)paramPlayerInteractAtEntityEvent.getRightClicked();
    
    if (!localArmorStand.hasArms()) {
      return;
    }
    EntityEquipment localEntityEquipment = localArmorStand.getEquipment();
    ItemStack localItemStack1 = localEntityEquipment.getItemInOffHand();
    
    org.bukkit.entity.Player localPlayer = paramPlayerInteractAtEntityEvent.getPlayer();
    PlayerInventory localPlayerInventory = localPlayer.getInventory();
    ItemStack localItemStack2 = localPlayerInventory.getItemInOffHand();
    ItemStack localItemStack3;
    if ((localItemStack1.getType().equals(Material.AIR)) && (localItemStack2 != null) && (!localItemStack2.getType().equals(Material.AIR)))
    {
      if (localItemStack2.getAmount() == 1) {
        localEntityEquipment.setItemInOffHand(localItemStack2);
        localPlayerInventory.setItemInOffHand(null);
      } else if (localItemStack2.getAmount() > 1) {
        localItemStack3 = localItemStack2.clone();
        
        localItemStack2.setAmount(localItemStack2.getAmount() - 1);
        localItemStack3.setAmount(1);
        
        localEntityEquipment.setItemInOffHand(localItemStack3);
      }
    } else if ((!localItemStack1.getType().equals(Material.AIR)) && (localItemStack2.getType().equals(Material.AIR))) {
      localPlayerInventory.setItemInOffHand(localItemStack1);
      localEntityEquipment.setItemInOffHand(null);
    } else if ((!localItemStack1.getType().equals(Material.AIR)) && (!localItemStack2.getType().equals(Material.AIR)) && 
      (localItemStack2.getAmount() == 1)) {
      localItemStack3 = localItemStack2.clone();
      
      localPlayerInventory.setItemInOffHand(localItemStack1);
      localEntityEquipment.setItemInOffHand(localItemStack3);
    }
  }
}
