package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.vanillaadditions.utils.MaterialUtils;
import org.bukkit.Material;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.material.MaterialData;

public class CraftingRemover implements org.bukkit.event.Listener
{
  public CraftingRemover() {}
  
  @org.bukkit.event.EventHandler(priority=EventPriority.LOWEST)
  public void onPrepareCrafting(PrepareItemCraftEvent paramPrepareItemCraftEvent)
  {
    Recipe localRecipe = paramPrepareItemCraftEvent.getRecipe();
    if ((localRecipe == null) || (localRecipe.getResult() == null))
      return;
    Material localMaterial = localRecipe.getResult().getType();
    CraftingInventory localCraftingInventory = paramPrepareItemCraftEvent.getInventory();
    ItemStack[] arrayOfItemStack = localCraftingInventory.getContents();
    if (((localMaterial.equals(Material.WOOD_SWORD)) || (localMaterial.equals(Material.WOOD_AXE)) || 
      (localMaterial.equals(Material.WOOD_PICKAXE)) || (localMaterial.equals(Material.WOOD_SPADE)) || 
      (localMaterial.equals(Material.WOOD_HOE))) && (!AdditionsAPI.isCustomItem(localCraftingInventory.getResult()))) {
      Byte localByte = null;
      for (int i = 0; i < arrayOfItemStack.length - 1; i++) {
        if ((arrayOfItemStack[i] != null) && (arrayOfItemStack[i].getType().equals(Material.WOOD))) {
          if (localByte == null) {
            localByte = Byte.valueOf(arrayOfItemStack[i].getData().getData());
          } else if (!localByte.equals(Byte.valueOf(arrayOfItemStack[i].getData().getData()))) {
            localCraftingInventory.setResult(new ItemStack(Material.AIR));
            return;
          }
        }
      }
      if (localByte == null) {
        return;
      }
      
      String str = "vanilla_additions:" + MaterialUtils.getWoodType(localByte.byteValue()) + "_" + localMaterial.toString().toLowerCase().replace("wood", "wooden").replace("spade", "shovel");
      localCraftingInventory.setResult(new CustomItemStack(str).getItemStack());
    }
  }
}
