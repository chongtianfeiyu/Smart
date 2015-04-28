package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.MerMerchant;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 商户信息DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface MerMerchantDao {
	
	/**
	 * 根据唯一性约束删除数据
	 * @param merchant
	 */
	void deleteByContains(MerMerchant merchant);
	
	/**
	 * 根据商户号查询商户
	 * @param mercode
	 * @return
	 */
	MerMerchant selectByMercode(String mercode);
	
	/**
	 * 新增商户信息
	 * @param merchant
	 */
	void insert(MerMerchant merchant);
	/**
	 * 
	 * @param merchant
	 */
	void merge(MerMerchant merchant);
	
	/**
	 * 得到主键
	 * */
	String getMerchantSequences();
	
	/**
	 * 更新商户信息
	 * @param merchant
	 */
	void updateByPrimaryKeySelective(MerMerchant merchant);
	

}
