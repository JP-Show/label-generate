package com.entities;

import java.io.IOException;
import java.util.List;

import com.exceptions.myException;
import com.utils.DOS;
import com.utils.Sysinfo;

import oshi.hardware.CentralProcessor.ProcessorIdentifier;

public class Cpu {
  public static String getName () throws myException, IOException {
    String cpu = "unknown";
    try {
      ProcessorIdentifier pi = Sysinfo.info().getHardware().getProcessor().getProcessorIdentifier();
      if(pi.getModel() == "unknown"){
         List<String> resultDOS = DOS.exec(new String[] {"wmic", "baseboard", "get", "product"});
        cpu = resultDOS.get(0);
      }else{
       cpu = pi.getName();
      }
    }catch (myException e) {
      throw new myException("error ao pegar nome da CPU - " + e.getMessage(), e.getCause());
    }catch(IOException e){
      throw new IOException("error ao pegar nome da CPU - " + e.getMessage(), e.getCause());
    }
    return cpu.replaceAll("(?i)\\d-core[\\w ]*", "").trim();
  }
}
