package com.zuora.api.beans;


public class DataProviderBean {

	String method; 
	String url;
	String param;
	String status;
	String statusCode;
	String desc;

	
	public DataProviderBean() {
	}
	
	public DataProviderBean(String method, String param, String status, String statusCode, String desc, String url) {
		super();
		this.method = method;
		this.url = url;
		this.param = param;
		this.status = status;
		this.statusCode = statusCode;
		this.desc = desc;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}

	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	@Override
	public String toString() {
		return "DataProviderBean [method=" + method + ", param=" + param + ", status=" + status + ", statusCode=" + statusCode
				+ ", desc=" + desc + "]";
	}
	
}