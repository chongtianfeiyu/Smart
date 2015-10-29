/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.biz.custom.resource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.custom.BuckleDrawRequest;

/**
 * 扣划
 *
 * @author IH745
 */
public interface BuckleDrawResource {
	
	/**
	 * 扣划
     *
	 * @param request
	 * @return
	 */
	AccountResponse buckleDraw(@Valid @NotNull BuckleDrawRequest request);

}
