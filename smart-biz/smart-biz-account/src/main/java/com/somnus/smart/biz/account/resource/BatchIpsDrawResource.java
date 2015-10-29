package com.somnus.smart.biz.account.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.BatchIpsDrawRequest;

/**
 *下发Ips
 *
 * @author IH745
 * @version 1.0 13-10-15
 */
public interface BatchIpsDrawResource {
	/**
	 * 
	 * @param request
	 * @return
	 */
	public AccountResponse batchIpsDraw(@Valid BatchIpsDrawRequest request) ;

}
