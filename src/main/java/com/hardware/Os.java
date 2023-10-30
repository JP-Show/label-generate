package com.hardware;

import java.io.IOException;
import java.util.List;

import com.exceptions.myException;
import com.utils.DOS;
import com.utils.Sysinfo;
import com.utils.Regx;

public class Os {

  public static String getName() throws myException, IOException {
    String name = "unknown";
    int version = 00;

    try {
      version = Sysinfo.info().getOperatingSystem().getBitness();

      List<String> list = DOS
          .exec(new String[] { "cmd.exe", "/c", "systeminfo | findstr /C:\"Nome do sistema operacional\"" });
      String nameOS = list.get(0);

      name = Regx.cutString(".*(Windows \\d+\\s?\\w*)", nameOS);
    } catch (myException e) {
      throw new myException("Error ao pegar o nome do sistema operacional - " + e.getMessage(), e.getCause());
    } catch (Exception e) {
      throw new myException("Error ao pegar o nome do sistema operacional - " + e.getMessage(), e.getCause());
    }
    String Os = name + " x" + version;
    return Os;
  }
}
