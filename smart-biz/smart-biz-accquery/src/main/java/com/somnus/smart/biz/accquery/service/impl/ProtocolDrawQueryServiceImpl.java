package com.somnus.smart.biz.accquery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.smart.biz.accquery.dao.ProtocolDrawDao;
import com.somnus.smart.biz.accquery.service.ProtocolDrawQueryService;
import com.somnus.smart.message.accquery.ProtocolDrawOrder;
import com.somnus.smart.message.accquery.ProtocolDrawQueryRequest;
import com.somnus.smart.message.accquery.ProtocolDrawQueryResponse;
import com.somnus.smart.message.accquery.ProtocolTransferOrder;
import com.somnus.smart.message.accquery.ProtocolTransferQueryRequest;
import com.somnus.smart.message.accquery.ProtocolTransferQueryResponse;
import com.somnus.smart.support.common.MsgCodeList;
import com.somnus.smart.support.exceptions.BizException;

/**
 * 
 * @description: TODO 
 * @author yh.liu
 * date 2015年3月6日 下午6:14:26
 */
@Service
public class ProtocolDrawQueryServiceImpl implements ProtocolDrawQueryService {
	
	@Autowired
	private MessageSourceAccessor msa;
	@Autowired
	private ProtocolDrawDao protocolDrawDao;
	
	
	@Override
	public ProtocolDrawQueryResponse protocolDrawQuery(ProtocolDrawQueryRequest request) {
		ProtocolDrawQueryResponse response = new ProtocolDrawQueryResponse();
		PageList<ProtocolDrawOrder> pagelist =protocolDrawDao.selectProtocolDraw(request, 
				new PageBounds(request.getPageNum(),request.getPageSize()));
		if(pagelist == null) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002, 
					new Object[]{request.getMerCode()}));
		}
		int total = pagelist.getPaginator().getTotalCount();//总记录数
		response.setPageNum(request.getPageNum());
		response.setPageSize(request.getPageSize());
		response.setRowCount(total);
		response.setOrders(pagelist);
		return response;
	}


	@Override
	public ProtocolTransferQueryResponse protocolDrawQuery(ProtocolTransferQueryRequest request) {
		ProtocolTransferQueryResponse response = new ProtocolTransferQueryResponse();
		PageList<ProtocolTransferOrder> pagelist =protocolDrawDao.selectProtocolTransfer(request, 
				new PageBounds(request.getPageNum(),request.getPageSize()));
		if(pagelist == null) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002, 
					new Object[]{request.getMerCode()}));
		}
		int total = pagelist.getPaginator().getTotalCount();//总记录数
		response.setPageNum(request.getPageNum());
		response.setPageSize(request.getPageSize());
		response.setRowCount(total);
		response.setOrders(pagelist);
		return response;
	}
	

}
