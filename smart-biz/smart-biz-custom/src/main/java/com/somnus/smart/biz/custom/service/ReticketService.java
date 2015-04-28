package com.somnus.smart.biz.custom.service;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.reticket.ReticketRequest;

/**
 * 退票记账业务处理
 * 
 * @author 李太平
 * @version $Id: ReticketService.java, v 0.1 2014-11-25 下午01:45:21 李太平  Exp $
 */
public interface ReticketService {
    /**
     * 创建记账交易流水
     * 
     * @param request
     * @return
     */
    Transaction createTransaction(ReticketRequest request);
    /**
     * 出款退票同步记账
     * 
     * @param trntransaction
     */
    void drawReticketSynAccount(Transaction trntransaction,String oriAppTranNo)throws Exception;
    /**
     * 退款退票同步记账
     * 
     * @param trntransaction
     * @param oriAppTranNo
     * @throws Exception 
     */
    void refundReticketSysAccount(Transaction trntransaction, String oriAppTranNo,String entryKey) throws Exception;

}
