package com.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.exceptions.myException;
import com.utils.Sysinfo;

import oshi.hardware.CentralProcessor.ProcessorIdentifier;

public class Cpu {
  public static String getName (){
    String cpu = "unknown";
    try {
      ProcessorIdentifier pi = Sysinfo.info().getHardware().getProcessor().getProcessorIdentifier();
      if(pi.getModel() == "unknown"){
        ProcessBuilder pb = new ProcessBuilder("wmic", "cpu", "get", "name");
        Process process = pb.start();

        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String[] line = (String[]) br.lines().toArray();
        cpu = line[0];
      }else{
       cpu = pi.getName();
      }
    }catch (myException e) {
      System.out.println("error ao pegar nome da CPU - " + e.getCause());
    }catch(IOException e){
      System.out.println("error ao pegar nome da CPU - " + e.getCause());
    }
    return cpu;
  }
}
