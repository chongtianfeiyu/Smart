package com.somnus.smart.base.dao;

import org.apache.ibatis.annotations.Param;

import com.somnus.smart.base.domain.AccMapping;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/** 
 * 个人账户对应关系DAO（标准账户-专业账户）
 * @author Somnus
 * date 2015年2月6日 下午5:55:35  
 */
@MyBatisRepository
public interface AccMappingDao {
	/**
	 * 新增个人账户对应关系
	 * @param perAccount
	 */
	void insert(AccMapping accMapping);
	/**
	 * 根据标准账户号查询专用账户号
	 * 
	 * @param stdAccCode
	 * @return
	 */
	String selectSpeAccCodeByStdAccCode(@Param("stdAccCode")String stdAccCode);
	/**
	 * 根据专用账户号查询标准账户号
	 * 
	 * @param speAccCode
	 * @return
	 */
	String selectStdAccCodeBySpeAccCode(@Param("speAccCode")String speAccCode); 
	
}
