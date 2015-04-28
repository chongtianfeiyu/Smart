package com.somnus.smart.biz.meracc.service;

import com.somnus.smart.message.meracct.AccountAllowInOrOutRequest;
import com.somnus.smart.message.meracct.MeraccountupdRequest;
import com.somnus.smart.message.meracct.MeracctRequest;
import com.somnus.smart.message.meracct.MerchantupdRequest;
import com.somnus.smart.message.meracct.PerAccountRequest;
import com.somnus.smart.message.meracct.PerAccountUpdRequest;
import com.somnus.smart.message.meracct.SpeAccountRequest;

/**
 * 开户Service
 * @author bo.zhang
 *
 */
public interface MeracctService {
	
	/**
	 * 新增商户、交易账户、功能账户
	 * @param entity
	 * @throws Exception
	 */
	void txnMerCreateAcc(MeracctRequest request) throws Exception;
	
	/**
	 * 新增个人、交易账户、功能账户
	 * @param entity
	 * @throws Exception
	 */
	void txnPerCreateAcc(PerAccountRequest request) throws Exception;
	
	/**
	 * 更新商户信息
	 * @param request
	 * @return
	 */
	void updateMermerchant(MerchantupdRequest request) throws Exception ;
	
	/**
	 * 更新个人账户信息
	 * @param request
	 * @throws Exception
	 */
	void updatePerAccount(PerAccountUpdRequest request) throws Exception;
	
	/**
	 * 更新交易账户信息
	 * @param request
	 * @return
	 */
	void updateMeraccount(MeraccountupdRequest request) throws Exception ;
	
	/**
	 * 更新交易账户信息
	 * @param request
	 * @return
	 */
	void updateMeraccount(AccountAllowInOrOutRequest request) throws Exception;
	
	/**
	 * 新增特定账户
	 * @param request
	 * @throws Exception
	 */
	void insertSpeAccount(SpeAccountRequest request) throws Exception;

}
