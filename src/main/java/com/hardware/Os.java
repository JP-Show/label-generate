package com.hardware;

import java.io.IOException;
import java.util.List;

import com.utils.DOS;
import com.utils.Log;
import com.utils.Sysinfo;

public class Os extends Thread {
  public String name = "";

  @Override
  public void run() {
    name = name();
  }

  public String name() {
    String name = "unknown";
    int version = 00;

    try {
      version = Sysinfo.info().getOperatingSystem().getBitness();

      List<String> list = DOS
          .exec(new String[] { "cmd.exe", "/c", "systeminfo" });
      String nameOS = list.get(1);
      if (nameOS != null) {
        name = nameOS;
      }
    } catch (IOException e) {
      Log.createLogFile("Error pegar o socket - " + e.getMessage());
      System.out.println("Error ao pegar o nome do sistema operacional - " + e.getMessage() + e.getCause());
    }
    String Os = name + " x" + version;
    return Os;
  }
}
