package com.clubproject.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;

import com.clubproject.config.security.jwt.JWTSecurityConstants;

public class HttpClientUtil {

	/**
	 * Ejecuta un request post y devuelve el resultado: status code y responseBody
	 * 
	 * @param url
	 * @param json_string
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static HttpClienteResponse executePostJson(String url, String json_string)
			throws HttpException, IOException {
		// Ejecutar POST
		final HttpClient httpClient = new HttpClient();
		final PostMethod postMethod = new PostMethod(url);

		StringRequestEntity requestEntity = new StringRequestEntity(json_string, MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_JSON_UTF8.getCharset().name());
		postMethod.setRequestEntity(requestEntity);

		// Log resultado
		int statusCode = httpClient.executeMethod(postMethod);
		String responseBody = StringUtils.replace(postMethod.getResponseBodyAsString(), "{}", "{ }");
		HttpClienteResponse httpClienteResponse = new HttpClienteResponse(statusCode, responseBody);
		return httpClienteResponse;
	}

	/**
	 * Ejecuta un request post y devuelve el resultado: status code y responseBody
	 * 
	 * @param url
	 * @param json_string
	 * @param tokenJWT
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static HttpClienteResponse executePostJWT(String url, String json_string, String tokenJWT)
			throws HttpException, IOException {
		// Ejecutar POST
		final HttpClient httpClient = new HttpClient();
		final PostMethod postMethod = new PostMethod(url);

		StringRequestEntity requestEntity = new StringRequestEntity(json_string, MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_JSON_UTF8.getCharset().name());
		postMethod.addRequestHeader(JWTSecurityConstants.HEADER_STRING, JWTSecurityConstants.TOKEN_PREFIX + tokenJWT);
		postMethod.setRequestEntity(requestEntity);

		// Log resultado
		int statusCode = httpClient.executeMethod(postMethod);
		String responseBody = StringUtils.replace(postMethod.getResponseBodyAsString(), "{}", "{ }");
		HttpClienteResponse httpClienteResponse = new HttpClienteResponse(statusCode, responseBody);
		return httpClienteResponse;
	}

	/**
	 * Ejecuta un request GET y devuelve el resultado: status code y responseBody
	 * 
	 * @param url
	 * @param tokenJWT
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static HttpClienteResponse executeGetJWT(String url, String tokenJWT) throws HttpException, IOException {
		// Ejecutar POST
		final HttpClient httpClient = new HttpClient();
		final GetMethod getMethod = new GetMethod(url);

		getMethod.addRequestHeader(JWTSecurityConstants.HEADER_STRING, JWTSecurityConstants.TOKEN_PREFIX + tokenJWT);

		// Log resultado
		int statusCode = httpClient.executeMethod(getMethod);
		String responseBody = StringUtils.replace(getMethod.getResponseBodyAsString(), "{}", "{ }");
		HttpClienteResponse httpClienteResponse = new HttpClienteResponse(statusCode, responseBody);
		return httpClienteResponse;
	}

	/**
	 * Ejecuta un request DELETE y devuelve el resultado: status code y responseBody
	 * 
	 * @param url
	 * @param tokenJWT
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static HttpClienteResponse executeDeleteJWT(String url, String tokenJWT) throws HttpException, IOException {
		// Ejecutar DELETE
		final HttpClient httpClient = new HttpClient();
		final DeleteMethod deleteMethod = new DeleteMethod(url);

		deleteMethod.addRequestHeader(JWTSecurityConstants.HEADER_STRING, JWTSecurityConstants.TOKEN_PREFIX + tokenJWT);

		// Log resultado
		int statusCode = httpClient.executeMethod(deleteMethod);
		String responseBody = StringUtils.replace(deleteMethod.getResponseBodyAsString(), "{}", "{ }");
		HttpClienteResponse httpClienteResponse = new HttpClienteResponse(statusCode, responseBody);
		return httpClienteResponse;
	}

	/**
	 * Ejecuta un request PUT y devuelve el resultado: status code y responseBody
	 * 
	 * @param url
	 * @param json_string
	 * @param tokenJWT
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static HttpClienteResponse executePutJWT(String url, String json_string, String tokenJWT)
			throws HttpException, IOException {
		// Ejecutar PUT
		final HttpClient httpClient = new HttpClient();
		final PutMethod putMethod = new PutMethod(url);

		StringRequestEntity requestEntity = new StringRequestEntity(json_string, MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_JSON_UTF8.getCharset().name());
		putMethod.addRequestHeader(JWTSecurityConstants.HEADER_STRING, JWTSecurityConstants.TOKEN_PREFIX + tokenJWT);
		putMethod.setRequestEntity(requestEntity);

		// Log resultado
		int statusCode = httpClient.executeMethod(putMethod);
		String responseBody = StringUtils.replace(putMethod.getResponseBodyAsString(), "{}", "{ }");
		HttpClienteResponse httpClienteResponse = new HttpClienteResponse(statusCode, responseBody);
		return httpClienteResponse;
	}
}