package com.somnus.smart.biz.refund.service;

import com.somnus.smart.base.domain.TrnTranReverse;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.ReverseRequest;

/**
 * 冲正服务
 * 
 * @author Administrator
 * @version $Id: ReserveService.java, v 0.1 2014-10-17 下午04:15:20 Administrator Exp $
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
