package com.hardware;

import java.io.IOException;
import java.util.List;

import com.utils.DOS;
import com.utils.Log;
import com.utils.Sysinfo;

import oshi.hardware.Baseboard;

public class Motherboard extends Thread {

  public String name = "";

  @Override
  public void run() {
    name = name();
  }

  public String name() {
    String mb = "unknown";
    try {
      Baseboard bb = Sysinfo.info().getHardware().getComputerSystem().getBaseboard();
      if (bb.getModel() == "unknown") {
        List<String> resultDOS = DOS.exec(new String[] { "wmic", "baseboard", "get", "product" });
        int lastIndex = resultDOS.size() - 1;
        mb = resultDOS.get(lastIndex);
      } else {
        mb = bb.getModel();
      }
    } catch (IOException e) {
      Log.createLogFile("Error pegar o socket - " + e.getMessage());
      System.out.println("Error ao pegar o nome do sistema operacional - " + e.getMessage() + e.getCause());
    }
    return mb;
  }

}
