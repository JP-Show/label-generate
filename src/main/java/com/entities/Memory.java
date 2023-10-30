package com.entities;

import java.util.ArrayList;
import java.util.List;

import com.exceptions.myException;
import com.utils.Sysinfo;

import oshi.hardware.PhysicalMemory;

public class Memory {
  private static List<Integer> getMemoryList ()throws myException{
    List<Integer> listMemory = new ArrayList<>();
    try {
      List<PhysicalMemory> listPH = Sysinfo.info().getHardware().getMemory().getPhysicalMemory();
      for(PhysicalMemory memory : listPH){
        double cap = memory.getCapacity() * 0.000000001;
        int mem = (int) Math.floor(cap);
        listMemory.add(mem);
      }
    } catch (myException e) {
      listMemory.add(0);
      throw new myException("Error ao capturar a lista de Memórias - " + e.getMessage(), e.getCause());
    }
    return listMemory;
  }

  private List<Ram> addRamToList (List<Integer>listMemory){
    List<Ram> listRam = new ArrayList<>();
    for(int mem : listMemory){
      int staticSize = listRam.size();
      if(listRam.size() == 0){
        Ram ram = new Ram(1, mem);
        listRam.add(ram);
      }
      if(staticSize > 0){
        for(int i = 1; i <= staticSize; i++ ){
          if(listRam.get(i - 1).ram == mem){
            listRam.get(i- 1).setQnt(1);
            break;
          }
          if(i == staticSize ){
            Ram ram = new Ram(1, mem);
            listRam.add(ram);
          } 
        }
      }
    }
    return listRam;
  }

  private List<Ram> buildRam() throws myException{
    List<Integer> listMemory = getMemoryList();
    List<Ram> listRam = addRamToList(listMemory);
    return listRam;
  }

  public String getName () throws myException{
    List<Ram> listRam = buildRam();
    StringBuilder sb = new StringBuilder("");

    for(Ram ram : listRam){
    sb.append(ram.qnt)
    } 
  }
}

class Ram { 
  int qnt = 1;
  int ram;

  public Ram() {}

  public Ram(int qnt, int ram) {
    this.qnt = qnt;
    this.ram = ram;
  }

  public int getQnt() {
    return qnt;
  }
  public void setQnt(int qnt) {
    this.qnt += qnt;
  }
  public int getRam() {
    return ram;
  }
  public void setRam(int ram) {
    this.ram = ram;
  }

  
}