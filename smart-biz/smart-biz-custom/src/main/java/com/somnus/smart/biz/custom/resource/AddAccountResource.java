package com.somnus.smart.biz.custom.resource;

import javax.validation.Valid;

import com.somnus.smart.message.custom.AddAccountRequest;
import com.somnus.smart.message.custom.AddAccountResponse;

/**
 * 差异补记账服务
 */
public interface AddAccountResource {
	
	/**
	 * 差异补记账接口
	 * @param request
	 * @return
	 */
	public  AddAccountResponse addAccount(@Valid AddAccountRequest request);

}
