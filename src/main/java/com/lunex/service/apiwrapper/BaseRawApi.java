package com.lunex.service.apiwrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseRawApi {
	final static Logger logger = LoggerFactory.getLogger(BaseRawApi.class);
	protected String target = "";
	
	public BaseRawApi(String target) {
		this.target = target;
	}

	
}
