package com.somnus.smart.biz.meracc.resource;

import javax.validation.Valid;

import com.somnus.smart.message.Message;
import com.somnus.smart.message.meracct.SubOpenRequest;

/**
 * 内部科目开户服务
 */
public interface SubOpenResource {
	
	/**内部科目开户*/
	public Message open(@Valid SubOpenRequest request);

}
