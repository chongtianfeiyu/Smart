package com.somnus.smart.biz.draw.resource;

import javax.validation.Valid;

import com.somnus.smart.message.Message;
import com.somnus.smart.message.writeoff.DrawWriteOffRequest;

/**
 * 出款核销记账接口
 *
 * @author IH745
 * @version 1.0 13-12-05
 */
public interface DrawWriteOffResource {
	/**
	 * 出款核销
	 * 
	 * @param request
	 * @return
	 */
	public Message writeOff(@Valid DrawWriteOffRequest request) ;

}
