package com.lunex.service.apiwrapper;

import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseApi {
	final static Logger logger = LoggerFactory.getLogger(BaseApi.class);
	
	private Client client;
	private WebTarget target = null;
	private String sTarget = "";
	
	public void setTarget(String target) {
		this.sTarget = target;
		this.target = client.target(target).register(JacksonFeature.class);
		//ClientConfig clientConfig = new ClientConfig();
		//clientConfig.register(new LoggingFilter(logger, false));
	}
	
	public BaseApi() {
		this.client = ClientBuilder.newClient();
	}
	
	public BaseApi(String target) {
		this();
		this.setTarget(target);
	}
	
	public <T> T get(String path, String acceptType, 
			Map<String, String> queryParams, Class<T> responseObjType) {
		Response response = this.getInvocationBuilder(path, "GET", acceptType, queryParams).get();
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 post(String path, String contentType, String acceptType, 
			Map<String, String> queryParams, T2 contentObj, Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "POST", acceptType, queryParams)
				.post(Entity.entity(contentObj, contentType));
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 put(String path, String contentType, String acceptType, 
			Map<String, String> queryParams, T2 contentObj, Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "PUT", acceptType, queryParams)
				.put(Entity.entity(contentObj, contentType));
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 delete(String path, String acceptType, 
			Map<String, String> queryParams, Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "DELETE", acceptType, queryParams)
				.delete();
		return response.readEntity(responseObjType);
	}
	
	protected Invocation.Builder getInvocationBuilder(String path, String method, String acceptType, 
			Map<String, String> queryParams) {
		logger.debug(String.format("Request: %s %s/%s", method, this.sTarget, path));
		WebTarget resourceWebTarget = this.target.path(path);
		if (queryParams != null) {
			for(Entry<String, String> entry : queryParams.entrySet()) {
			    String key = entry.getKey();
			    String value = entry.getValue();
			    resourceWebTarget = resourceWebTarget.queryParam(key, value);
			}
		}
		
		Invocation.Builder invocationBuilder =
				resourceWebTarget.request(acceptType);
		
		return invocationBuilder;
	}
}
