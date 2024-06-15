package com.hardware;

import java.util.ArrayList;
import java.util.List;

import com.utils.Log;
import com.utils.Sysinfo;

import oshi.hardware.HWDiskStore;

public class Disk extends Thread {

  private static String type = "";
  private static String[] modelNameSsd = new String[] { "SSD", "NVME", "M.2", "M2", "ADATA", "KINGSTON" };
  public String name = "";

  @Override
  public void run() {
    name = name();
  }

  public static List<String> buildListDisk() {
    List<HWDiskStore> listHWD = new ArrayList<>();
    List<String> listDisk = new ArrayList<>();
    try {
      listHWD = Sysinfo.info().getHardware().getDiskStores();
      for (HWDiskStore disk : listHWD) {
        double sizeDouble = Math.floor(disk.getSize() * 0.000000001);
        Integer sizeInt = (int) sizeDouble;

        type = isSolidState(disk.getModel());
        String cap = sizeInt >= 1000 ? sizeInt / 1000 + " TB" : sizeInt + " GB";

        listDisk.add(type + " " + cap);
      }
    } catch (Exception e) {
      Log.createLogFile("Error ao buildar o hdd ou ssd - " + e.getMessage());
      System.out.println("Error ao buildar o hdd ou ssd - " + e.getMessage() + e.getCause());
    }
    return listDisk;
  }

  public static String name() {
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

  private static String isSolidState(String modelName) {
    for (String names : modelNameSsd)
      if (modelName.contains(names))
        return "SSD";
    return "HDD";
  }
}
