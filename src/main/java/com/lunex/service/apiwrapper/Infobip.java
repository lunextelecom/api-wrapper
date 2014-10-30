package com.lunex.service.apiwrapper;

//import java.util.HashMap;
//import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.lunex.service.apiwrapper.infobip.Hlr;

public class Infobip extends BaseRawJsonApi {
	String user;
	String pass;

	public Infobip(String target) {
		super(target);
		this.user = "lunex2013";
		this.pass = "vancouver";
	}

	public Infobip(String target, String user, String pass) {
		super(target);
		this.user = user;
		this.pass = pass;
	}

	public Hlr getHrl(String phone) {
		// Map<String, String> param = new HashMap<String, String>();
		// param.put("user", this.user);
		// param.put("pass", this.pass);
		// param.put("destination", phone);
		// param.put("output", "json");
		return this.get("/api/hlr/sync?user=" + this.user + "&pass="
				+ this.pass + "&destination=" + phone + "&output=json",
				MediaType.APPLICATION_JSON, null, Hlr.class);
	}
}
