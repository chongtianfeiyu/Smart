package com.somnus.smart.base.dao;

import java.util.List;

import com.somnus.smart.base.domain.TrnTranRefund;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnTranRefundDao {


    int insert(TrnTranRefund record);


    List<TrnTranRefund> selectByAccTranNo(String accTranNo);

    TrnTranRefund selectByPrimaryKey(String refTranNo);
    

    int updateByPrimaryKey(TrnTranRefund record);
}