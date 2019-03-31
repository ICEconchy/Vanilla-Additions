package com.chrismin13.vanillaadditions.utils;

import io.netty.buffer.ByteBuf;
import java.lang.reflect.Constructor;
import org.bukkit.entity.Player;

public class BookUtils
{
  public BookUtils() {}
  
  public static void openBook(org.bukkit.inventory.ItemStack paramItemStack, Player paramPlayer)
  {
    int i = paramPlayer.getInventory().getHeldItemSlot();
    org.bukkit.inventory.ItemStack localItemStack = paramPlayer.getInventory().getItem(i);
    paramPlayer.getInventory().setItem(i, paramItemStack);
    
    ByteBuf localByteBuf = io.netty.buffer.Unpooled.buffer(256);
    localByteBuf.setByte(0, 0);
    localByteBuf.writerIndex(1);
    try
    {
      Constructor localConstructor1 = NMSUtils.getNMSClass("PacketDataSerializer").getConstructor(new Class[] { ByteBuf.class });
      Object localObject1 = localConstructor1.newInstance(new Object[] { localByteBuf });
      
      Constructor localConstructor2 = NMSUtils.getNMSClass("PacketPlayOutCustomPayload").getConstructor(new Class[] { String.class, NMSUtils.getNMSClass("PacketDataSerializer") });
      Object localObject2 = localConstructor2.newInstance(new Object[] { "MC|BOpen", localObject1 });
      
      NMSUtils.sendPacket(paramPlayer, localObject2);
    } catch (Exception localException) {
      localException.printStackTrace();
    }
    
    paramPlayer.getInventory().setItem(i, localItemStack);
  }
}
