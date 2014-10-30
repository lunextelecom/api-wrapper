package com.lunex.service.apiwrapper.infobip;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "hlr")
public class Hlr {
	@XmlElement
	public String destination;
	@XmlElement
	public String id;
	@XmlElement
	public String stat;
	@JsonProperty("IMSI")
	@XmlElement(name = "IMSI")
	public String imsi;
	@XmlElement
	public int err;
	@XmlElement
	public String orn;
	@XmlElement
	public String pon;
	@XmlElement
	public String mccmnc;
	@XmlElement
	public String ppm;
	@XmlElement
	public String onp;
	@XmlElement
	public String ocn;
	@XmlElement
	public int ocp;
	@JsonProperty("is_ported")
	@XmlElement(name = "is_ported")
	public boolean isPorted;
	@XmlElement
	public String pnp;
	@XmlElement
	public String pcn;
	@XmlElement
	public int pcp;
}
