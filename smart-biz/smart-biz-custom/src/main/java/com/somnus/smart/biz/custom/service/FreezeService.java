package com.somnus.smart.biz.custom.service;

import java.math.BigDecimal;

import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.domain.account.FreezeTransaction;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.custom.AccountFreezeRequest;
import com.somnus.smart.message.custom.TranFreezeRequest;

/**
 * 冻结解冻业务处理
 * 
 * @author 李太平
 * @version $Id: FreezeService.java, v 0.1 2014-11-25 上午09:35:48 李太平  Exp $
 */
public interface FreezeService {
    /**
     * 创建冻结交易流水
     * 
     * @param request
     * @return
     */
    FreezeTransaction createFreezeTransaction(AccountFreezeRequest request);
    /**
     * 冻结处理
     * 
     * @param freezeTransaction
     * @param cusSubaccinfo
     */
    void freezeDeal(FreezeTransaction freezeTransaction,CusSubaccinfo cusSubaccinfo);
    /**
     * 解冻处理
     * 
     * @param freezeTransaction
     * @param cusSubaccinfo
     * @param tranAmt
     */
    void unFreezeDeal(FreezeTransaction freezeTransaction, CusSubaccinfo cusSubaccinfo,BigDecimal tranAmt);
    /**
     * 校验原交易
     * 
     * @param transaction
     */
    void checkTransaction(Transaction transaction);
    /**
     * 创建冻结交易流水
     * 
     * @param request
     * @param transaction
     * @return
     */
    FreezeTransaction createFreezeTransaction(TranFreezeRequest request, Transaction transaction);
    /**
     * 交易冻结处理
     * 
     * @param freezeTransaction
     * @param transaction
     */
    void tranFreezeDeal(FreezeTransaction freezeTransaction, Transaction transaction);
    /**
     * 交易解冻处理
     * 
     * @param freezeTransaction
     * @param transaction
     */
    void tranUnFreezeDeal(FreezeTransaction freezeTransaction, Transaction transaction);

}
