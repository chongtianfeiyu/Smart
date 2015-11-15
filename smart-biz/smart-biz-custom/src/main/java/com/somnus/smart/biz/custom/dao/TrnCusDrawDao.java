package com.somnus.smart.biz.custom.dao;

import java.util.List;

import com.somnus.smart.base.domain.TrnDraw;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 出款核销DAO
 *
 */
@MyBatisRepository
public interface TrnCusDrawDao {
	
	/**
	 * 出款成功核销数据查询
	 * @return
	 */
	List<TrnDraw> queryWriteOffConfirm();
	
	/**
	 * 出款撤销核销数据查询
	 * @return
	 */
	List<TrnDraw> queryWriteOffRevoke();
	
	/**
	 * 更新销账标志为已销账
	 * @param trndraw
	 * @return
	 */
	int updateFlag(TrnDraw trndraw);

}
