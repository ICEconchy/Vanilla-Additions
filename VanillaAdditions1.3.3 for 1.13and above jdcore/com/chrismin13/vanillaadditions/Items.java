package com.chrismin13.vanillaadditions;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.events.AdditionsAPIInitializationEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import com.chrismin13.vanillaadditions.items.EnderBow;
import com.chrismin13.vanillaadditions.items.SlimeBucket;
import com.chrismin13.vanillaadditions.items.StoneArmor;
import com.chrismin13.vanillaadditions.items.chisels.ClayChisel;
import com.chrismin13.vanillaadditions.items.chisels.CoalChisel;
import com.chrismin13.vanillaadditions.items.chisels.DiamondChisel;
import com.chrismin13.vanillaadditions.items.chisels.EndStoneChisel;
import com.chrismin13.vanillaadditions.items.chisels.GoldChisel;
import com.chrismin13.vanillaadditions.items.chisels.IronChisel;
import com.chrismin13.vanillaadditions.items.chisels.LapisChisel;
import com.chrismin13.vanillaadditions.items.chisels.ObsidianChisel;
import com.chrismin13.vanillaadditions.items.chisels.PrismarineChisel;
import com.chrismin13.vanillaadditions.items.chisels.RedstoneChisel;
import com.chrismin13.vanillaadditions.items.chisels.SlimeChisel;
import com.chrismin13.vanillaadditions.items.chisels.StoneChisel;
import com.chrismin13.vanillaadditions.items.chisels.WoodBasedChisel;
import com.chrismin13.vanillaadditions.items.clay.ClayArmor;
import com.chrismin13.vanillaadditions.items.clay.ClayAxe;
import com.chrismin13.vanillaadditions.items.clay.ClayHoe;
import com.chrismin13.vanillaadditions.items.clay.ClayPickaxe;
import com.chrismin13.vanillaadditions.items.clay.ClayShovel;
import com.chrismin13.vanillaadditions.items.clay.ClaySword;
import com.chrismin13.vanillaadditions.items.coal.CoalArmor;
import com.chrismin13.vanillaadditions.items.coal.CoalAxe;
import com.chrismin13.vanillaadditions.items.coal.CoalHoe;
import com.chrismin13.vanillaadditions.items.coal.CoalPickaxe;
import com.chrismin13.vanillaadditions.items.coal.CoalShovel;
import com.chrismin13.vanillaadditions.items.coal.CoalSword;
import com.chrismin13.vanillaadditions.items.doubleaxes.ClayDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.CoalDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.DiamondDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.EmeraldDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.EndStoneDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.GoldDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.IronDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.LapisDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.NetherrackDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.ObsidianDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.PrismarineDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.RedstoneDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.SlimeDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.StoneDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.WoodBasedDoubleAxe;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldArmor;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldAxe;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldHoe;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldPickaxe;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldShovel;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldSword;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneArmor;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneAxe;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneHoe;
import com.chrismin13.vanillaadditions.items.endstone.EndStonePickaxe;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneShovel;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneSword;
import com.chrismin13.vanillaadditions.items.hammers.ClayHammer;
import com.chrismin13.vanillaadditions.items.hammers.CoalHammer;
import com.chrismin13.vanillaadditions.items.hammers.DiamondHammer;
import com.chrismin13.vanillaadditions.items.hammers.EmeraldHammer;
import com.chrismin13.vanillaadditions.items.hammers.EndStoneHammer;
import com.chrismin13.vanillaadditions.items.hammers.GoldHammer;
import com.chrismin13.vanillaadditions.items.hammers.IronHammer;
import com.chrismin13.vanillaadditions.items.hammers.NetherrackHammer;
import com.chrismin13.vanillaadditions.items.hammers.ObsidianHammer;
import com.chrismin13.vanillaadditions.items.hammers.PrismarineHammer;
import com.chrismin13.vanillaadditions.items.hammers.RedstoneHammer;
import com.chrismin13.vanillaadditions.items.hammers.SlimeHammer;
import com.chrismin13.vanillaadditions.items.hammers.StoneHammer;
import com.chrismin13.vanillaadditions.items.hammers.WoodBasedHammer;
import com.chrismin13.vanillaadditions.items.lapis.LapisArmor;
import com.chrismin13.vanillaadditions.items.lapis.LapisAxe;
import com.chrismin13.vanillaadditions.items.lapis.LapisHoe;
import com.chrismin13.vanillaadditions.items.lapis.LapisPickaxe;
import com.chrismin13.vanillaadditions.items.lapis.LapisShovel;
import com.chrismin13.vanillaadditions.items.lapis.LapisSword;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackArmor;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackAxe;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackHoe;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackPickaxe;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackShovel;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackSword;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianArmor;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianAxe;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianHoe;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianPickaxe;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianShovel;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianSword;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineArmor;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineAxe;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineHoe;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarinePickaxe;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineShovel;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineSword;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneArmor;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneAxe;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneHoe;
import com.chrismin13.vanillaadditions.items.redstone.RedstonePickaxe;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneShovel;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneSword;
import com.chrismin13.vanillaadditions.items.sickles.ClaySickle;
import com.chrismin13.vanillaadditions.items.sickles.CoalSickle;
import com.chrismin13.vanillaadditions.items.sickles.DiamondSickle;
import com.chrismin13.vanillaadditions.items.sickles.EmeraldSickle;
import com.chrismin13.vanillaadditions.items.sickles.EndStoneSickle;
import com.chrismin13.vanillaadditions.items.sickles.GoldSickle;
import com.chrismin13.vanillaadditions.items.sickles.IronSickle;
import com.chrismin13.vanillaadditions.items.sickles.LapisSickle;
import com.chrismin13.vanillaadditions.items.sickles.NetherrackSickle;
import com.chrismin13.vanillaadditions.items.sickles.ObsidianSickle;
import com.chrismin13.vanillaadditions.items.sickles.PrismarineSickle;
import com.chrismin13.vanillaadditions.items.sickles.RedstoneSickle;
import com.chrismin13.vanillaadditions.items.sickles.SlimeSickle;
import com.chrismin13.vanillaadditions.items.sickles.StoneSickle;
import com.chrismin13.vanillaadditions.items.sickles.WoodBasedSickle;
import com.chrismin13.vanillaadditions.items.slime.SlimeArmor;
import com.chrismin13.vanillaadditions.items.slime.SlimeAxe;
import com.chrismin13.vanillaadditions.items.slime.SlimeHoe;
import com.chrismin13.vanillaadditions.items.slime.SlimePickaxe;
import com.chrismin13.vanillaadditions.items.slime.SlimeShovel;
import com.chrismin13.vanillaadditions.items.slime.SlimeSword;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.text.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import us.fihgu.toolbox.item.DamageableItem;

public class Items implements Listener
{
  public static FileConfiguration config;
  
  public Items() {}
  
  @EventHandler
  public void onInitialization(AdditionsAPIInitializationEvent paramAdditionsAPIInitializationEvent)
  {
    paramAdditionsAPIInitializationEvent.addResourcePackFromPlugin(VanillaAdditions.getInstance(), "VanillaAdditions-1.2.zip");
    

    List localList = Arrays.asList(new Material[] { Material.WOODEN_SWORD, Material.WOODEN_AXE, Material.WOODEN_PICKAXE, Material.WOODEN_SHOVEL, Material.WOODEN_HOE });
    
    Iterator localIterator1 = Bukkit.recipeIterator();
    Object localObject2; while (localIterator1.hasNext()) {
      localObject1 = (Recipe)localIterator1.next();
      if ((localObject1 instanceof ShapedRecipe)) {
        localObject2 = (ShapedRecipe)localObject1;
        if ((localList.contains(((ShapedRecipe)localObject2).getResult().getType())) && 
          (((ShapedRecipe)localObject2).getKey().getNamespace().equals("minecraft"))) {
          localIterator1.remove();
        }
      }
    }
    for (Object localObject1 = Arrays.asList(new AverageTexturedTool[] { new EmeraldSword(), new EmeraldAxe(), new EmeraldPickaxe(), new EmeraldShovel(), new EmeraldHoe(), new EmeraldDoubleAxe(), new EmeraldSickle(), new com.chrismin13.vanillaadditions.items.chisels.EmeraldChisel(), new EmeraldHammer(), new ObsidianSword(), new ObsidianAxe(), new ObsidianPickaxe(), new ObsidianShovel(), new ObsidianHoe(), new ObsidianDoubleAxe(), new ObsidianSickle(), new ObsidianChisel(), new ObsidianHammer(), new EndStoneSword(), new EndStoneAxe(), new EndStonePickaxe(), new EndStoneShovel(), new EndStoneHoe(), new EndStoneDoubleAxe(), new EndStoneSickle(), new EndStoneChisel(), new EndStoneHammer(), new NetherrackSword(), new NetherrackAxe(), new NetherrackPickaxe(), new NetherrackShovel(), new NetherrackHoe(), new NetherrackDoubleAxe(), new NetherrackSickle(), new com.chrismin13.vanillaadditions.items.chisels.NetherrackChisel(), new NetherrackHammer(), new CoalSword(), new CoalAxe(), new CoalPickaxe(), new CoalShovel(), new CoalHoe(), new CoalDoubleAxe(), new CoalSickle(), new CoalChisel(), new CoalHammer(), new LapisSword(), new LapisAxe(), new LapisPickaxe(), new LapisShovel(), new LapisHoe(), new LapisDoubleAxe(), new LapisSickle(), new LapisChisel(), new com.chrismin13.vanillaadditions.items.hammers.LapisHammer(), new RedstoneSword(), new RedstoneAxe(), new RedstonePickaxe(), new RedstoneShovel(), new RedstoneHoe(), new RedstoneDoubleAxe(), new RedstoneSickle(), new RedstoneChisel(), new RedstoneHammer(), new PrismarineSword(), new PrismarineAxe(), new PrismarinePickaxe(), new PrismarineShovel(), new PrismarineHoe(), new PrismarineDoubleAxe(), new PrismarineSickle(), new PrismarineChisel(), new PrismarineHammer(), new ClaySword(), new ClayAxe(), new ClayPickaxe(), new ClayShovel(), new ClayHoe(), new ClayDoubleAxe(), new ClaySickle(), new ClayChisel(), new ClayHammer(), new SlimeSword(), new SlimeAxe(), new SlimePickaxe(), new SlimeShovel(), new SlimeHoe(), new SlimeDoubleAxe(), new SlimeSickle(), new SlimeChisel(), new SlimeHammer(), new StoneDoubleAxe(), new IronDoubleAxe(), new GoldDoubleAxe(), new DiamondDoubleAxe(), new StoneSickle(), new IronSickle(), new GoldSickle(), new DiamondSickle(), new StoneChisel(), new IronChisel(), new GoldChisel(), new DiamondChisel(), new StoneHammer(), new IronHammer(), new GoldHammer(), new DiamondHammer() }).iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (CustomItem)((Iterator)localObject1).next();
      







































      paramAdditionsAPIInitializationEvent.addCustomItem((CustomItem)localObject2); }
    Object localObject3;
    for (localObject3 : ArmorType.values())
    {
      paramAdditionsAPIInitializationEvent.addCustomItem(new EmeraldArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new ObsidianArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new StoneArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new EndStoneArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new NetherrackArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new CoalArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new LapisArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new RedstoneArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new PrismarineArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new ClayArmor((ArmorType)localObject3));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new SlimeArmor((ArmorType)localObject3));
    }
    

    for (localObject1 = Arrays.asList(new String[] { "oak;oak", "spruce;spruce", "birch;birch", "jungle;jungle", "acacia;acacia", "dark_oak;big_oak" }).iterator(); ((Iterator)localObject1).hasNext();) { String str = (String)((Iterator)localObject1).next();
      
      String[] arrayOfString = str.split(";");
      localObject3 = Material.valueOf(arrayOfString[0].toUpperCase() + "_PLANKS");
      for (DamageableItem localDamageableItem : Arrays.asList(new DamageableItem[] { DamageableItem.WOODEN_SWORD, DamageableItem.WOODEN_AXE, DamageableItem.WOODEN_PICKAXE, DamageableItem.WOODEN_SHOVEL, DamageableItem.WOODEN_HOE }))
      {
        paramAdditionsAPIInitializationEvent.addCustomItem(new WoodBasedItem(localDamageableItem, (Material)localObject3, arrayOfString[0], arrayOfString[1] + "_" + localDamageableItem
          .getTextureName().replaceAll("wooden_", "wood_"), 
          WordUtils.capitalize((arrayOfString[0] + " " + localDamageableItem.toString().replaceAll("_", " ")).toLowerCase())));
      }
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new WoodBasedDoubleAxe((Material)localObject3, arrayOfString[0], arrayOfString[1] + "_wood_double_axe", 
        WordUtils.capitalize(arrayOfString[0].replaceAll("_", " ").toLowerCase()) + " Wooden Double Axe"));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new WoodBasedSickle((Material)localObject3, arrayOfString[0], arrayOfString[1] + "_wood_sickle", 
        WordUtils.capitalize(arrayOfString[0].replaceAll("_", " ").toLowerCase()) + " Wooden Sickle"));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new WoodBasedChisel((Material)localObject3, arrayOfString[0], arrayOfString[1] + "_wood_chisel", 
        WordUtils.capitalize(arrayOfString[0].replaceAll("_", " ").toLowerCase()) + " Wooden Chisel"));
      
      paramAdditionsAPIInitializationEvent.addCustomItem(new WoodBasedHammer((Material)localObject3, arrayOfString[0], arrayOfString[1] + "_wood_hammer", 
        WordUtils.capitalize(arrayOfString[0].replaceAll("_", " ").toLowerCase()) + " Wooden Hammer"));
    }
    

    paramAdditionsAPIInitializationEvent.addCustomItem(new EnderBow());
    

    paramAdditionsAPIInitializationEvent.addCustomItem(new SlimeBucket());
    
    addCustomCraftingRecipes();
  }
  
  private static void addCustomCraftingRecipes()
  {
    List localList = config.getStringList("enabled-recipes");
    

    if (localList.contains("SLABS_TO_FULL_BLOCKS")) {
      addHalfSlabCombo(Material.STONE_SLAB, Material.STONE);
      addHalfSlabCombo(Material.COBBLESTONE_SLAB, Material.COBBLESTONE);
      addHalfSlabCombo(Material.BRICK_SLAB, Material.BRICK);
      addHalfSlabCombo(Material.NETHER_BRICK_SLAB, Material.NETHER_BRICK);
      addHalfSlabCombo(Material.OAK_SLAB, Material.OAK_PLANKS);
      addHalfSlabCombo(Material.BIRCH_SLAB, Material.BIRCH_PLANKS);
      addHalfSlabCombo(Material.DARK_OAK_SLAB, Material.DARK_OAK_PLANKS);
      addHalfSlabCombo(Material.ACACIA_SLAB, Material.ACACIA_PLANKS);
      addHalfSlabCombo(Material.SPRUCE_SLAB, Material.SPRUCE_PLANKS);
      addHalfSlabCombo(Material.JUNGLE_SLAB, Material.JUNGLE_PLANKS);
    }
    

    if (localList.contains("CLAY_CONVERSION")) {
      addSingleMaterialToItem(Material.CLAY, Material.CLAY_BALL, 4);
    }
    

    if (localList.contains("STAIRS_TO_BLOCKS")) {
      addFourMaterialsToItem(Material.OAK_STAIRS, Material.OAK_PLANKS, 2);
      addFourMaterialsToItem(Material.SPRUCE_STAIRS, Material.SPRUCE_PLANKS, 2);
      addFourMaterialsToItem(Material.BIRCH_STAIRS, Material.BIRCH_PLANKS, 2);
      addFourMaterialsToItem(Material.JUNGLE_STAIRS, Material.JUNGLE_PLANKS, 2);
      addFourMaterialsToItem(Material.ACACIA_STAIRS, Material.ACACIA_PLANKS, 2);
      addFourMaterialsToItem(Material.DARK_OAK_STAIRS, Material.DARK_OAK_PLANKS, 2);
      addFourMaterialsToItem(Material.COBBLESTONE_STAIRS, Material.COBBLESTONE, 2);
      addFourMaterialsToItem(Material.BRICK_STAIRS, Material.BRICK, 2);
      addFourMaterialsToItem(Material.STONE_BRICK_STAIRS, Material.STONE_BRICKS, 2);
      addFourMaterialsToItem(Material.NETHER_BRICK_STAIRS, Material.NETHER_BRICK, 2);
      addFourMaterialsToItem(Material.SANDSTONE_STAIRS, Material.SANDSTONE, 2);
      addFourMaterialsToItem(Material.QUARTZ_STAIRS, Material.QUARTZ_BLOCK, 2);
      addFourMaterialsToItem(Material.RED_SANDSTONE_STAIRS, Material.RED_SANDSTONE, 2);
      addFourMaterialsToItem(Material.PURPUR_SLAB, Material.PURPUR_BLOCK, 2);
    }
  }
  
  public static void addHalfSlabCombo(Material paramMaterial1, Material paramMaterial2)
  {
    addHalfSlabCombo(paramMaterial1, 1, 0, paramMaterial2, 1, 0);
  }
  
  public static void addHalfSlabCombo(Material paramMaterial1, int paramInt, Material paramMaterial2) {
    addHalfSlabCombo(paramMaterial1, 1, paramInt, paramMaterial2, 1, 0);
  }
  
  public static void addHalfSlabCombo(Material paramMaterial1, int paramInt1, Material paramMaterial2, int paramInt2)
  {
    addHalfSlabCombo(paramMaterial1, 1, paramInt1, paramMaterial2, 1, paramInt2);
  }
  


  public static void addHalfSlabCombo(Material paramMaterial1, int paramInt1, int paramInt2, Material paramMaterial2, int paramInt3, int paramInt4)
  {
    ItemStack localItemStack = new ItemStack(paramMaterial2, paramInt3, (short)paramInt4);
    
    ShapedRecipe localShapedRecipe = new ShapedRecipe(localItemStack);
    
    localShapedRecipe.shape(new String[] { "1", "1" });
    
    localShapedRecipe.setIngredient('1', paramMaterial1, paramInt2);
    
    Bukkit.getServer().addRecipe(localShapedRecipe);
  }
  




  public static void addTwoItemsCombo(Material paramMaterial1, int paramInt1, Material paramMaterial2, int paramInt2, ItemStack paramItemStack)
  {
    ShapedRecipe localShapedRecipe = new ShapedRecipe(paramItemStack);
    
    localShapedRecipe.shape(new String[] { "1", "2" });
    localShapedRecipe.setIngredient('1', paramMaterial1, paramInt1);
    localShapedRecipe.setIngredient('2', paramMaterial2, paramInt2);
    Bukkit.getServer().addRecipe(localShapedRecipe);
  }
  
  public static void addTwoItemsCombo(Material paramMaterial1, Material paramMaterial2, ItemStack paramItemStack) {
    addTwoItemsCombo(paramMaterial1, 0, paramMaterial2, 0, paramItemStack);
  }
  


  public static void addSingleMaterialToItem(Material paramMaterial, int paramInt, ItemStack paramItemStack)
  {
    ShapedRecipe localShapedRecipe = new ShapedRecipe(paramItemStack);
    
    localShapedRecipe.shape(new String[] { "1" });
    localShapedRecipe.setIngredient('1', paramMaterial, paramInt);
    Bukkit.getServer().addRecipe(localShapedRecipe);
  }
  
  public static void addSingleMaterialToItem(Material paramMaterial1, Material paramMaterial2)
  {
    addSingleMaterialToItem(paramMaterial1, 0, new ItemStack(paramMaterial2, 1, (short)0));
  }
  
  public static void addSingleMaterialToItem(Material paramMaterial1, int paramInt, Material paramMaterial2) {
    addSingleMaterialToItem(paramMaterial1, paramInt, new ItemStack(paramMaterial2, 1, (short)0));
  }
  
  public static void addSingleMaterialToItem(Material paramMaterial1, int paramInt1, Material paramMaterial2, int paramInt2)
  {
    addSingleMaterialToItem(paramMaterial1, paramInt1, new ItemStack(paramMaterial2, 1, (short)paramInt2));
  }
  
  public static void addSingleMaterialToItem(Material paramMaterial1, Material paramMaterial2, int paramInt1, int paramInt2)
  {
    addSingleMaterialToItem(paramMaterial1, 0, new ItemStack(paramMaterial2, paramInt2, (short)paramInt1));
  }
  
  public static void addSingleMaterialToItem(Material paramMaterial1, int paramInt1, Material paramMaterial2, int paramInt2, int paramInt3)
  {
    addSingleMaterialToItem(paramMaterial1, paramInt1, new ItemStack(paramMaterial2, paramInt3, (short)paramInt2));
  }
  
  public static void addSingleMaterialToItem(Material paramMaterial1, Material paramMaterial2, int paramInt)
  {
    addSingleMaterialToItem(paramMaterial1, 0, new ItemStack(paramMaterial2, paramInt, (short)0));
  }
  


  public static void addStair(Material paramMaterial1, Material paramMaterial2)
  {
    ItemStack localItemStack = new ItemStack(paramMaterial2);
    
    ShapedRecipe localShapedRecipe1 = new ShapedRecipe(localItemStack);
    
    localShapedRecipe1.shape(new String[] { "100", "110", "111" });
    localShapedRecipe1.setIngredient('1', paramMaterial1);
    Bukkit.getServer().addRecipe(localShapedRecipe1);
    
    ShapedRecipe localShapedRecipe2 = new ShapedRecipe(localItemStack);
    
    localShapedRecipe2.shape(new String[] { "001", "011", "111" });
    localShapedRecipe2.setIngredient('1', paramMaterial1);
    Bukkit.getServer().addRecipe(localShapedRecipe2);
  }
  


  public static void addFourMaterialsToItem(Material paramMaterial1, Material paramMaterial2, int paramInt)
  {
    ItemStack localItemStack = new ItemStack(paramMaterial2, paramInt);
    
    ShapedRecipe localShapedRecipe = new ShapedRecipe(localItemStack);
    
    localShapedRecipe.shape(new String[] { "11", "11" });
    localShapedRecipe.setIngredient('1', paramMaterial1);
    Bukkit.getServer().addRecipe(localShapedRecipe);
  }
  

  public static ItemStack increaseAmount(ItemStack paramItemStack, int paramInt)
  {
    paramItemStack.setAmount(paramInt);
    return paramItemStack;
  }
  
  public static void addFullTableToItem(Material paramMaterial1, Material paramMaterial2, int paramInt)
  {
    ItemStack localItemStack = new ItemStack(paramMaterial2, paramInt);
    
    ShapedRecipe localShapedRecipe = new ShapedRecipe(localItemStack);
    
    localShapedRecipe.shape(new String[] { "111", "111", "111" });
    localShapedRecipe.setIngredient('1', paramMaterial1);
    Bukkit.getServer().addRecipe(localShapedRecipe);
  }
}
