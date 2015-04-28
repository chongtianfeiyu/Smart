package com.somnus.smart.base.dao;

import java.util.List;

import com.somnus.smart.base.domain.Accsubentity;
import com.somnus.smart.base.domain.InfAcctype;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;


/**
 * 账户类型DAO
 * @author bo.zhang
 * @update yh.liu
 */
@MyBatisRepository
public interface InfAcctypeDao {
	
	/**
	 * 查询企业客户账户类型
	 */
	List<Accsubentity> selectEnterprise();
	
	/**
	 * 查询个人客户账户类型
	 */
	List<Accsubentity> selectIndividual();
	
	/**
	 * 根据类型查询
	 * @param accType
	 * @return
	 */
	InfAcctype selectByPrimaryKey(String accType);
	
	/**
	 * 根据科目号查询企业客户账户类型
	 * @param subCode
	 * @return
	 */
	List<Accsubentity> selectEpBySubCode(String subCode);
	
	/**
	 * 根据科目号得到对应信息
	 * @param subCode
	 * @return
	 */
	Accsubentity selectInnerAcc(String subCode);
	
	/**
	 * 根据账户类型查询对应信息
	 * @param accType
	 * @return
	 */
	Accsubentity selectAccByType(String accType);

}
