package com.somnus.smart.biz.meracc.resource;

import javax.validation.Valid;

import com.somnus.smart.message.Message;
import com.somnus.smart.message.meracct.AccountAllowInOrOutRequest;

/**
 * 账户出入款状态设置
 */
public interface AccountAllowInOrOutResource {
	
	/**
	 * 账户出入款状态设置
	 * @param request
	 * @return
	 */
	Message accountAllowInOrOut(@Valid AccountAllowInOrOutRequest request);

}
