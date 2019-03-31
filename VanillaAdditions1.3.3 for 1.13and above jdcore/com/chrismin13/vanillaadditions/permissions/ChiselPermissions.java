package com.chrismin13.vanillaadditions.permissions;

import com.chrismin13.additionsapi.permissions.PermissionType;

public class ChiselPermissions extends com.chrismin13.additionsapi.permissions.ItemPermissions
{
  private String chisel;
  
  public ChiselPermissions(String paramString, PermissionType paramPermissionType)
  {
    super(paramString, paramPermissionType);
    chisel = (getPermissionPrefix() + "." + getType().getPermission() + ".chisel");
  }
  



  public String getChisel()
  {
    return chisel;
  }
  


  public void setChisel(String paramString)
  {
    chisel = paramString;
  }
}
