package com.somnus.smart.biz.custom.service;

import java.util.Date;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.custom.PurchaseExchangeRequest;
import com.somnus.smart.message.custom.PurchaseWriteOffRequest;
import com.somnus.smart.message.custom.SettlementExchangeRequest;
import com.somnus.smart.message.custom.SettlementWriteOffRequest;

/**
 * 结汇记账业务处理
 * 
 * @author 李太平
 * @version $Id: ForeignExchangeService.java, v 0.1 2014-11-24 下午04:57:53 李太平  Exp $
 */
public interface ForeignExchangeService {
    /**
     * 创建记账交易流水
     * 
     * @param request
     * @return
     */
    Transaction createTransaction(SettlementExchangeRequest request);
    /**
     * 结汇记账
     * 
     * @param transaction
     * @param accDate
     * @param b
     * @param entryKeySettleExchange
     * @throws Exception
     */
    void foreignExchangeSynAccount(Transaction transaction, Date accDate, boolean checkRed, String entryKeySettleExchange) throws Exception ;
    /**
     * 创建记账交易流水
     * 
     * @param request
     * @return
     */
    Transaction createTransaction(SettlementWriteOffRequest request);
    /**
     * 创建记账交易流水
     * 
     * @param request
     * @return
     */
    Transaction createTransaction(PurchaseWriteOffRequest request);
    /**
     * 创建记账交易流水
     * 
     * @param request
     * @return
     */
    Transaction createTransaction(PurchaseExchangeRequest request);

}
