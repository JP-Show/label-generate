package com.utils;

import com.exceptions.myException;

import oshi.SystemInfo;

public class Sysinfo {

  public static SystemInfo info () throws myException {
    SystemInfo si = new SystemInfo();
    return si;
  }
}
