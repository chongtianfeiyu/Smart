package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.InfSubdict;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 会计科目DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface InfSubdictDao {
	
	/**
	 * 根据主键查询记录
	 * @param subCode1st
	 * @return
	 */
	InfSubdict selectByPrimaryKey(String subCode1st);

}
