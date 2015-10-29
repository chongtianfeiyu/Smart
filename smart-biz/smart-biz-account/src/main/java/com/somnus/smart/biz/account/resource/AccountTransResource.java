package com.somnus.smart.biz.account.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.AccountTransRequest;

/**
 *转账
 *
 * @author IH745
 * @version 1.0 13-10-15
 */
public interface AccountTransResource {
	/**
	 * 转账
	 * @param request
	 * @return
	 */
	public AccountResponse accountTrans(@Valid AccountTransRequest request) ;

}
