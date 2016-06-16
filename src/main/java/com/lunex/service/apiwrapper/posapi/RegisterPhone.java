package com.lunex.service.apiwrapper.posapi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="RegisterPhone")
public class RegisterPhone {
  @XmlElement(name="AccessPhone")
  @JsonProperty("AccessPhone")
  public String accessPhone;

  @XmlElement(name="Created")
  @JsonProperty("Created")
  public String created;

  @XmlElement(name="CreatedBy")
  @JsonProperty("CreatedBy")
  public String createdBy;

  @XmlElement(name="Description")
  @JsonProperty("Description")
  public String description;

  @XmlElement(name="IsMain")
  @JsonProperty("IsMain")
  public Boolean isMain;

  @XmlElement(name="Language")
  @JsonProperty("Language")
  public String language;

  @XmlElement(name="Phone")
  @JsonProperty("Phone")
  public String phone;

  @XmlElement(name="PhoneType")
  @JsonProperty("PhoneType")
  public String phoneType;

  @XmlElement(name="Region")
  @JsonProperty("Region")
  public String region;
}
