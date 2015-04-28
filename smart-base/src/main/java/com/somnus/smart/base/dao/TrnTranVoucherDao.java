package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.TrnTranVoucher;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnTranVoucherDao {


    int insert(TrnTranVoucher record);

    TrnTranVoucher selectByPrimaryKey(String vouTranNo);

    int updateByPrimaryKeySelective(TrnTranVoucher record);

}