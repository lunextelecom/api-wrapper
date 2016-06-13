package com.lunex.service.apiwrapper.reportsvc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyInfoResponse {

  @JsonProperty("Code")
  public int code;

  @JsonProperty("Message")
  public String message;

  @JsonProperty("HasError")
  public boolean hasError;

  @JsonProperty("CompanyInfo")
  public CompanyInfo companyInfo;
}
