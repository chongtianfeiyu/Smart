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

import com.somnus.smart.message.refusepay.RefusePayRequest;
import com.somnus.smart.message.refusepay.RefusePayResponse;

/**
 * 拒付
 * 
 * @author bo.zhang
 *
 */
public interface RefusePayResource {
	/**
	 * 拒付
	 * 
	 * @param request
	 * @return
	 */
	public RefusePayResponse refusePay(@Valid RefusePayRequest request);


}
