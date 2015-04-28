/**
 * 
 */
package com.somnus.smart.base.domain;

import java.io.Serializable;

/**   
 * @Title: CoreAccountItems
 * @author: IH745
 * @date: 2013-10-8上午10:25:45
 * @version: 1.0  
 */
public class CoreAccountItems implements Serializable {
	
	private static final long serialVersionUID = 3543185512645909965L;
	
	private String reqMsgCode; 
	
	private String reqMsg;
	
	public String getReqMsgCode() {
		return reqMsgCode;
	}
	public void setReqMsgCode(String reqMsgCode) {
		this.reqMsgCode = reqMsgCode;
	}
	public String getReqMsg() {
		return reqMsg;
	}
	public void setReqMsg(String reqMsg) {
		this.reqMsg = reqMsg;
	} 
}
