package com.lunex.service.apiwrapper.posapi;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@XmlElement(name="Code")
	@JsonProperty("Code")
	public int code;

	@XmlElement(name="Message")
	@JsonProperty("Message")
	public String message;

	@XmlElement(name="Time")
	@JsonProperty("Time")
	public Date time;
}
