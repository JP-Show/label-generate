package com.entities;

import java.io.IOException;
import java.util.List;

import com.exceptions.myException;
import com.utils.DOS;
import com.utils.Sysinfo;

import oshi.hardware.Baseboard;

public class Motherboard {

  public static String getName() throws myException, IOException {
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
    } catch (myException e) {
      throw new myException("Error ao pegar o nome da placa mãe - " + e.getMessage(), e.getCause());
    } catch (IOException e) {
      throw new IOException("Error ao pegar o nome da placa mãe - " + e.getMessage(), e.getCause());
    }

    return mb;
  }

}
