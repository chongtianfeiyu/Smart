package com.somnus.smart.biz.custom.service;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.custom.BuckleDrawRequest;

/**
 * 扣划记账业务处理
 */
public interface BuckleDrawService {

    /**
     * 创建扣划记账交易流水
     * 
     * @param request
     */
    Transaction createTransaction(BuckleDrawRequest request);

    /**
     * 扣划记账
     * 
     * @param transaction
     * @param request
     * @param subAccCode
     * @return
     * @throws Exception
     */
    Transaction buckDrawSynAccount(Transaction transaction, BuckleDrawRequest request, String subAccCode) throws Exception;

}
