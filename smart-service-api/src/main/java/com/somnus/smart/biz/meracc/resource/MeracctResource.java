package com.somnus.smart.biz.meracc.resource;

import javax.validation.Valid;

import com.somnus.smart.message.Message;
import com.somnus.smart.message.meracct.MeraccountupdRequest;
import com.somnus.smart.message.meracct.MeracctRequest;
import com.somnus.smart.message.meracct.MerchantupdRequest;
import com.somnus.smart.message.meracct.PerAccountRequest;
import com.somnus.smart.message.meracct.PerAccountUpdRequest;
import com.somnus.smart.message.meracct.SpeAccountRequest;

/**
 * 开户服务
 */
public interface MeracctResource {
	
	/**
	 * 商户开户
	 * @param request
	 * @return
	 */
	Message createMeracct(@Valid MeracctRequest request);
	
	/**
	 * 个人开户
	 * @param request
	 * @return
	 */
	Message createPersonAccount(@Valid PerAccountRequest request);
	
	/**
	 * 更新个人账户信息
	 * @param request
	 * @return
	 */
	Message updatePersonAccount(@Valid PerAccountUpdRequest request);
	
	/**
	 * 更新商户信息
	 * @param request
	 * @return
	 */
	Message updateMermerchant(@Valid MerchantupdRequest request);
	
	/**
	 * 更新交易账户信息
	 * @param request
	 * @return
	 */
	Message updateMeraccount(@Valid MeraccountupdRequest request);
	
	
	/**
	 * 新增特定账户
	 * @param request
	 * @return
	 */
	Message createSpeAccount(@Valid SpeAccountRequest request);

}
