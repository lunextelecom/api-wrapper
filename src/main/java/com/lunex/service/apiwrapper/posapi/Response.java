package com.lunex.service.apiwrapper.posapi;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class Response {
	@XmlElement(name="Code")
	public int code;
	@XmlElement(name="Message")
	public String message;
	@XmlElement(name="Time")
	public Date time;
}
