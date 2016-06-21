package com.lunex.service.apiwrapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseApi {
	final static Logger logger = LoggerFactory.getLogger(BaseApi.class);
	private ObjectMapper mapper = new ObjectMapper();

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

	private <T> T getByHttpClient(String path, String acceptType, Map<String, String> queryParams, Class<T> responseObjType) {
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    CloseableHttpResponse httpResponse = null;
	    T obj = null;
	    try {
	        HttpGet httpAction = new HttpGet(this.sTarget + path);
	        httpAction.setHeader("Accept", acceptType);
	        httpResponse = httpClient.execute(httpAction);
	        if (acceptType.equals(MediaType.APPLICATION_JSON)) {
	        	String sJsonResponse = EntityUtils.toString(httpResponse.getEntity());
	        	obj = this.mapper.readValue(sJsonResponse, responseObjType);
	        } else if (acceptType.equals(MediaType.APPLICATION_XML)) {
	        	JAXBContext jc = JAXBContext.newInstance(responseObjType);
		        Unmarshaller unmarshaller = jc.createUnmarshaller();
		        InputStream stream = httpResponse.getEntity().getContent();

		        obj = (T) unmarshaller.unmarshal(stream);
	        }
	        
	    } catch (Exception ex) {
	        logger.error(ex.getMessage(), ex);
	    } finally {
	        try {
	            httpClient.close();
	        } catch (IOException e) {
	            logger.error(e.getMessage(), e);
	        }
	        try {
	            if (httpResponse != null) {
	                httpResponse.close();
	            }
	        } catch (IOException e) {
	            logger.error(e.getMessage(), e);
	        }
	    }
	    return obj;
	}
	
	public <T> T getJson(String path, Map<String, String> queryParams, Class<T> responseObjType) {
		return this.getByHttpClient(path, MediaType.APPLICATION_JSON, queryParams, responseObjType);
	}
	
	public <T> T getXml(String path, Map<String, String> queryParams, Class<T> responseObjType) {
		return this.getByHttpClient(path, MediaType.APPLICATION_XML, queryParams, responseObjType);
	}

	public <T1, T2> T1 post(String path, String contentType, String acceptType,
			Map<String, String> queryParams, T2 contentObj, Class<T1> responseObjType) {
		Response response = this.getInvocationBuilder(path, "POST", acceptType, queryParams)
				.post(Entity.entity(contentObj, contentType));
		return response.readEntity(responseObjType);
	}

	public <T> T postXml(String path, Map<String, String> queryParams, String data, Class<T> responseObjType) {
	    CloseableHttpClient httpClient = HttpClients.createDefault();
	    CloseableHttpResponse httpResponse = null;
	    T obj = null;
	    try {
	        HttpPost httpAction = new HttpPost(this.sTarget + path);
	        httpAction.setHeader("Accept", MediaType.TEXT_XML);
	        HttpEntity entity = new ByteArrayEntity(data.getBytes("UTF-8"));
	        httpAction.setEntity(entity);
	        httpResponse = httpClient.execute(httpAction);

	        //String sXmlResponse = EntityUtils.toString(httpResponse.getEntity());
	        //StringReader stream = new StringReader(sXmlResponse);

	        JAXBContext jc = JAXBContext.newInstance(responseObjType);
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        InputStream stream = httpResponse.getEntity().getContent();

	        obj = (T) unmarshaller.unmarshal(stream);
	    } catch (Exception ex) {
	        logger.error(ex.getMessage(), ex);
	    } finally {
	        try {
	            httpClient.close();
	        } catch (IOException e) {
	            logger.error(e.getMessage(), e);
	        }
	        try {
	            if (httpResponse != null) {
	                httpResponse.close();
	            }
	        } catch (IOException e) {
	            logger.error(e.getMessage(), e);
	        }
	    }
	    return obj;
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
