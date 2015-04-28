package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.TrnTransactionHis;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 流水历史DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface TrnTransactionHisDao {

	/**
	 * 新增数据
	 * @param record
	 * @return
	 */
    int insert(TrnTransactionHis record);
    
    /**
     * 根据交易流水号查询数据
     * @param appTranNo
     * @return
     */
    TrnTransactionHis selectByAppTranNo(String appTranNo);

    /**
     * 根据主键查询数据
     * @param accTranNo
     * @return
     */
    TrnTransactionHis selectByPrimaryKey(String accTranNo);

    /**
     * 根据主键更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TrnTransactionHis record);

}