/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.biz.income.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.CancelReverseRequest;
import com.somnus.smart.message.account.DepositRequest;
import com.somnus.smart.message.account.IncomeRequest;
import com.somnus.smart.message.account.IpsPayRequest;

/**
 * 账户核心收单
 *
 * @author 李太平
 * @version 1.0 13-10-9
 */
public interface IncomeResource {
	/**
	 * 银行收单记账操作
	 * @param incomeRequest
	 * @return
	 */
	public AccountResponse bankIncome(@Valid IncomeRequest incomeRequest);
	
	/**
	 * 个人充值记账操作
	 * @param incomeRequest
	 * @return
	 */
	public AccountResponse deposit(@Valid DepositRequest depositRequest);
	
	/**
     * 撤销冲正记账操作
     * @param cancelReverseRequest
     * @return
     */
    public AccountResponse cancelReverse(@Valid CancelReverseRequest cancelReverseRequest);
    
    /**
     * 账户支付
     * 
     * @param request
     * @return
     */
    public AccountResponse ipsPay(IpsPayRequest request);

}
