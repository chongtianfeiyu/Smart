package com.somnus.smart.base.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.somnus.smart.base.domain.TrnTransaction;
import com.somnus.smart.message.accquery.QueryCusFifRequest;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnTransactionDao {

	/**
	 * 
	 * @Title:insert
	 * @Description:插入账务前置主流水信息
	 * @param transaction
	 * @return void
	 */
	int insert(TrnTransaction transaction);
	
	/**
	 * @Title:insert
	 * @Description:插入账务前置主流水信息
	 * @param transaction
	 * @return void
	 */
	int insertNoSerq(TrnTransaction transaction);

	/**
	 * add by shellshen
	 * 
	 * @Title:update
	 * @Description:更新账务前置主流水信息
	 * @param transaction
	 * @return void
	 */
	int update(TrnTransaction transaction);


	/**
	 * 记账流水号
	 * @param accTranNo
	 * @return
	 */
	TrnTransaction selectByAccTranNo(@Param("accTranNo") String accTranNo);
	
	/**
	 * 应用流水号
	 * @param appTranNo
	 * @return
	 */
	TrnTransaction selectByAppTranNo(@Param("appTranNo") String appTranNo);
	
	
	/**
	 * 根据应用流水查询记账状态为正常记账的交易
	 * @param appTranNo
	 * @return
	 */
	TrnTransaction selectSuccessTranByAppTranNo(String appTranNo);
	


	/**
	 * @Title:select
	 * @Description:根据实体进行查询
	 * @param transaction
	 * @return
	 * @return List<TrnTransaction>
	 */
	List<TrnTransaction> select(TrnTransaction transaction);
	
	
	String getAccTranNo();
	
	/**
	 * 商户在途交易明细查询
	 * @param pageBounds
	 * @param request
	 * @return
	 */
	PageList<TrnTransaction> selectCusFifOrders(PageBounds pageBounds, QueryCusFifRequest request);
	
	/**
	 * 查询总金额
	 * @param request
	 * @return
	 */
	BigDecimal selectCusFifTotalAmts(QueryCusFifRequest request);
	/**
	 * 根据原应用流水号和交易码查询
	 * 
	 * @param orgAppTranNo
	 * @param tranCode
	 * @return
	 */
    TrnTransaction selectByOrgAppTranNoAndTranCode(@Param("oriAppTranNo") String oriAppTranNo, @Param("tranCode") String tranCode);
	
}