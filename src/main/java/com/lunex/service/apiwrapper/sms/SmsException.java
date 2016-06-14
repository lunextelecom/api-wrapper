package com.lunex.service.apiwrapper.sms;

public class SmsException extends Exception {
  private static final long serialVersionUID = -5981228225367357014L;
  private int code;
  private String message;

  public int getCode() {
      return this.code;
  }

  @Override
  public String getMessage() {
      return this.message;
  }

  public SmsException() {

  }

  public SmsException(int code, String message) {
      this.code = code;
      this.message = message;
  }
}
