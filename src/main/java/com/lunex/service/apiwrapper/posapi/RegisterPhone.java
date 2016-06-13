package com.lunex.service.apiwrapper.posapi;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RegisterPhone")
public class RegisterPhone {
  @XmlElement(name="AccessPhone")
  public String accessPhone;
  @XmlElement(name="Created")
  public Date created;
  @XmlElement(name="CreatedBy")
  public String createdBy;
  @XmlElement(name="Description")
  public String description;
  @XmlElement(name="IsMain")
  public Boolean isMain;
  @XmlElement(name="Language")
  public String language;
  @XmlElement(name="Phone")
  public String phone;
  @XmlElement(name="PhoneType")
  public String phoneType;
  @XmlElement(name="Region")
  public String region;
}
