package com.somnus.smart.base.dao;

import java.util.List;

import com.somnus.smart.base.domain.CfgAccEntry;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface CfgAccEntryDao {

	List<CfgAccEntry> selectByLikeKey(String key);
	
	CfgAccEntry selectByKey(String key);
	
	
}