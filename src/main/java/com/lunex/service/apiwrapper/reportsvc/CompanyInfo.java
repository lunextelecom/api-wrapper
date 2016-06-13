package com.lunex.service.apiwrapper.reportsvc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class CompanyInfo {

  @JsonProperty("CsPhone")
  public String csPhone;
  @JsonProperty("HomeUrl")
  public String homeUrl;
  @JsonProperty("Name")
  public String name;
  @JsonProperty("Phone")
  public String phone;

  @Override
  public String toString() {
    return (new Gson()).toJson(this);
  }
}
