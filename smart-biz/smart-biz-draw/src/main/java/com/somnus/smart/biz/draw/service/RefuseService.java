package com.somnus.smart.biz.draw.service;

import java.math.BigDecimal;

import com.somnus.smart.domain.account.TranRefuse;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.refusepay.RefusePayRequest;

/**
 * 拒付服务
 * 
 * @author Administrator
 * 
 */
public interface RefuseService {

    /**
     * 拒付原交易校验
     * 
     * @param oriTransaction
     */
    public void checkOriTransaction(Transaction oriTransaction, String refKind, BigDecimal tranAmt);

    /**
     * 创建记账交易流水
     * 
     * @param request
     * @return
     */
    public Transaction createTransaction(RefusePayRequest request,String supplierCode);

    /**
     * 拒付同步记账
     * 
     * @param refKind
     * @param tranAmt
     * @param oriTransaction
     * @param transaction
     * @throws Exception 
     */
    public void refusePaySynAccount(String refKind, BigDecimal tranAmt, Transaction oriTransaction, Transaction transaction, TranRefuse tranRefuse,
                                    String payerAccCode, String ccyCode) throws Exception;

    /**
     * 创建附属流水
     * 
     * @param request
     * @return
     */
    public TranRefuse createTranRefuse(RefusePayRequest request);

}
