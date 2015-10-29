package com.somnus.smart.biz.income.service;

import java.util.Date;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.CancelReverseRequest;
import com.somnus.smart.message.account.DepositRequest;
import com.somnus.smart.message.account.IncomeRequest;
import com.somnus.smart.message.account.IpsPayRequest;

/**
 * 收单记账业务处理器
 * 
 * @author 李太平
 * @version $Id: IncomeService.java, v 0.1 2014-11-17 上午08:56:08 李太平  Exp $
 */
public interface IncomeService {

    /**
     * 校验手续费相关的参数
     * 
     * @param feeStlMode
     * @param sysCode
     * @param feeWay
     * @param thirdAccCode
     * @throws Exception
     */
    void checkFee(String feeStlMode, String sysCode, String feeWay, String thirdAccCode) throws Exception;

    /**
     * 校验商户账户和商户流动资金户和应收银行账户是否存在
     * 
     * @param payeeCode
     * @param payeeAccCode
     * @param supplierCode
     * @param bankAccCode
     * @return
     */
    void checkMerAccAndMerSub(String payeeCode, String payeeAccCode, String supplierCode, String bankAccCode) throws Exception;
    
    /**
     * 校验个人账户和个人流动资金户和应收银行账户是否存在
     * 
     * @param accCode
     * @param supplierCode
     * @param bankAccCode
     * @return
     */
    void checkPerAccAndPerSub(String accCode, String supplierCode, String bankAccCode,String feeWay, String thirdAccCode) throws Exception;

    /**
     * 根据收单记账请求创建交易
     * 
     * @param incomeRequest
     * @return
     */
    Transaction createTransaction(IncomeRequest incomeRequest) throws Exception;
    
    /**
     * 根据充值记账请求创建交易
     * 
     * @param depositRequest
     * @return
     */
    public Transaction createDepositTran(DepositRequest depositRequest) throws Exception;

    /**
     * 创建撤销冲正记账交易流水
     * 
     * @param cancelReverseRequest
     * @return
     */
    Transaction createCancelReverseTran(CancelReverseRequest cancelReverseRequest) throws Exception;
    
    /**
     * 创建isp账户支付记账交易流水
     * 
     * @param ipsPayRequest
     * @return
     * @throws Exception
     */
    Transaction createIPSPayTran(IpsPayRequest ipsPayRequest) throws Exception;

    /**
     * 同步记账(落地流水、落地台账、落地分账户明细、更新余额)
     * 
     * @param transaction
     * @param entryKey
     * @param accDate
     * @param checkRed
     * @return
     */
    void incomeSynAccount(Transaction transaction, String entryKey, Date accDate, boolean checkRed) throws Exception;
    
    /**
     * 充值同步记账(落地流水、落地台账、落地分账户明细、更新余额)
     * 
     * @param transaction
     * @param entryKey
     * @param accDate
     * @param checkRed
     * @return
     */
    void depositSynAccount(Transaction transaction, String entryKey, Date accDate, boolean checkRed) throws Exception; 
    
    /**
     * 异步记账(落地台账、落地分账户明细、更新余额)
     * 
     * @param transaction
     * @param entryKey
     * @param accDate
     * @param checkRed
     * @return
     */
    void incomeAsynAccount(Transaction transaction, String entryKey, Date accDate, boolean checkRed) throws Exception;
    
    /**
     * isp账户收单记账
     * 
     * @param transaction
     * @param entryKey
     * @param accDate
     * @param b
     * @return
     */
    void ipsPayAccount(Transaction transaction, String entryKey, Date accDate, boolean checkRed) throws Exception;
    /**
     * 充值个人账户校验
     * 
     * @param depositRequest
     */
	void depositBizCheck(DepositRequest depositRequest);

}
