package com.chrismin13.vanillaadditions.utils;

import java.lang.reflect.Method;

public class NMSUtils {
  public NMSUtils() {}
  
  public static void sendPacket(org.bukkit.entity.Player paramPlayer, Object paramObject) {
    try {
      Object localObject1 = paramPlayer.getClass().getMethod("getHandle", new Class[0]).invoke(paramPlayer, new Object[0]);
      Object localObject2 = localObject1.getClass().getField("playerConnection").get(localObject1);
      localObject2.getClass().getMethod("sendPacket", new Class[] { getNMSClass("Packet") }).invoke(localObject2, new Object[] { paramObject });
    } catch (Exception localException) {
      localException.printStackTrace();
    }
  }
  
  public static Class<?> getNMSClass(String paramString) {
    String str = org.bukkit.Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    try {
      return Class.forName("net.minecraft.server." + str + "." + paramString);
    } catch (ClassNotFoundException localClassNotFoundException) {
      localClassNotFoundException.printStackTrace(); }
    return null;
  }
}
