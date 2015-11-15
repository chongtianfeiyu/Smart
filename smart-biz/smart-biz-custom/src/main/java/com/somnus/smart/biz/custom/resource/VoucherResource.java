package com.somnus.smart.biz.custom.resource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.somnus.smart.message.voucher.VoucherEnterRequest;
import com.somnus.smart.message.voucher.VoucherEnterResponse;

/**
 * 凭证记账
 */
public interface VoucherResource {
	/**
	 * 凭证录入记账
	 * @param request
	 * @return
	 */
	public VoucherEnterResponse voucherEnter(@Valid @NotNull VoucherEnterRequest request) ;

}
