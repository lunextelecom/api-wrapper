package com.lunex.service.apiwrapper.infobip;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "hlr")
public class Hlr {
	@XmlElement
	public String destination;
	@XmlElement
	public String id;
	@XmlElement
	public String stat;
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
	@XmlElement(name = "is_ported")
	public boolean isPorted;
	@XmlElement(name = "pnp")
	public String pnp;
	@XmlElement(name = "pcn")
	public String pcn;
	@XmlElement(name = "pcp")
	public int pcp;
}
