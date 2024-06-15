package com.hardware;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.odf.Report;
import com.utils.DOS;
import com.utils.Log;

public class Socket extends Thread {
  public String pathSK;
  public String name = "";

  @Override
  public void run() {
    name = name();
  }

  public String name() {
    String socket = "unknown";
    try {
      socket = getSocketBySocketInfo();
      if (socket == "unknown") {
        File file = new File(pathSK);
        File[] files = file.listFiles();
        socket = getSocketByReport(files);
      }
      if (socket == "unknown")
        Log.createLogFile("Error pegar uma linha no relatorio");
    } catch (Exception e) {
      Log.createLogFile("Error pegar o socket - " + e.getMessage());
      System.out.println("Error pegar o socket");
    }

    return socket;
  }

  private static String getSocketBySocketInfo() {
    String socket = "unknown";
    try {
      List<String> resultDOSocket = DOS.exec(new String[] { "cmd.exe", "/c", "win-x86\\publish\\SocketInfo.exe" });
      if (!resultDOSocket.get(0).contains("SOCKET"))
        socket = resultDOSocket.get(0);
      if (socket == "unknown")
        Log.createLogFile("Error pegar o socket no programa - ");
    } catch (Exception e) {
      Log.createLogFile("Error pegar o socket no programa - " + e.getMessage());
      System.out.println("Error pegar o socket no programa :(");
    }

    return socket;
  }

  private static String getSocketByReport(File[] files) {
    String socket = "unknown";
    try {
      for (File line : files) {
        if (line.toString().contains("txt")) {
          FileReader fr = new FileReader(line);
          String socket2 = Report.pickOne(fr, "-[ CPUID ]-", "-[ Placa mãe ]-",
              "Identificador da plataforma");
          System.out.println(socket2);
          // if (socket2 == "unknown")
          // Log.createLogFile("Error pegar o socket no programa - ");
          socket = socket2;
        }
      }
    } catch (Exception e) {
      Log.createLogFile("Error pegar o socket no arquivo- " + e.getMessage());
      System.out.println("não conseguiu pegar o socket no arquivo");
    }
    return socket;
  }
}
