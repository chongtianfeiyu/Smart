package com.somnus.smart.base.dao;

import java.util.List;

import com.somnus.smart.base.domain.TrnTransfer;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnTransferDao {

	    int insert(TrnTransfer record);

	    TrnTransfer selectByPrimaryKey(String transferId);
	    
	    List<TrnTransfer> select(TrnTransfer trnTransfer);

	    int updateByPrimaryKeySelective(TrnTransfer record);
	    
	    String getBatchNo();

		String selectBatchNo(TrnTransfer trnTransferQuery);

	
}