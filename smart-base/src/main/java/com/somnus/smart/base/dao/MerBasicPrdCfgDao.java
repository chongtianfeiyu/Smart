package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.MerBasicPrdCfg;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 商户基础产品配置DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface MerBasicPrdCfgDao {
	
	/**
	 * 根据唯一约束查询
	 * @param basicprdcfg
	 * @return
	 */
	MerBasicPrdCfg selectConstraints(MerBasicPrdCfg basicprdcfg);

	void merge(MerBasicPrdCfg merBasicPrdCfg);
	
	/**
	 * 根据唯一性约束删除信息
	 * @param merBasicPrdCfg
	 */
	void deleteByContains(MerBasicPrdCfg merBasicPrdCfg);

}
