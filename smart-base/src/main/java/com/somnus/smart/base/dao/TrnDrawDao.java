package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.TrnDraw;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnDrawDao {
	
	TrnDraw selectByAppFlag(String appTranNo);
	
	TrnDraw selectByFlag(String drawId);

    int insert(TrnDraw record);
    
    int insertInSeq(TrnDraw record);

    int insertSelective(TrnDraw record);


    TrnDraw selectByPrimaryKey(String drawId);


    int updateByPrimaryKeySelective(TrnDraw record);
    
    String getDrawId();


	TrnDraw selectWriteOffConfirm(String drawId);

	TrnDraw selectWriteOffCancel(String drawId);
}