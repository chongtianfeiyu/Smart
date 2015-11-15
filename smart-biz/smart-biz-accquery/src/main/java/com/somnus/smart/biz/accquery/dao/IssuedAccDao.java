package com.somnus.smart.biz.accquery.dao;


import java.math.BigDecimal;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.smart.biz.accquery.common.IssuedEntity;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface IssuedAccDao {
	
	/**
	 * 下发审批明细查询
	 * @param entity
	 * @param pageBounds
	 * @return
	 */
	 public PageList<IssuedEntity> selectIssuedAccDetail(IssuedEntity entity, PageBounds pageBounds);
	 
	/**
	 * 下发审批查询
	 * @param entity
	 * @param pageBounds
	 * @return
	 */
	 public PageList<IssuedEntity> selectIssuedAcc(IssuedEntity entity, PageBounds pageBounds);
	 
	 /**
	  * 查询总金额
	  * @param entity
	  * @return
	  */
	 BigDecimal selectIssuedAccToalAmt(IssuedEntity entity);

}
