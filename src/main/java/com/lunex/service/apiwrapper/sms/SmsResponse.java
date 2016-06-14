package com.lunex.service.apiwrapper.sms;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
public class SmsResponse {
  @XmlElement(name="Message")
  public String message;

  @XmlElement(name="Code")
  public int code;

}
