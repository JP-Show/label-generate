package com.utils;

import oshi.SystemInfo;

public class Sysinfo {

  public static SystemInfo info (){
    SystemInfo si = new SystemInfo();
    return si;
  }
}
