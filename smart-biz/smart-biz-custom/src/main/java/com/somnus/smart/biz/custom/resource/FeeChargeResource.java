package com.somnus.smart.biz.custom.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.custom.FeeChargeRequest;

/**
 * 费用收取记账服务
 */
public interface FeeChargeResource {
	
	/**
	 * 交易手续费收取记账接口
	 * @param request
	 * @return
	 */
	public AccountResponse charge(@Valid FeeChargeRequest request);
	
	/**
	 * 非交易手续费收取记账接口
	 * @param request
	 * @return
	 */
	public AccountResponse unFeeCharge(@Valid FeeChargeRequest request);

}
