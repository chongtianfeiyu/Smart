package com.somnus.smart.biz.accquery.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.smart.message.accquery.QueryPayAppOrder;
import com.somnus.smart.message.accquery.QueryPayAppRequest;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface PaymentAppDao {
	
	/**
	 * 拒付审批查询
	 * @param pageBounds
	 * @param request
	 * @return
	 */
	public PageList<QueryPayAppOrder> selectPayAppOrders(PageBounds pageBounds, QueryPayAppRequest request);

}
