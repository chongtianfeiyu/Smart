package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.TrnTranReverse;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnTranReverseDao {

    int insert(TrnTranReverse record);

    TrnTranReverse selectByAccTranNo(String accTranNo);

    TrnTranReverse selectByPrimaryKey(String reserveTranNo);

    int updateByPrimaryKey(TrnTranReverse record);
}