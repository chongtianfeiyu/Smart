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

import com.somnus.smart.message.account.ProtocolDrawRequest;
import com.somnus.smart.message.account.ProtocolDrawResponse;

/**
 *	协议出款
 *
 * @author IH745
 * @version 1.0 13-10-13
 */
public interface ProtocolDrawResource {
	/**
	 * 协议出款
	 * 
	 * @param request
	 * @return
	 */
	public ProtocolDrawResponse protocolDraw(@Valid ProtocolDrawRequest request) ;

}
