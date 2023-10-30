package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exceptions.myException;

public class Regx {

  public static String cutString(String regex, String text) throws Exception {
    String result = "unknown";
    try {
      Pattern patt = Pattern.compile(regex);

      Matcher match = patt.matcher(text);

      if (match.matches()) {
        result = match.group(1);
      }
    } catch (Exception e) {
      throw new myException("Error ao tentar capturar um texto específico" + e.getMessage(), e.getCause());
    }
    return result;

  }
}
