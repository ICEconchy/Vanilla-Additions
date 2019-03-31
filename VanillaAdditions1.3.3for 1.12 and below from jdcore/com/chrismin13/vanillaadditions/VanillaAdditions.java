package com.chrismin13.vanillaadditions;

import com.chrismin13.additionsapi.utils.Debug;
import com.chrismin13.vanillaadditions.bukkit.Metrics;
import com.chrismin13.vanillaadditions.listeners.ArmorStandListener;
import com.chrismin13.vanillaadditions.listeners.BlockBreakListener;
import com.chrismin13.vanillaadditions.listeners.ChiselListener;
import com.chrismin13.vanillaadditions.listeners.NetherrackItemsListener;
import com.chrismin13.vanillaadditions.listeners.RedstoneItemsListener;
import com.chrismin13.vanillaadditions.listeners.SlimeBucketListener;
import com.chrismin13.vanillaadditions.listeners.SpongeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class VanillaAdditions extends JavaPlugin
{
  private static JavaPlugin instance;
  public static ArrayList<Enchantment> blacklistedEnchantments;
  
  public VanillaAdditions() {}
  
  public void onEnable()
  {
    loadConfig0();instance = this;
    
    initializeConfig();
    
    new Metrics(this);
    
    PluginManager localPluginManager = getServer().getPluginManager();
    localPluginManager.registerEvents(new BlockBreakListener(), this);
    localPluginManager.registerEvents(new com.chrismin13.vanillaadditions.listeners.EnderBowListener(), this);
    localPluginManager.registerEvents(new Items(), this);
    localPluginManager.registerEvents(new SlimeBucketListener(), this);
    localPluginManager.registerEvents(new NetherrackItemsListener(), this);
    localPluginManager.registerEvents(new com.chrismin13.vanillaadditions.listeners.CoalItemsListener(), this);
    localPluginManager.registerEvents(new com.chrismin13.vanillaadditions.listeners.LapisItemsListener(), this);
    localPluginManager.registerEvents(new RedstoneItemsListener(), this);
    localPluginManager.registerEvents(new SpongeListener(), this);
    localPluginManager.registerEvents(new ChiselListener(), this);
    localPluginManager.registerEvents(new ArmorStandListener(), this);
    localPluginManager.registerEvents(new com.chrismin13.vanillaadditions.listeners.BookListener(), this);
  }
  


  private void initializeConfig()
  {
    String str1 = getDataFolder() + File.separator + "config.yml";
    YamlConfiguration localYamlConfiguration = YamlConfiguration.loadConfiguration(new File(str1));
    
    int i = 0;
    List localList1;
    if (localYamlConfiguration.getInt("config-version", 0) == 0) {
      localYamlConfiguration.set("config-version", Integer.valueOf(1));
      
      localList1 = localYamlConfiguration.getStringList("enabled-mechanics");
      localList1.add("ARMOR_STANDS_WITH_ARMS");
      localList1.add("ARMOR_STAND_ITEM_IN_OFF_HAND");
      localYamlConfiguration.set("enabled-mechanics", localList1);
      
      i = 1;
    }
    
    if (localYamlConfiguration.getInt("config-version") == 1) {
      localYamlConfiguration.set("config-version", Integer.valueOf(2));
      
      localList1 = localYamlConfiguration.getStringList("enabled-mechanics");
      localList1.add("OPEN_BOOK_IN_ITEM_FRAME");
      localYamlConfiguration.set("enabled-mechanics", localList1);
      
      i = 1;
    }
    
    if (localYamlConfiguration.getInt("config-version") == 2) {
      localYamlConfiguration.set("config-version", Integer.valueOf(3));
      
      localList1 = localYamlConfiguration.getStringList("blacklisted-enchantments");
      localList1.add("NULL");
      localYamlConfiguration.set("blacklisted-enchantments", localList1);
      
      i = 1;
    }
    
    if (localYamlConfiguration.getInt("config-version") == 3) {
      localYamlConfiguration.set("config-version", Integer.valueOf(4));
      
      localYamlConfiguration.set("hammer.only-break-same-type", Boolean.valueOf(false));
      
      i = 1;
    }
    
    if (i != 0) {
      try {
        localYamlConfiguration.options().header("-------=======----- Vanilla Additions by chrismin13 -----=======------- #\n= #\n# If you want to enable or disable Custom Items, like Emerald Swords, use\n# the Configuration of the Additions API!\n= #\n-------=======-------====== Configuration File =====-------=======------- #\n-----=======-------=======-------=======-------=======-------=======----- #\n= #\n# config-version: This keeps track of the version of your Config. If new\n#                 values are added by default, this will increase.\n#                 DO NOT CHANGE - IT CHANGES BY ITSELF WHEN NEEDED!\n= #\n-----=======-------=======-------=======-------=======-------=======----- #\n= #\n# enabled-recipes: This is a list of the recipes that will be added. This\n#                  does not include Custom Items, you can configure them\n#                  in the Additions API Config. Valid values are:\n#                  - SLABS_TO_FULL_BLOCKS (Converts two slabs, one on top of\n#                    the other, to the regular block)\n#                  - CLAY_CONVERSION (Converts a Clay Block to 4 Clay Balls)\n#                  - STAIRS_TO_BLOCKS (Converts a grid of 2x2 of Stairs to\n#                    a full block)\n= #\n------=======-------=======-------=======-------=======-------=======----- #\n= #\n# enabled-mechanics: This is a list of the game mechanics that will be enabled.\n#                    This does not include Custom Items, you can configure them\n#                    in the Additions API Config. Valid values are:\n#                    - WET_SPONGE_TO_SPONGE (Convert Wet Sponge to normal,\n#                      dry Sponge when placed in the nether.\n#                    - ARMOR_STANDS_WITH_ARMS (Add hands when an Armor Stand\n#                      is spawned)\n#                    - ARMOR_STAND_ITEM_IN_OFF_HAND (Add an item in the off\n#                      hand of an Armor Stand by holding it in your Off Hand)\n#                    - OPEN_BOOK_IN_ITEM_FRAME (Open any book in an Item\n#                      frame by right clicking on it! No need to take it out.) \n= #\n------=======-------=======-------=======-------=======-------=======----- #\n = #\n # blacklisted-enchantments: This list contains any enchantments that won't\n#                           be changed when enchanting the Lapis Items.\n#                           Their names can be found in the Spigot Docs:\n#                           http://bit.ly/2Ccin0C\n= #\n------=======-------=======-------=======-------=======-------=======----- #\r\n# hammer: Change properties for the hammer\r\n#         - only-break-same-type: Only break blocks that are of the same \r\n#                                 type as the one you originally mined.\r\n= #\r\n------=======-------=======-------=======-------=======-------=======----- #");
        





































        localYamlConfiguration.save(str1);
      } catch (IOException localIOException) {
        Debug.sayError("Could not save config! Please check if the hard drive is full or the file is in use, e.g. Opened in another program, such as Notepad or Notepad++.");
        
        localIOException.printStackTrace();
      }
    }
    
    saveDefaultConfig();
    
    Items.config = getInstance().getConfig();
    
    ArrayList localArrayList = new ArrayList();
    try {
      if ((getConfig().getStringList("blacklisted-enchantments") != null) && 
        (!getConfig().getStringList("blacklisted-enchantments").isEmpty())) {
        List localList2 = getConfig().getStringList("blacklisted-enchantments");
        for (String str2 : localList2) {
          if (!str2.equalsIgnoreCase("NULL")) {
            String str3 = str2.toUpperCase();
            localArrayList.add(Enchantment.getByName(str3));
          }
        }
      }
    } catch (Exception localException) {
      Debug.sayError("Vanilla Additions encountered a problem reading the Blacklisted Enchantments list for the Lapis Tools and Armor. Please check that you have set up the enchantments with the correct names, according to this list: http://bit.ly/2Ccin0C");
    }
    


    blacklistedEnchantments = localArrayList;
  }
  
  public static JavaPlugin getInstance() {
    return instance;
  }
}
