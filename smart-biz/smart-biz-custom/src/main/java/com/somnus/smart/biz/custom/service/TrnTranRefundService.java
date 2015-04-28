package com.somnus.smart.biz.custom.service;

public interface TrnTranRefundService {
	
	/**
	 * 根据应用交易流水号关联交易流水和退款流水附属信息
	 * @param appTranNo
	 * @return
	 */
	String queryRefType(String appTranNo);

}
