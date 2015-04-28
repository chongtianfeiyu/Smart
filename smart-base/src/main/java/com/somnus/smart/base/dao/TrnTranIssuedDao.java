package com.somnus.smart.base.dao;

import java.util.List;

import com.somnus.smart.base.domain.TrnTranIssued;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnTranIssuedDao {
	
	/**
	 * 交易流水号查询已出款记录
	 * @param appTranNo
	 * @return
	 */
	TrnTranIssued selectByAppStatus(String appTranNo);


    int insert(TrnTranIssued record);


    List<TrnTranIssued> select(TrnTranIssued example);

    TrnTranIssued selectByPrimaryKey(String issTranNo);
    List<TrnTranIssued>  selectByAccTranNo (String accTranNo);
    String getIssTranNo();
    
    int insertNoSeq(TrnTranIssued record);

    int updateByPrimaryKey(TrnTranIssued record);
    
    int updateByPrimaryKeyStatus(TrnTranIssued record);
    
    List<TrnTranIssued>  selectByAccTranNoStatus (TrnTranIssued issued);
}