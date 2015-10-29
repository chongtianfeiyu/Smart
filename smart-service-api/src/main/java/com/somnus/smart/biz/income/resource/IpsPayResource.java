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
import com.somnus.smart.message.account.IpsPayRequest;

/**
 * IPS账户支付记账
 *
 * @author IH745
 * @version 1.0 13-10-15
 */
public interface IpsPayResource {
	/**
	 * 账户支付操作
	 * 
	 * @param request
	 * @return
	 */
	public AccountResponse ipsPay(@Valid IpsPayRequest request) ;

}
