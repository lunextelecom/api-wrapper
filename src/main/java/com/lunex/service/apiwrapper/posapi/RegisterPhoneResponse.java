package com.lunex.service.apiwrapper.posapi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterPhoneResponse {
  @XmlElement(name="Code")
  @JsonProperty("Code")
  public int code;

  @XmlElement(name="Message")
  @JsonProperty("Message")
  public String message;

  @XmlElement(name="RegisterPhone")
  @JsonProperty("RegisterPhone")
  public RegisterPhone registerPhone;
}
