package com.lunex.service.apiwrapper.posapi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
public class RegisterPhoneResponse extends Response {
  @XmlElement(name="RegisterPhone")
  public RegisterPhone registerPhone;
}
