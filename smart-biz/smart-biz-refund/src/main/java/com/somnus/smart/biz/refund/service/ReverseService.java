package com.somnus.smart.biz.refund.service;

import com.somnus.smart.base.domain.TrnTranReverse;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.ReverseRequest;

/**
 * 冲正服务
 */
public interface ReverseService {

    /**
     * 冲正处理
     * @param request
     * @param oriTransaction
     * @return
     */
    TrnTranReverse reverseSynAccount(ReverseRequest request, Transaction oriTransaction,
                               Transaction trntransaction) throws Exception;

}
