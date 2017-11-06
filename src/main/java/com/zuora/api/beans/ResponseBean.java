package com.zuora.api.beans;


/*
 * Bean of a http response
 */


public  class ResponseBean {
    
	public String status;
	public String statusCode;   
	public String contentType;
	public String body;
	
	
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
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	@Override
	public String toString() {
		return "ResponseBean [status=" + status + ", statusCode=" + statusCode + ", contentType=" + contentType
				+ ", body=" + body + "]";
	}

	
        
   
}
