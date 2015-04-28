/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.biz.refund.resource;

import javax.validation.Valid;

import com.somnus.smart.message.Message;
import com.somnus.smart.message.writeoff.RefundWriteOffRequest;

/**
 *	退款核销记账接口
 *
 * @author IH745
 * @version 1.0 13-12-05
 */
public interface RefundWriteOffResource {
	/**
	 * 退款核销记账
	 * 
	 * @param request
	 * @return
	 */
	public Message writeOff(@Valid RefundWriteOffRequest request) ;

}
