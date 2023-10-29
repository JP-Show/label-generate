package com.entities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class cpu {
  public void getName (){
    .getHardware().getProcessor().getProcessorIdentifier();
    if(si.getModel() == "uknown"){
      ProcessBuilder pb = new ProcessBuilder("wmic", "cpu", "get", "name");
      Process process = pb.start();

      InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      String[] line = (String[]) br.lines().toArray();
      

    }
  }
}
