/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.message.account;

import java.util.Date;

import com.somnus.smart.message.Message;


/**
 * AccountResponse
 * 
 * @author IH745
 * @version 1.0 13-10-9
 */
public class AccountResponse extends Message {

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
