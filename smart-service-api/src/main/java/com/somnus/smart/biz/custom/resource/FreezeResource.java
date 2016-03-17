package com.somnus.smart.biz.custom.resource;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.somnus.smart.message.Message;
import com.somnus.smart.message.custom.AccountFreezeRequest;
import com.somnus.smart.message.custom.TranFreezeRequest;

/**
 * 冻结
 */
public interface FreezeResource {
	
	/**
	 * 账户冻结
	 * @param request
	 * @return
	 */
	Message accountFreeze(@Valid @NotNull AccountFreezeRequest request);

	/**
	 * 交易冻结
	 * @param request
	 * @return
	 */
	Message tranFreeze(@Valid @NotNull TranFreezeRequest request);
}
