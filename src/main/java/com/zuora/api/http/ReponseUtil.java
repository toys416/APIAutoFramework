package com.zuora.api.http;

import com.zuora.api.beans.ResponseBean;
import com.zuora.api.utils.LogHelper;

import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

/**
 * Convert response result from server to ResponseBean
 * @author wangjingzhou
 *
 */

public class ReponseUtil {

	private static final String TAG="ResponseUtil";
	private static ResponseBean responseBean=null;

	public static ResponseBean setResponseBean(CloseableHttpResponse httpResponse) {
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null)
			try {
				String responseString = EntityUtils.toString(entity, "utf-8");
				String rs = responseString.replace("\r\n", "");
				
				responseBean = new ResponseBean();
				responseBean.setStatus(httpResponse.getStatusLine().getReasonPhrase());
				responseBean.setStatusCode(Integer.toString(httpResponse.getStatusLine().getStatusCode()));
				responseBean.setBody(rs);
				
				String printStatus="Status:"+"\n"
									+responseBean.getStatus() + "\n"
									+ responseBean.getStatusCode() + "\n";
				
				String printBody="Body:" +"\n"
									+ rs + "\n";
				
				String printHeader="Header:" +"\n";
				HeaderIterator iterator = httpResponse.headerIterator();
				while (iterator.hasNext()) {
					printHeader +=iterator.next();
					printHeader+="\n";
				}
					
				LogHelper.info(TAG,"\n" + "***************************Print Response Start**********************************" + "\n"
						+ printStatus+"\r\n"
						+ printHeader+"\r\n"
						+ printBody+"\r\n"
						+ "***************************Print Response End**********************************");

			} catch (Exception e) {
				e.printStackTrace();
			}
		return responseBean;

	}

}
