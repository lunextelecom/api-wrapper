package com.lunex.service.apiwrapper;

import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BaseXmlApi extends BaseApi {
	public BaseXmlApi(String target) {
		super(target);
	}
	
	public <T> T get(String path, Map<String, String> queryParams, 
			Class<T> responseObjType) {
		Response response = this.getInvocationBuilder(path, "GET", MediaType.TEXT_XML, queryParams).get();
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 post(String path, Map<String, String> queryParams, 
			T2 contentObj, Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "POST", MediaType.TEXT_XML, queryParams)
				.post(Entity.entity(contentObj, MediaType.TEXT_XML));
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 put(String path, Map<String, String> queryParams, 
			T2 contentObj, Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "PUT", MediaType.TEXT_XML, queryParams)
				.put(Entity.entity(contentObj, MediaType.TEXT_XML));
		return response.readEntity(responseObjType);
	}
	
	public <T1, T2> T1 delete(String path, Map<String, String> queryParams, 
			Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "DELETE", MediaType.TEXT_XML, queryParams)
				.delete();
		return response.readEntity(responseObjType);
	}
}
