package com.somnus.smart.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.somnus.smart.base.domain.TcorTrnTranFee;
import com.somnus.smart.base.domain.TcorTrnTranFeeExample;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TcorTrnTranFeeDao {
	
	String getFeeTranNo();
	
    int countByExample(TcorTrnTranFeeExample example);

    int deleteByExample(TcorTrnTranFeeExample example);

    int insert(TcorTrnTranFee record);

    int insertSelective(TcorTrnTranFee record);

    List<TcorTrnTranFee> selectByExample(TcorTrnTranFeeExample example);

    int updateByExampleSelective(@Param("record") TcorTrnTranFee record, @Param("example") TcorTrnTranFeeExample example);

    int updateByExample(@Param("record") TcorTrnTranFee record, @Param("example") TcorTrnTranFeeExample example);
}