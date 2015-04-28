package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.CusAccountedStatus;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface CusAccountedStatusDao {

    int deleteByPrimaryKey(String merAccCode);

    int insert(CusAccountedStatus record);

    int insertSelective(CusAccountedStatus record);

    CusAccountedStatus selectByPrimaryKey(String merAccCode);

    int updateByPrimaryKeySelective(CusAccountedStatus record);

}