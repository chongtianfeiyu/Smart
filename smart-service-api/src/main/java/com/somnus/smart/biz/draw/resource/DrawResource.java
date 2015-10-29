/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.biz.draw.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.BankDrawRequest;

/**
 * 提现
 *
 * @author IH745
 * @version 1.0 13-10-13
 */
public interface DrawResource {
	/**
	 * 提现
	 * 
	 * @param bankDrawRequest
	 * @return
	 */
	public AccountResponse bankDraw(@Valid BankDrawRequest bankDrawRequest) ;

}
