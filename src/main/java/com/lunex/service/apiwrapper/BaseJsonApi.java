package com.lunex.service.apiwrapper;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BaseJsonApi extends BaseApi {
	public BaseJsonApi(String target) {
		super(target);
	}
	
	public <T> T get(String path, Map<String, String> queryParams, 
			Class<T> responseObjType) {
		Response response = this.getInvocationBuilder(path, "GET", MediaType.APPLICATION_JSON, queryParams).get();
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 post(String path, Map<String, String> queryParams, 
			T2 contentObj, Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "POST", MediaType.APPLICATION_JSON, queryParams)
				.post(Entity.entity(contentObj, MediaType.APPLICATION_JSON));
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 put(String path, Map<String, String> queryParams, 
			T2 contentObj, Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "PUT", MediaType.APPLICATION_JSON, queryParams)
				.put(Entity.entity(contentObj, MediaType.APPLICATION_JSON));
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 delete(String path, Map<String, String> queryParams, 
			Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "DELETE", MediaType.APPLICATION_JSON, queryParams)
				.delete();
		return response.readEntity(responseObjType);
	}
}
