package com.label;

import com.utils.Log;
import com.utils.Regx;

public class MakeLabel {
  String os;
  String cpu;
  String mb;
  String ram;
  String disk;
  String socket;

  public MakeLabel(String os, String cpu, String mb, String ram, String disk, String socket) {
    this.os = formatOS(os).toUpperCase();
    this.cpu = formatCPU(cpu).toUpperCase();
    this.mb = formatMb(mb).toUpperCase();
    this.ram = ram.toUpperCase();
    this.disk = disk.toUpperCase();
    this.socket = formatSocket(socket).toUpperCase();
  }

  private String formatCPU(String cpu) {
    String oldCPU = cpu;
    try {
      cpu = oldCPU.replaceAll("(?i)\\d-core[\\w ]*", "").trim();
      cpu = cpu.replaceAll("(\\(R\\))?", "");
      cpu = cpu.replaceAll("CPU", "");
      cpu = cpu.replaceAll("@", "");
      cpu = cpu.trim();
    } catch (Exception e) {
    }
    return cpu;
  }

  private String formatSocket(String socket) {
    String oldSocket = socket;
    try {
      if (socket.length() > 10)
        return socket;

      socket = Regx.cutString("LGA\\d{3,4}|AM\\d|FM\\d ", oldSocket).trim();

    } catch (Exception e) {
      Log.createLogFile("Error ao formatar o socket -  " + e.getMessage());
      System.out.println("Error ao formatar o socket - ");

    }
    return socket;
  }

  private String formatMb(String mb) {
    String oldMb = mb;
    try {
      mb = Regx.cutString("([\\-\\w\\s]*)", oldMb).trim();

    } catch (Exception e) {
      Log.createLogFile("Error ao formatar a Placa mãe -  " + e.getMessage());
      System.out.println("Error ao formatar a Placa mãe - ");
    }
    return mb;
  }

  private String formatOS(String os) {
    String oldOs = os;
    try {
      os = Regx.cutString("(Windows [\\d\\s\\w]*)", oldOs);

    } catch (Exception e) {
      Log.createLogFile("Error ao formatar o Sistema Operacional - " + e.getMessage());
      System.out.println("Error ao formatar o Sistema Operacional - ");
    }
    return os;
  }

  public String getLabel() {
    StringBuilder sb = new StringBuilder();

    sb.append("SISTEMA: " + this.os);
    sb.append("\nPLACA MÃE: " + this.mb + " SOCKET = " + this.socket);
    sb.append("\nPROCESSADOR: " + this.cpu);
    sb.append("\nMEMÓRIA: " + this.ram);
    sb.append("\nDISCO: " + this.disk);

    return sb.toString();
  }
}
