package com.somnus.smart.biz.accquery.service;

import com.somnus.smart.message.accquery.ProtocolDrawQueryRequest;
import com.somnus.smart.message.accquery.ProtocolDrawQueryResponse;
import com.somnus.smart.message.accquery.ProtocolTransferQueryRequest;
import com.somnus.smart.message.accquery.ProtocolTransferQueryResponse;

/**
 * 查询接口
 * @author IH745
 *
 */
public interface ProtocolDrawQueryService {
	
	/**
	 * 协议出款查询
	 * @param request
	 * @return
	 */
	ProtocolDrawQueryResponse protocolDrawQuery(ProtocolDrawQueryRequest request);
	/**
	 * 划款流水查询
	 * @param request
	 * @return
	 */
	ProtocolTransferQueryResponse protocolDrawQuery(ProtocolTransferQueryRequest request);

}
