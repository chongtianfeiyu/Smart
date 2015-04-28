package com.somnus.smart.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.somnus.smart.base.domain.TrnLedgerDetail;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnLedgerDetailDao {

	/**
	 * add by shellshen
	 * 
	 * @Title:insert
	 * @Description:插入台帐明细
	 * @param record
	 * @return void
	 */
	int insert(TrnLedgerDetail record);

	/**
	 * @Title:update
	 * @Description:更新台帐
	 * @param record
	 * @return void
	 */
	int update(TrnLedgerDetail record);


	/**
	 * @Title:selectLedgerListByAccTranNo
	 * @Description:根据前置交易流水号查询为处理的台帐
	 * @param accTranNo
	 * @return
	 * @return List<TrnLedgerDetail>
	 */
	List<TrnLedgerDetail> select(TrnLedgerDetail trnLedgerDetail);
	
	TrnLedgerDetail selectByPrimaryKey(@Param("ledTranNo") String ledTranNo);
	
}