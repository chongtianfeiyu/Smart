package com.somnus.smart.biz.refund.resource;

import javax.validation.Valid;

import com.somnus.smart.message.Message;
import com.somnus.smart.message.writeoff.RefundWriteOffRequest;

/**
 *	退款核销记账接口
 */
public interface RefundWriteOffResource {
	/**
	 * 退款核销记账
	 * 
	 * @param request
	 * @return
	 */
	public Message writeOff(@Valid RefundWriteOffRequest request) ;

}
