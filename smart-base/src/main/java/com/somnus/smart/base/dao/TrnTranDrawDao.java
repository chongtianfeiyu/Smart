package com.somnus.smart.base.dao;

import java.util.List;

import com.somnus.smart.base.domain.TrnTranDraw;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnTranDrawDao {


    int insert(TrnTranDraw record);


    TrnTranDraw selectByPrimaryKey(String draTranNo);
    
    List<TrnTranDraw> selectByAccTranNo(String accTranNo);

    List<TrnTranDraw> select(TrnTranDraw example);

    int updateByPrimaryKey(TrnTranDraw record);
}