package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.PerAccount;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 个人账户信息DAO
 * @author yh.liu
 *
 */
@MyBatisRepository
public interface PerAccountDao {
	
	/**
	 * 根据交易账户号查询个人账户
	 * @param accCode
	 * @return
	 */
	PerAccount selectByAcctCode(String acctCode);

	/**
	 * 新增个人账户对象
	 * @param perAccount
	 */
	void insert(PerAccount perAccount);
	
	/**
	 * 更新个人账户
	 * @param meraccount
	 */
	void updateByPrimaryKeySelective(PerAccount perAccount);
	
}
