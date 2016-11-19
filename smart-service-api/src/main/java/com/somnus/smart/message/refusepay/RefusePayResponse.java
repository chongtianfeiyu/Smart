package com.somnus.smart.message.refusepay;

import java.util.Date;

import com.somnus.smart.message.Message;

public class RefusePayResponse extends Message {

	private static final long serialVersionUID = 1L;
	private String appTranNo;
	private String accTranNo;
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
