package com.label;

import com.exceptions.myException;
import com.utils.Regx;

public class MakeLabel {
  String os;
  String cpu;
  String mb;
  String ram;
  String disk;

  public MakeLabel(String os, String cpu, String mb, String ram, String disk) throws myException {
    this.os = formattOS(os);
    this.cpu = formattCPU(cpu);
    this.mb = formattMb(mb);
    this.ram = ram;
    this.disk = disk;
  }

  private String formattCPU(String cpu) {
    String oldCPU = cpu;
    try {
      cpu = oldCPU.replaceAll("(?i)\\d-core[\\w ]*", "").trim();

    } catch (Exception e) {
    }
    return cpu;
  }

  private String formattMb(String mb) throws myException {
    String oldMb = mb;
    try {
      mb = Regx.cutString("([\\-\\w\\s]*)", oldMb);

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

    sb.append("SISTEMA: " + this.os.toUpperCase());
    sb.append("\nPLACA MÃE: " + this.mb.toUpperCase());
    sb.append("\nPROCESSADOR: " + this.cpu.toUpperCase());
    sb.append("\nMEMÓRIA: " + this.ram.toUpperCase());
    sb.append("\nDISCO: " + this.disk.toUpperCase());

    return sb.toString();
  }
}
