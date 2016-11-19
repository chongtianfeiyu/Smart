package com.somnus.smart.biz.custom.resource;

import javax.validation.Valid;

import com.somnus.smart.message.reticket.ReticketRequest;
import com.somnus.smart.message.reticket.ReticketResponse;

/**
 * 退票服务
 */
public interface ReticketResource {
	
	/**
	 * 退票
	 * @param request
	 * @return
	 */
	ReticketResponse returnTicket(@Valid ReticketRequest request);

}
