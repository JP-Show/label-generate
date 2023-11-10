package com.hardware;

import java.io.IOException;
import java.util.List;

import com.utils.DOS;
import com.utils.Log;
import com.utils.Sysinfo;

import oshi.hardware.CentralProcessor.ProcessorIdentifier;

public class Cpu {
  public static String getName() {
    String cpu = "unknown";
    try {
      ProcessorIdentifier pi = Sysinfo.info().getHardware().getProcessor().getProcessorIdentifier();
      if (pi.getModel() == "unknown") {
        List<String> resultDOS = DOS.exec(new String[] { "wmic", "baseboard", "get", "product" });
        cpu = resultDOS.get(0);
      } else {
        cpu = pi.getName();
      }
    } catch (IOException e) {
      Log.createLogFile("error ao pegar nome da CPU - " + e.getMessage());
      System.out.println("error ao pegar nome da CPU - " + e.getMessage() + e.getCause());
    }
    return cpu;
  }
}
