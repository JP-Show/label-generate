package com.label;

public class MakeLabel {
  String os;
  String cpu;
  String mb;
  String ram;
  String disk;

  public MakeLabel(String os, String cpu, String mb, String ram, String disk) {
    this.os = os;
    this.cpu = cpu;
    this.mb = mb;
    this.ram = ram;
    this.disk = disk;
  }

  public String getLabel() {
    return "";
  }
}
