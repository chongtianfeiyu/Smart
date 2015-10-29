package com.somnus.smart.biz.draw.service;

import java.util.Date;
import java.util.List;

import com.somnus.smart.base.domain.MerAccount;
import com.somnus.smart.base.domain.TrnTransfer;
import com.somnus.smart.message.account.ProtocolDrawRequest;


/**
 *协议出款
 *
 * @author IH745
 * @version 1.0 13-10-18
 */
public interface ProtocolDrawService {

	/**
	 * 查询所有协议出款账户
	 * @return
	 */
	List<MerAccount> selectAllProtocolDrawAccounts();
	
	/**
	 * 特定商户协议划款
	 * @param merAccCode
	 * @param accDate
	 * @throws Exception 
	 */
	void protocolSpecificDraw(String merAccCode, Date accDate) throws Exception;
	/**
	 * 协议划款流水落地
	 * @param request
	 */
	String protocolTransfer(ProtocolDrawRequest request);
	/**
	 * 根据协议划款流水划款
	 * @param trnTransfer
	 * @param accDate
	 * @throws Exception 
	 */
	void protocolDraw(TrnTransfer trnTransfer, Date accDate) throws Exception;
	/**
	 * 更新划款流水
	 * @param trnTransfer
	 */
	void update(TrnTransfer trnTransfer);

	List<TrnTransfer> selectProtocolTransfer(TrnTransfer trnTransferQuery);
	
	String selectTransferBatchNo(TrnTransfer trnTransferQuery);

}
