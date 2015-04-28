package com.somnus.smart.biz.custom.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.custom.PurchaseExchangeRequest;
import com.somnus.smart.message.custom.PurchaseWriteOffRequest;
import com.somnus.smart.message.custom.SettlementExchangeRequest;
import com.somnus.smart.message.custom.SettlementWriteOffRequest;

/**
 * 结/购汇服务
 * @author bo.zhang
 *
 */
public interface ForeignExchangeResource {
	
	/**
	 * 结汇记账接口
	 * @param request
	 * @return
	 */
	public AccountResponse settlementExchange(@Valid SettlementExchangeRequest request);
	
	/**
	 * 结汇核销记账接口
	 * @param request
	 * @return
	 */
	public AccountResponse settlementWriteOff(@Valid SettlementWriteOffRequest request);
	
	/**
	 * 购汇记账接口
	 * @param request
	 * @return
	 */
	public AccountResponse purchaseExchange(@Valid PurchaseExchangeRequest request);
	
	/**
	 * 购汇核销记账接口
	 * @param request
	 * @return
	 */
	public AccountResponse purchaseWriteOff(@Valid PurchaseWriteOffRequest request);

}
