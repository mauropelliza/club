package com.clubproject.util;

public class HttpClienteResponse {

	private int statusCode;

	private String responseBody;

	public HttpClienteResponse(int statusCode, String responseBody) {
		super();
		this.statusCode = statusCode;
		this.responseBody = responseBody;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public String toString() {
		return "statusCode: " + statusCode + " - responseBody: " + responseBody;
	}

}