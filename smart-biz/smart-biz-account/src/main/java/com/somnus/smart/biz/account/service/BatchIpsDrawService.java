/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.biz.account.service;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.BatchIpsDrawRequest;

/**
 *转账
 *
 * @author IH745
 * @version 1.0 13-10-18
 */
public interface BatchIpsDrawService {

	/**
	 * 交易记账请求参数
	 */
    void checkAccountRequest(BatchIpsDrawRequest request) throws Exception;
    /**
     * 创建记账交易流水
     * 
     * @param request
     * @return
     */
    Transaction createTransaction(BatchIpsDrawRequest request);
    /**
     * 
     * 
     * @param request
     * @param trntransaction
     * @throws Exception
     */
    void batchIpsDrawSynAccount(BatchIpsDrawRequest request, Transaction trntransaction) throws Exception;


}
