/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.biz.draw.service;

import java.util.Date;
import java.util.List;

import com.somnus.smart.base.domain.MerAccount;
import com.somnus.smart.base.domain.TrnTransfer;
import com.somnus.smart.message.account.ProtocolDrawRequest;


/**
 *协议出款
 *
 * @author IH745
 * @version 1.0 13-10-18
 */
public interface ProtocolDrawService {

	/**
	 * 查询所有协议出款账户
	 * @return
	 */
	List<MerAccount> selectAllProtocolDrawAccounts();
	
	/**
	 * 特定商户协议划款
	 * @param merAccCode
	 * @param accDate
	 * @throws Exception 
	 */
	void protocolSpecificDraw(String merAccCode, Date accDate) throws Exception;
	/**
	 * 协议划款流水落地
	 * @param request
	 */
	String protocolTransfer(ProtocolDrawRequest request);
	/**
	 * 根据协议划款流水划款
	 * @param trnTransfer
	 * @param accDate
	 * @throws Exception 
	 */
	void protocolDraw(TrnTransfer trnTransfer, Date accDate) throws Exception;
	/**
	 * 更新划款流水
	 * @param trnTransfer
	 */
	void update(TrnTransfer trnTransfer);

	List<TrnTransfer> selectProtocolTransfer(TrnTransfer trnTransferQuery);
	
	String selectTransferBatchNo(TrnTransfer trnTransferQuery);

}
