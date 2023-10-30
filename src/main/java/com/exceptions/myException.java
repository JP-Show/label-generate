package com.exceptions;

public class myException extends Exception {
  public myException(String msg) {
    super(msg);
  }

  public myException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
