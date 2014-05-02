package com.lunex.service.apiwrapper.posapi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
public class AccountResponse extends Response {
	@XmlElement(name="Account")
	public Account account;
}
