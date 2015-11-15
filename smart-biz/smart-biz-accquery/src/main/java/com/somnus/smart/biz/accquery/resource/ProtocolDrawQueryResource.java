package com.somnus.smart.biz.accquery.resource;

import javax.validation.Valid;

import com.somnus.smart.message.accquery.ProtocolDrawQueryRequest;
import com.somnus.smart.message.accquery.ProtocolDrawQueryResponse;
import com.somnus.smart.message.accquery.ProtocolTransferQueryRequest;
import com.somnus.smart.message.accquery.ProtocolTransferQueryResponse;

public interface ProtocolDrawQueryResource {
	
	/**
	 * 协议出款查询
	 * @param request
	 * @return
	 */
	ProtocolDrawQueryResponse protocolDrawQuery(@Valid ProtocolDrawQueryRequest request);
	/**
	 * 协议出款划款流水查询
	 * @param request
	 * @return
	 */
	ProtocolTransferQueryResponse protocolTransferQuery(@Valid ProtocolTransferQueryRequest request);
}
