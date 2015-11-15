package com.somnus.smart.biz.draw.resource;

import javax.validation.Valid;

import com.somnus.smart.message.refusepay.RefusePayRequest;
import com.somnus.smart.message.refusepay.RefusePayResponse;

/**
 * 拒付
 */
public interface RefusePayResource {
	/**
	 * 拒付
	 * 
	 * @param request
	 * @return
	 */
	public RefusePayResponse refusePay(@Valid RefusePayRequest request);


}
