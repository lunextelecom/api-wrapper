package com.lunex.service.apiwrapper.posapi;

public class PosApiException extends Exception {
	private static final long serialVersionUID = -1796642131331852357L;
	private int code;
	private String message;
	
	public int getCode() {
		return this.code;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public PosApiException() {
		
	}
	
	public PosApiException(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
