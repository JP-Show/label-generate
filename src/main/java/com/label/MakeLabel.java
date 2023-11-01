package com.label;

import com.exceptions.myException;
import com.utils.Regx;

public class MakeLabel {
  String os;
  String cpu;
  String mb;
  String ram;
  String disk;
  String socket;

  public MakeLabel(String os, String cpu, String mb, String ram, String disk, String socket) throws myException {
    this.os = formattOS(os).toUpperCase();
    this.cpu = formattCPU(cpu).toUpperCase();
    this.mb = formattMb(mb).toUpperCase();
    this.ram = ram.toUpperCase();
    this.disk = disk.toUpperCase();
    this.socket = socket.toUpperCase();
  }

  private String formattCPU(String cpu) {
    String oldCPU = cpu;
    try {
      cpu = oldCPU.replaceAll("(?i)\\d-core[\\w ]*", "").trim();
      cpu = cpu.replaceAll("[\\(R\\)]?", "");
      cpu = cpu.replaceAll("CPU", "");
      cpu = cpu.replaceAll("@", "");
      cpu = cpu.trim();
    } catch (Exception e) {
    }
    return cpu;
  }

  private String formattMb(String mb) throws myException {
    String oldMb = mb;
    try {
      mb = Regx.cutString("([\\-\\w\\s]*)", oldMb).trim();

    } catch (Exception e) {
      throw new myException("Error ao formatar a Placa mãe - " + e.getMessage(), e.getCause());
    }
    return mb;
  }

  private String formattOS(String os) throws myException {
    String oldOs = os;
    try {
      os = Regx.cutString("(Windows [\\d\\s\\w]*)", oldOs);

    } catch (Exception e) {
      throw new myException("Error ao formatar o Sistema Operacional - " + e.getMessage(), e.getCause());
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
