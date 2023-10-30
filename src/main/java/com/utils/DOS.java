package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DOS {
  public static List<String> exec(String[] command) throws IOException {
    List<String> list = new ArrayList<>();
    try {
      ProcessBuilder pb = new ProcessBuilder(command);
      Process process = pb.start();

      InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      Object[] listObjects = br.lines().toArray();

      for (Object item : listObjects) {
        if (!item.toString().equals("")) {
          list.add((String) item);
        }
      }
    } catch (Exception e) {
      throw new IOException("Error ao executar o DOS - " + e.getMessage(), e.getCause());
    }
    return list;
  }
}
