package com.somnus.smart.base.dao;

import java.util.List;

import com.somnus.smart.base.domain.TrnFreeze;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnFreezeDao {


    int insert(TrnFreeze record);

    List<TrnFreeze> select(TrnFreeze record);

    int updateByPrimaryKeySelective(TrnFreeze record);

}