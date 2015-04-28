package com.somnus.smart.message.reticket;

import java.util.Date;

import com.somnus.smart.message.Message;

public class ReticketResponse extends Message {
	
	/**应用交易流水号*/
	private String appTranNo;
	/**账务流水号*/
	private String accTranNo;
	/**账务日期*/
	private Date accDate;
	
	public String getAppTranNo() {
		return appTranNo;
	}
	public void setAppTranNo(String appTranNo) {
		this.appTranNo = appTranNo;
	}
	public String getAccTranNo() {
		return accTranNo;
	}
	public void setAccTranNo(String accTranNo) {
		this.accTranNo = accTranNo;
	}
	public Date getAccDate() {
		return accDate;
	}
	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}
}
