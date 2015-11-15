package com.somnus.smart.biz.custom.dao;

import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 交易流水关联退款流水附属表
 *
 */
@MyBatisRepository
public interface CusTranRefundDao {
	
	/**
	 * 根据应用交易流水号关联交易流水和退款流水附属信息
	 * @param appTranNo
	 * @return
	 */
	String selectRefType(String appTranNo);

}
