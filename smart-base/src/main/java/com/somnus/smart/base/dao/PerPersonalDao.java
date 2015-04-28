package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.PerPersonal;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 个人信息DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface PerPersonalDao {
	
	void insert(PerPersonal personal);
	
	PerPersonal selectByPrimaryKey(String key);

}
