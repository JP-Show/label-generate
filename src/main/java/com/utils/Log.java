package com.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {

  public static void createLogFile(String msg) {
    try (PrintWriter out = new PrintWriter(new FileWriter("log.txt", true))) {
      out.write(msg);
    } catch (IOException e) {
      System.out.println("Erro ao criar o log");
    }
  }
}
