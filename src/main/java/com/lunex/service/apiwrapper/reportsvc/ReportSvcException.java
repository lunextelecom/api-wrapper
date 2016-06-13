package com.lunex.service.apiwrapper.reportsvc;

public class ReportSvcException extends Exception {
  private static final long serialVersionUID = -2351654290692092102L;
  private int code;
  private String message;

  public int getCode() {
      return this.code;
  }

  @Override
  public String getMessage() {
      return this.message;
  }

  public ReportSvcException() {

  }

  public ReportSvcException(int code, String message) {
      this.code = code;
      this.message = message;
  }
}
