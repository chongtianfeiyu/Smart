package com.somnus.smart.biz.account.service;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.BatchIpsDrawRequest;

/**
 *转账
 */
public interface BatchIpsDrawService {

	/**
	 * 交易记账请求参数
	 */
    void checkAccountRequest(BatchIpsDrawRequest request) throws Exception;
    /**
     * 创建记账交易流水
     * 
     * @param request
     * @return
     */
    Transaction createTransaction(BatchIpsDrawRequest request);
    /**
     * 
     * 
     * @param request
     * @param trntransaction
     * @throws Exception
     */
    void batchIpsDrawSynAccount(BatchIpsDrawRequest request, Transaction trntransaction) throws Exception;


}
