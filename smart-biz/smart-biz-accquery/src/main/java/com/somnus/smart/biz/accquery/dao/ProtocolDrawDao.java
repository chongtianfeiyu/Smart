package com.somnus.smart.biz.accquery.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.smart.message.accquery.ProtocolDrawOrder;
import com.somnus.smart.message.accquery.ProtocolDrawQueryRequest;
import com.somnus.smart.message.accquery.ProtocolTransferOrder;
import com.somnus.smart.message.accquery.ProtocolTransferQueryRequest;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface ProtocolDrawDao {

	/**
	 * 协议出款查询
	 * 
	 * @param request
	 * @param pageBounds
	 * @return
	 */
	public PageList<ProtocolDrawOrder> selectProtocolDraw(ProtocolDrawQueryRequest request, PageBounds pageBounds);
	/**
	 * 查询划款流水
	 * @param request
	 * @param pageBounds
	 * @return
	 */
	public PageList<ProtocolTransferOrder> selectProtocolTransfer(ProtocolTransferQueryRequest request,
			PageBounds pageBounds);

}
