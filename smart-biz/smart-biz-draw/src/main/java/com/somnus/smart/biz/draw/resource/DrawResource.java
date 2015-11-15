package com.somnus.smart.biz.draw.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.BankDrawRequest;

/**
 * 提现
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
