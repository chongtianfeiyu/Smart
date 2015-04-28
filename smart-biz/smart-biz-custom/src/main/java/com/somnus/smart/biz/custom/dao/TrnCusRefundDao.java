package com.somnus.smart.biz.custom.dao;

import java.util.List;

import com.somnus.smart.base.domain.TrnRefund;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 退款核销DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface TrnCusRefundDao {
	
	/**
	 * 退款成功核销数据查询
	 * @return
	 */
	List<TrnRefund> queryWriteOffConfirm();
	
	/**
	 * 退款撤销核销数据查询
	 * @return
	 */
	List<TrnRefund> queryWriteOffRevoke();
	
	/**
	 * 更新销账标志为已销账
	 * @param refund
	 * @return
	 */
	int updateFlag(TrnRefund refund);

}
