package com.somnus.smart.biz.custom.resource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.custom.BuckleDrawRequest;

/**
 * 扣划
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
