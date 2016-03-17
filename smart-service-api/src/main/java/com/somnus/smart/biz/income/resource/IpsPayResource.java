package com.somnus.smart.biz.income.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.IpsPayRequest;

/**
 * isp账户支付记账
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
