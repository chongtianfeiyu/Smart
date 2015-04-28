package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.TrnRefund;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnRefundDao {

    int insert(TrnRefund record);



    TrnRefund selectByPrimaryKey(String refundId);
    
    TrnRefund selectByAppFlag(String appTranNo);


    int updateByPrimaryKeySelective(TrnRefund record);


	TrnRefund selectWriteOffConfirm(String refundId);


	TrnRefund selectWriteOffCancel(String refundId);
}