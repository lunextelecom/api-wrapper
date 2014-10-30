package com.lunex.service.apiwrapper;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseRawJsonApi extends BaseRawApi {
	final static Logger logger = LoggerFactory.getLogger(BaseRawJsonApi.class);
	private ObjectMapper mapper = new ObjectMapper();

	public BaseRawJsonApi(String target) {
		super(target);
	}

	public <T> T get(String path, String acceptType,
			Map<String, String> queryParams, Class<T> responseObjType) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		T obj = null;
		try {
			HttpGet httpAction = new HttpGet(this.target + path);
			httpAction.setHeader("Accept", acceptType);
			httpResponse = httpClient.execute(httpAction);
			String sJsonResponse = EntityUtils.toString(httpResponse
					.getEntity());
			obj = this.mapper.readValue(sJsonResponse, responseObjType);
			httpClient.close();
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

	public <T1, T2> T1 post(String path, String contentType, String acceptType,
			Map<String, String> queryParams, T2 contentObj,
			Class<T1> responseObjType) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = null;
		String sJsonRequest = null;
		T1 obj = null;
		try {
			sJsonRequest = mapper.writeValueAsString(contentObj);

			HttpPost httpAction = new HttpPost(this.target + path);
			StringEntity entity = new StringEntity(sJsonRequest);
			entity.setContentType(contentType);
			httpAction.setHeader("Accept", acceptType);
			httpAction.setEntity(entity);
			httpResponse = httpClient.execute(httpAction);
			String sJsonResponse = EntityUtils.toString(httpResponse
					.getEntity());
			obj = this.mapper.readValue(sJsonResponse, responseObjType);
			httpClient.close();
		} catch (JsonProcessingException e1) {
			logger.error(e1.getMessage(), e1);
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
			Map<String, String> queryParams, T2 contentObj,
			Class<T1> responseObjType) {
		return null;
	}

	public <T1, T2> T1 delete(String path, String acceptType,
			Map<String, String> queryParams, Class<T1> responseObjType) {
		return null;
	}
}
