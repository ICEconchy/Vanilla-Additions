package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.vanillaadditions.items.SlimeBucket;
import com.chrismin13.vanillaadditions.utils.MobUtils;
import com.chrismin13.vanillaadditions.utils.SlimeChunkUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SlimeBucketListener implements org.bukkit.event.Listener
{
  public SlimeBucketListener() {}
  
  List<UUID> playersInSlimeChunks = new ArrayList();
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerMove(PlayerMoveEvent paramPlayerMoveEvent) {
    if ((paramPlayerMoveEvent.isCancelled()) || (paramPlayerMoveEvent.getFrom() == null) || (paramPlayerMoveEvent.getTo() == null)) {
      return;
    }
    Location localLocation1 = paramPlayerMoveEvent.getFrom();
    Location localLocation2 = paramPlayerMoveEvent.getTo();
    if ((localLocation1.getBlockX() == localLocation2.getBlockX()) && (localLocation1.getBlockZ() == localLocation2.getBlockZ())) {
      return;
    }
    Player localPlayer = paramPlayerMoveEvent.getPlayer();
    if (SlimeChunkUtils.isSlimeChunk(localPlayer.getLocation())) {
      changeToJumping(localPlayer);
    } else {
      changeToSimple(localPlayer);
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onItemDrop(PlayerDropItemEvent paramPlayerDropItemEvent) {
    if (paramPlayerDropItemEvent.isCancelled())
      return;
    Item localItem = paramPlayerDropItemEvent.getItemDrop();
    ItemStack localItemStack = localItem.getItemStack();
    if (!AdditionsAPI.isCustomItem(localItemStack))
      return;
    CustomItemStack localCustomItemStack = new CustomItemStack(localItemStack);
    if (!(localCustomItemStack.getCustomItem() instanceof SlimeBucket))
      return;
    localCustomItemStack.setTexture("slime_bucket");
    localItem.setItemStack(localCustomItemStack.getItemStack());
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onItemPickup(PlayerPickupItemEvent paramPlayerPickupItemEvent) {
    if (paramPlayerPickupItemEvent.isCancelled())
      return;
    Item localItem = paramPlayerPickupItemEvent.getItem();
    ItemStack localItemStack = localItem.getItemStack();
    if (!AdditionsAPI.isCustomItem(localItemStack))
      return;
    CustomItemStack localCustomItemStack = new CustomItemStack(localItemStack);
    if (!(localCustomItemStack.getCustomItem() instanceof SlimeBucket))
      return;
    Player localPlayer = paramPlayerPickupItemEvent.getPlayer();
    if (SlimeChunkUtils.isSlimeChunk(localPlayer.getLocation())) {
      changeToJumping(localPlayer);
      localCustomItemStack.setTexture("jumping_slime_bucket");
    } else {
      changeToSimple(localPlayer);
      localCustomItemStack.setTexture("slime_bucket");
    }
    localItem.setItemStack(localCustomItemStack.getItemStack());
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onSlimeBucketMove(InventoryMoveItemEvent paramInventoryMoveItemEvent) {
    if (paramInventoryMoveItemEvent.isCancelled())
      return;
    ItemStack localItemStack = paramInventoryMoveItemEvent.getItem();
    if (!AdditionsAPI.isCustomItem(localItemStack))
      return;
    CustomItemStack localCustomItemStack = new CustomItemStack(localItemStack);
    if (!(localCustomItemStack.getCustomItem() instanceof SlimeBucket))
      return;
    localCustomItemStack.setTexture("slime_bucket");
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onBucketSlimeClick(PlayerInteractEntityEvent paramPlayerInteractEntityEvent) {
    if (paramPlayerInteractEntityEvent.isCancelled())
      return;
    Entity localEntity = paramPlayerInteractEntityEvent.getRightClicked();
    Player localPlayer = paramPlayerInteractEntityEvent.getPlayer();
    PlayerInventory localPlayerInventory = localPlayer.getInventory();
    ItemStack localItemStack = null;
    UUID localUUID = localPlayer.getUniqueId();
    Object localObject; if (((localEntity instanceof Slime)) && ((localPlayerInventory.getItemInMainHand().getType().equals(Material.BUCKET)) || 
      (localPlayerInventory.getItemInOffHand().getType().equals(Material.BUCKET)))) {
      if (localEntity.isDead())
        return;
      localObject = (Slime)localEntity;
      if (((Slime)localObject).getSize() != 1)
        return;
      if (localPlayer.getGameMode() != GameMode.CREATIVE) { int i;
        if (localPlayerInventory.getItemInMainHand().getType().equals(Material.BUCKET)) {
          localItemStack = localPlayerInventory.getItemInMainHand();
          i = localItemStack.getAmount() - 1;
          localItemStack.setAmount(i);
          localPlayerInventory.setItemInMainHand(localItemStack);
        } else if (localPlayerInventory.getItemInOffHand().getType().equals(Material.BUCKET)) {
          localItemStack = localPlayerInventory.getItemInOffHand();
          i = localItemStack.getAmount() - 1;
          localItemStack.setAmount(i);
          localPlayerInventory.setItemInOffHand(localItemStack);
        }
      }
      if (SlimeChunkUtils.isSlimeChunk(localPlayer.getLocation())) {
        if (!playersInSlimeChunks.contains(localUUID))
          playersInSlimeChunks.add(localUUID);
        localPlayer.getInventory().addItem(new ItemStack[] {new CustomItemStack("vanilla_additions:slime_bucket")
          .setTexture("jumping_slime_bucket").getItemStack() });
      } else {
        if (playersInSlimeChunks.contains(localUUID))
          playersInSlimeChunks.remove(localUUID);
        localPlayer.getInventory().addItem(new ItemStack[] { new CustomItemStack("vanilla_additions:slime_bucket").getItemStack() });
      }
      paramPlayerInteractEntityEvent.getRightClicked().remove();
    } else if ((localEntity instanceof ItemFrame)) {
      localObject = (ItemFrame)localEntity;
      if (((ItemFrame)localObject).getItem().getType() != Material.AIR)
        return;
      CustomItemStack localCustomItemStack = null;
      if (AdditionsAPI.isCustomItem(localPlayerInventory.getItemInMainHand())) {
        localCustomItemStack = new CustomItemStack(localPlayerInventory.getItemInMainHand());
        if ((localCustomItemStack.getCustomItem() instanceof SlimeBucket))
          localCustomItemStack.setTexture("slime_bucket");
      } else if (AdditionsAPI.isCustomItem(localPlayerInventory.getItemInOffHand())) {
        localCustomItemStack = new CustomItemStack(localPlayerInventory.getItemInOffHand());
        if ((localCustomItemStack.getCustomItem() instanceof SlimeBucket))
          localCustomItemStack.setTexture("slime_bucket");
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onInventoryChange(InventoryClickEvent paramInventoryClickEvent) {
    if ((paramInventoryClickEvent.getView().getTopInventory() == null) || (paramInventoryClickEvent.isCancelled()))
      return;
    Inventory localInventory = paramInventoryClickEvent.getInventory();
    ItemStack localItemStack = paramInventoryClickEvent.getCurrentItem();
    CustomItemStack localCustomItemStack; if ((localInventory.getHolder() != null) && (localInventory.getHolder().toString().contains("CraftPlayer"))) {
      if (AdditionsAPI.isCustomItem(localItemStack)) {
        localCustomItemStack = new CustomItemStack(localItemStack);
        if ((localCustomItemStack.getCustomItem() instanceof SlimeBucket)) {
          if (SlimeChunkUtils.isSlimeChunk(paramInventoryClickEvent.getWhoClicked().getLocation())) {
            localCustomItemStack.setTexture("jumping_slime_bucket");
          } else {
            localCustomItemStack.setTexture("slime_bucket");
          }
        }
      }
    } else if (AdditionsAPI.isCustomItem(localItemStack)) {
      localCustomItemStack = new CustomItemStack(localItemStack);
      if ((localCustomItemStack.getCustomItem() instanceof SlimeBucket)) {
        localCustomItemStack.setTexture("slime_bucket");
        playersInSlimeChunks.remove(paramInventoryClickEvent.getWhoClicked().getUniqueId());
      }
    }
  }
  
  static List<Material> interactables = Arrays.asList(new Material[] { Material.ACACIA_DOOR, Material.ACACIA_FENCE_GATE, Material.ANVIL, Material.BEACON, Material.BED, Material.BIRCH_DOOR, Material.BIRCH_FENCE_GATE, Material.BOAT, Material.BOAT_ACACIA, Material.BOAT_BIRCH, Material.BOAT_DARK_OAK, Material.BOAT_JUNGLE, Material.BOAT_SPRUCE, Material.BREWING_STAND, Material.COMMAND, Material.CHEST, Material.DARK_OAK_DOOR, Material.DARK_OAK_FENCE_GATE, Material.DAYLIGHT_DETECTOR, Material.DAYLIGHT_DETECTOR_INVERTED, Material.DISPENSER, Material.DROPPER, Material.ENCHANTMENT_TABLE, Material.ENDER_CHEST, Material.FENCE_GATE, Material.FURNACE, Material.HOPPER, Material.HOPPER_MINECART, Material.ITEM_FRAME, Material.JUNGLE_DOOR, Material.JUNGLE_FENCE_GATE, Material.LEVER, Material.MINECART, Material.NOTE_BLOCK, Material.POWERED_MINECART, Material.REDSTONE_COMPARATOR, Material.REDSTONE_COMPARATOR_OFF, Material.REDSTONE_COMPARATOR_ON, Material.SIGN, Material.SIGN_POST, Material.STORAGE_MINECART, Material.TRAP_DOOR, Material.TRAPPED_CHEST, Material.WALL_SIGN, Material.WOOD_BUTTON, Material.WOOD_DOOR, Material.WORKBENCH });
  










  @EventHandler
  public void onSlimeBucketBlockClick(PlayerInteractEvent paramPlayerInteractEvent)
  {
    if (paramPlayerInteractEvent.isCancelled())
      return;
    Player localPlayer = paramPlayerInteractEvent.getPlayer();
    PlayerInventory localPlayerInventory = localPlayer.getInventory();
    CustomItemStack localCustomItemStack = null;
    if (AdditionsAPI.isCustomItem(localPlayerInventory.getItemInMainHand())) {
      localCustomItemStack = new CustomItemStack(localPlayerInventory.getItemInMainHand());
    } else if (AdditionsAPI.isCustomItem(localPlayerInventory.getItemInOffHand())) {
      localCustomItemStack = new CustomItemStack(localPlayerInventory.getItemInOffHand());
    } else {
      return;
    }
    if (!(localCustomItemStack.getCustomItem() instanceof SlimeBucket)) {
      return;
    }
    if ((paramPlayerInteractEvent.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) && (
      (!interactables.contains(paramPlayerInteractEvent.getClickedBlock().getType())) || (localPlayer.isSneaking()))) {
      if (paramPlayerInteractEvent.getClickedBlock() == null)
        return;
      if ((MobUtils.spawnSlime(paramPlayerInteractEvent.getClickedBlock(), paramPlayerInteractEvent.getBlockFace())) && 
        (!localPlayer.getGameMode().equals(GameMode.CREATIVE))) {
        localCustomItemStack.getItemStack().setAmount(0);
        localPlayerInventory.addItem(new ItemStack[] { new ItemStack(Material.BUCKET) });
      }
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onTeleportWithSlimeBucket(PlayerTeleportEvent paramPlayerTeleportEvent) {
    Player localPlayer = paramPlayerTeleportEvent.getPlayer();
    if (SlimeChunkUtils.isSlimeChunk(localPlayer.getLocation())) {
      changeToJumping(localPlayer);
    } else {
      changeToSimple(localPlayer);
    }
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onItemCraft(CraftItemEvent paramCraftItemEvent) {
    if ((paramCraftItemEvent.isCancelled()) || (!AdditionsAPI.isCustomItem(paramCraftItemEvent.getCurrentItem())))
      return;
    CustomItemStack localCustomItemStack = new CustomItemStack(paramCraftItemEvent.getCurrentItem());
    if (!(localCustomItemStack.getCustomItem() instanceof SlimeBucket))
      return;
    if (SlimeChunkUtils.isSlimeChunk(paramCraftItemEvent.getWhoClicked().getLocation())) {
      localCustomItemStack.setTexture("jumping_slime_bucket");
    } else
      localCustomItemStack.setTexture("slime_bucket");
  }
  
  public void changeToJumping(Player paramPlayer) {
    if (!playersInSlimeChunks.contains(paramPlayer.getUniqueId()))
      playersInSlimeChunks.add(paramPlayer.getUniqueId());
    PlayerInventory localPlayerInventory = paramPlayer.getInventory();
    for (ItemStack localItemStack : localPlayerInventory.getContents()) {
      if (AdditionsAPI.isCustomItem(localItemStack)) {
        CustomItemStack localCustomItemStack = new CustomItemStack(localItemStack);
        if (((localCustomItemStack.getCustomItem() instanceof SlimeBucket)) && (!localCustomItemStack.getTexture().equals("jumping_slime_bucket")))
          localCustomItemStack.setTexture("jumping_slime_bucket");
      }
    }
  }
  
  public void changeToSimple(Player paramPlayer) {
    if (playersInSlimeChunks.contains(paramPlayer.getUniqueId())) {
      playersInSlimeChunks.remove(paramPlayer.getUniqueId());
    }
    PlayerInventory localPlayerInventory = paramPlayer.getInventory();
    for (ItemStack localItemStack : localPlayerInventory.getContents()) {
      if (AdditionsAPI.isCustomItem(localItemStack)) {
        CustomItemStack localCustomItemStack = new CustomItemStack(localItemStack);
        if (((localCustomItemStack.getCustomItem() instanceof SlimeBucket)) && (!localCustomItemStack.getTexture().equals("slime_bucket"))) {
          localCustomItemStack.setTexture("slime_bucket");
        }
      }
    }
  }
}
