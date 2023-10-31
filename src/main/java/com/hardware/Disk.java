package com.hardware;

import java.util.ArrayList;
import java.util.List;

import com.exceptions.myException;
import com.utils.Sysinfo;

import oshi.hardware.HWDiskStore;

public class Disk {
  public static List<String> buildListDisk() throws myException {
    List<HWDiskStore> listHWD = new ArrayList<>();
    List<String> listDisk = new ArrayList<>();
    try {
      listHWD = Sysinfo.info().getHardware().getDiskStores();
      for (HWDiskStore disk : listHWD) {
        double sizeDouble = Math.floor(disk.getSize() * 0.000000001);
        Integer sizeInt = (int) sizeDouble;

        String type = disk.getWrites() > 72000 ? "SSD" : "HDD";
        String cap = sizeInt >= 1000 ? sizeInt / 1000 + " TB" : sizeInt + " GB";

        listDisk.add(type + " " + cap);
      }
    } catch (myException e) {
      throw new myException("Error ao criar lista de discos - " + e.getMessage(), e.getCause());
    }
    return listDisk;
  }

  public static String getName() throws myException {
    List<String> listDisk = buildListDisk();
    StringBuilder sb = new StringBuilder("");
    for (String disk : listDisk) {
      if (disk.equals(listDisk.get(listDisk.size() - 1))) {
        sb.append(disk);
        break;
      }
      sb.append(disk + " | ");
    }
    return sb.toString();
  }
}
