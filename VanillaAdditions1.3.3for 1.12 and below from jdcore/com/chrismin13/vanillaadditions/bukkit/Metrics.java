package com.chrismin13.vanillaadditions.bukkit;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Metrics
{
  public static final int B_STATS_VERSION = 1;
  private static final String URL = "https://bStats.org/submitData/bukkit";
  private static boolean logFailedRequests;
  private static String serverUUID;
  private final JavaPlugin plugin;
  
  static
  {
    if ((System.getProperty("bstats.relocatecheck") == null) || (!System.getProperty("bstats.relocatecheck").equals("false")))
    {
      String str1 = new String(new byte[] { 111, 114, 103, 46, 98, 115, 116, 97, 116, 115, 46, 98, 117, 107, 107, 105, 116 });
      
      String str2 = new String(new byte[] { 121, 111, 117, 114, 46, 112, 97, 99, 107, 97, 103, 101 });
      
      if ((Metrics.class.getPackage().getName().equals(str1)) || (Metrics.class.getPackage().getName().equals(str2))) {
        throw new IllegalStateException("bStats Metrics class has not been relocated correctly!");
      }
    }
  }
  
















  private final List<CustomChart> charts = new java.util.ArrayList();
  




  public Metrics(JavaPlugin paramJavaPlugin)
  {
    if (paramJavaPlugin == null) {
      throw new IllegalArgumentException("Plugin cannot be null!");
    }
    plugin = paramJavaPlugin;
    

    File localFile1 = new File(paramJavaPlugin.getDataFolder().getParentFile(), "bStats");
    File localFile2 = new File(localFile1, "config.yml");
    YamlConfiguration localYamlConfiguration = YamlConfiguration.loadConfiguration(localFile2);
    

    if (!localYamlConfiguration.isSet("serverUuid"))
    {

      localYamlConfiguration.addDefault("enabled", Boolean.valueOf(true));
      
      localYamlConfiguration.addDefault("serverUuid", UUID.randomUUID().toString());
      
      localYamlConfiguration.addDefault("logFailedRequests", Boolean.valueOf(false));
      

      localYamlConfiguration.options().header("bStats collects some data for plugin authors like how many servers are using their plugins.\nTo honor their work, you should not disable it.\nThis has nearly no effect on the server performance!\nCheck out https://bStats.org/ to learn more :)")
      



        .copyDefaults(true);
      try {
        localYamlConfiguration.save(localFile2);
      }
      catch (IOException localIOException) {}
    }
    
    serverUUID = localYamlConfiguration.getString("serverUuid");
    logFailedRequests = localYamlConfiguration.getBoolean("logFailedRequests", false);
    if (localYamlConfiguration.getBoolean("enabled", true)) {
      int i = 0;
      
      for (Class localClass : Bukkit.getServicesManager().getKnownServices()) {
        try {
          localClass.getField("B_STATS_VERSION");
          i = 1;
        }
        catch (NoSuchFieldException localNoSuchFieldException) {}
      }
      
      Bukkit.getServicesManager().register(Metrics.class, this, paramJavaPlugin, org.bukkit.plugin.ServicePriority.Normal);
      if (i == 0)
      {
        startSubmitting();
      }
    }
  }
  




  public void addCustomChart(CustomChart paramCustomChart)
  {
    if (paramCustomChart == null) {
      throw new IllegalArgumentException("Chart cannot be null!");
    }
    charts.add(paramCustomChart);
  }
  


  private void startSubmitting()
  {
    final Timer localTimer = new Timer(true);
    localTimer.scheduleAtFixedRate(new java.util.TimerTask()
    {
      public void run() {
        if (!plugin.isEnabled()) {
          localTimer.cancel();
          return;
        }
        

        Bukkit.getScheduler().runTask(plugin, new Runnable()
        {
          public void run() {
            Metrics.this.submitData();
          }
        });
      }
    }, 300000L, 1800000L);
  }
  















  public JSONObject getPluginData()
  {
    JSONObject localJSONObject1 = new JSONObject();
    
    String str1 = plugin.getDescription().getName();
    String str2 = plugin.getDescription().getVersion();
    
    localJSONObject1.put("pluginName", str1);
    localJSONObject1.put("pluginVersion", str2);
    JSONArray localJSONArray = new JSONArray();
    for (CustomChart localCustomChart : charts)
    {
      JSONObject localJSONObject2 = localCustomChart.getRequestJsonObject();
      if (localJSONObject2 != null)
      {

        localJSONArray.add(localJSONObject2); }
    }
    localJSONObject1.put("customCharts", localJSONArray);
    
    return localJSONObject1;
  }
  



  private JSONObject getServerData()
  {
    int j;
    


    try
    {
      Method localMethod = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers", new Class[0]);
      

      j = localMethod.getReturnType().equals(Collection.class) ? ((Collection)localMethod.invoke(Bukkit.getServer(), new Object[0])).size() : ((org.bukkit.entity.Player[])localMethod.invoke(Bukkit.getServer(), new Object[0])).length;
    } catch (Exception localException) {
      j = Bukkit.getOnlinePlayers().size();
    }
    int i = Bukkit.getOnlineMode() ? 1 : 0;
    String str1 = Bukkit.getVersion();
    str1 = str1.substring(str1.indexOf("MC: ") + 4, str1.length() - 1);
    

    String str2 = System.getProperty("java.version");
    String str3 = System.getProperty("os.name");
    String str4 = System.getProperty("os.arch");
    String str5 = System.getProperty("os.version");
    int k = Runtime.getRuntime().availableProcessors();
    
    JSONObject localJSONObject = new JSONObject();
    
    localJSONObject.put("serverUUID", serverUUID);
    
    localJSONObject.put("playerAmount", Integer.valueOf(j));
    localJSONObject.put("onlineMode", Integer.valueOf(i));
    localJSONObject.put("bukkitVersion", str1);
    
    localJSONObject.put("javaVersion", str2);
    localJSONObject.put("osName", str3);
    localJSONObject.put("osArch", str4);
    localJSONObject.put("osVersion", str5);
    localJSONObject.put("coreCount", Integer.valueOf(k));
    
    return localJSONObject;
  }
  


  private void submitData()
  {
    final JSONObject localJSONObject = getServerData();
    
    JSONArray localJSONArray = new JSONArray();
    
    for (Class localClass : Bukkit.getServicesManager().getKnownServices()) {
      try {
        localClass.getField("B_STATS_VERSION");
        
        for (RegisteredServiceProvider localRegisteredServiceProvider : Bukkit.getServicesManager().getRegistrations(localClass)) {
          try {
            localJSONArray.add(localRegisteredServiceProvider.getService().getMethod("getPluginData", new Class[0]).invoke(localRegisteredServiceProvider.getProvider(), new Object[0]));
          }
          catch (NullPointerException|NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException localNullPointerException) {}
        }
      } catch (NoSuchFieldException localNoSuchFieldException) {}
    }
    localJSONObject.put("plugins", localJSONArray);
    

    new Thread(new Runnable()
    {
      public void run()
      {
        try {
          Metrics.sendData(localJSONObject);
        }
        catch (Exception localException) {
          if (Metrics.logFailedRequests) {
            plugin.getLogger().log(Level.WARNING, "Could not submit plugin stats of " + plugin.getName(), localException);
          }
        }
      }
    })
    











      .start();
  }
  





  private static void sendData(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      throw new IllegalArgumentException("Data cannot be null!");
    }
    if (Bukkit.isPrimaryThread()) {
      throw new IllegalAccessException("This method must not be called from the main thread!");
    }
    HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL("https://bStats.org/submitData/bukkit").openConnection();
    

    byte[] arrayOfByte = compress(paramJSONObject.toString());
    

    localHttpsURLConnection.setRequestMethod("POST");
    localHttpsURLConnection.addRequestProperty("Accept", "application/json");
    localHttpsURLConnection.addRequestProperty("Connection", "close");
    localHttpsURLConnection.addRequestProperty("Content-Encoding", "gzip");
    localHttpsURLConnection.addRequestProperty("Content-Length", String.valueOf(arrayOfByte.length));
    localHttpsURLConnection.setRequestProperty("Content-Type", "application/json");
    localHttpsURLConnection.setRequestProperty("User-Agent", "MC-Server/1");
    

    localHttpsURLConnection.setDoOutput(true);
    DataOutputStream localDataOutputStream = new DataOutputStream(localHttpsURLConnection.getOutputStream());
    localDataOutputStream.write(arrayOfByte);
    localDataOutputStream.flush();
    localDataOutputStream.close();
    
    localHttpsURLConnection.getInputStream().close();
  }
  






  private static byte[] compress(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramString.getBytes("UTF-8"));
    localGZIPOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  




  public static abstract class CustomChart
  {
    final String chartId;
    




    CustomChart(String paramString)
    {
      if ((paramString == null) || (paramString.isEmpty())) {
        throw new IllegalArgumentException("ChartId cannot be null or empty!");
      }
      chartId = paramString;
    }
    
    private JSONObject getRequestJsonObject() {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("chartId", chartId);
      try {
        JSONObject localJSONObject2 = getChartData();
        if (localJSONObject2 == null)
        {
          return null;
        }
        localJSONObject1.put("data", localJSONObject2);
      } catch (Throwable localThrowable) {
        if (Metrics.logFailedRequests) {
          Bukkit.getLogger().log(Level.WARNING, "Failed to get data for custom chart with id " + chartId, localThrowable);
        }
        return null;
      }
      return localJSONObject1;
    }
    



    protected abstract JSONObject getChartData();
  }
  



  public static class SimplePie
    extends Metrics.CustomChart
  {
    private final Callable<String> callable;
    


    public SimplePie(String paramString, Callable<String> paramCallable)
    {
      super();
      callable = paramCallable;
    }
    
    protected JSONObject getChartData()
    {
      JSONObject localJSONObject = new JSONObject();
      String str = (String)callable.call();
      if ((str == null) || (str.isEmpty()))
      {
        return null;
      }
      localJSONObject.put("value", str);
      return localJSONObject;
    }
  }
  




  public static class AdvancedPie
    extends Metrics.CustomChart
  {
    private final Callable<Map<String, Integer>> callable;
    



    public AdvancedPie(String paramString, Callable<Map<String, Integer>> paramCallable)
    {
      super();
      callable = paramCallable;
    }
    
    protected JSONObject getChartData()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      Map localMap = (Map)callable.call();
      if ((localMap == null) || (localMap.isEmpty()))
      {
        return null;
      }
      int i = 1;
      for (Map.Entry localEntry : localMap.entrySet())
        if (((Integer)localEntry.getValue()).intValue() != 0)
        {

          i = 0;
          localJSONObject2.put(localEntry.getKey(), localEntry.getValue());
        }
      if (i != 0)
      {
        return null;
      }
      localJSONObject1.put("values", localJSONObject2);
      return localJSONObject1;
    }
  }
  




  public static class DrilldownPie
    extends Metrics.CustomChart
  {
    private final Callable<Map<String, Map<String, Integer>>> callable;
    



    public DrilldownPie(String paramString, Callable<Map<String, Map<String, Integer>>> paramCallable)
    {
      super();
      callable = paramCallable;
    }
    
    public JSONObject getChartData()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      Map localMap = (Map)callable.call();
      if ((localMap == null) || (localMap.isEmpty()))
      {
        return null;
      }
      int i = 1;
      for (Map.Entry localEntry1 : localMap.entrySet()) {
        JSONObject localJSONObject3 = new JSONObject();
        int j = 1;
        for (Map.Entry localEntry2 : ((Map)localMap.get(localEntry1.getKey())).entrySet()) {
          localJSONObject3.put(localEntry2.getKey(), localEntry2.getValue());
          j = 0;
        }
        if (j == 0) {
          i = 0;
          localJSONObject2.put(localEntry1.getKey(), localJSONObject3);
        }
      }
      if (i != 0)
      {
        return null;
      }
      localJSONObject1.put("values", localJSONObject2);
      return localJSONObject1;
    }
  }
  




  public static class SingleLineChart
    extends Metrics.CustomChart
  {
    private final Callable<Integer> callable;
    



    public SingleLineChart(String paramString, Callable<Integer> paramCallable)
    {
      super();
      callable = paramCallable;
    }
    
    protected JSONObject getChartData()
    {
      JSONObject localJSONObject = new JSONObject();
      int i = ((Integer)callable.call()).intValue();
      if (i == 0)
      {
        return null;
      }
      localJSONObject.put("value", Integer.valueOf(i));
      return localJSONObject;
    }
  }
  




  public static class MultiLineChart
    extends Metrics.CustomChart
  {
    private final Callable<Map<String, Integer>> callable;
    




    public MultiLineChart(String paramString, Callable<Map<String, Integer>> paramCallable)
    {
      super();
      callable = paramCallable;
    }
    
    protected JSONObject getChartData()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      Map localMap = (Map)callable.call();
      if ((localMap == null) || (localMap.isEmpty()))
      {
        return null;
      }
      int i = 1;
      for (Map.Entry localEntry : localMap.entrySet())
        if (((Integer)localEntry.getValue()).intValue() != 0)
        {

          i = 0;
          localJSONObject2.put(localEntry.getKey(), localEntry.getValue());
        }
      if (i != 0)
      {
        return null;
      }
      localJSONObject1.put("values", localJSONObject2);
      return localJSONObject1;
    }
  }
  




  public static class SimpleBarChart
    extends Metrics.CustomChart
  {
    private final Callable<Map<String, Integer>> callable;
    




    public SimpleBarChart(String paramString, Callable<Map<String, Integer>> paramCallable)
    {
      super();
      callable = paramCallable;
    }
    
    protected JSONObject getChartData()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      Map localMap = (Map)callable.call();
      if ((localMap == null) || (localMap.isEmpty()))
      {
        return null;
      }
      for (Map.Entry localEntry : localMap.entrySet()) {
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.add(localEntry.getValue());
        localJSONObject2.put(localEntry.getKey(), localJSONArray);
      }
      localJSONObject1.put("values", localJSONObject2);
      return localJSONObject1;
    }
  }
  




  public static class AdvancedBarChart
    extends Metrics.CustomChart
  {
    private final Callable<Map<String, int[]>> callable;
    




    public AdvancedBarChart(String paramString, Callable<Map<String, int[]>> paramCallable)
    {
      super();
      callable = paramCallable;
    }
    
    protected JSONObject getChartData()
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      Map localMap = (Map)callable.call();
      if ((localMap == null) || (localMap.isEmpty()))
      {
        return null;
      }
      int i = 1;
      for (Map.Entry localEntry : localMap.entrySet())
        if (((int[])localEntry.getValue()).length != 0)
        {

          i = 0;
          JSONArray localJSONArray = new JSONArray();
          for (int m : (int[])localEntry.getValue()) {
            localJSONArray.add(Integer.valueOf(m));
          }
          localJSONObject2.put(localEntry.getKey(), localJSONArray);
        }
      if (i != 0)
      {
        return null;
      }
      localJSONObject1.put("values", localJSONObject2);
      return localJSONObject1;
    }
  }
}
