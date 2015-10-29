package com.somnus.smart.biz.draw.resource;

import javax.validation.Valid;

import com.somnus.smart.message.account.ProtocolDrawRequest;
import com.somnus.smart.message.account.ProtocolDrawResponse;

/**
 *	协议出款
 *
 * @author IH745
 * @version 1.0 13-10-13
 */
public interface ProtocolDrawResource {
	/**
	 * 协议出款
	 * 
	 * @param request
	 * @return
	 */
	public ProtocolDrawResponse protocolDraw(@Valid ProtocolDrawRequest request) ;

}
