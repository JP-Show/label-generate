package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regx {

  public static String cutString(String regex, String text) {
    String result = "unknown";
    try {
      Pattern patt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
      Matcher match = patt.matcher(text);

      if (match.find()) {
        result = match.group();
      }
    } catch (Exception e) {
      Log.createLogFile("\"Error ao tentar capturar um texto específico - " + e.getMessage());
      System.out.println("\"Error ao tentar capturar um texto específico - ");
    }
    return result;

  }
}
