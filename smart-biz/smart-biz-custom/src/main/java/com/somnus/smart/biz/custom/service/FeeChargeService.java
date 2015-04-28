package com.somnus.smart.biz.custom.service;

import java.math.BigDecimal;
import java.util.Date;

import com.somnus.smart.base.domain.TrnTransaction;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.custom.FeeChargeRequest;

public interface FeeChargeService {
	/**
	 * 落地收费流水
	 * 
	 * @param trnTransaction
	 * @param tcorTrnTranFee
	 */
	void createTrnFree(TrnTransaction trnTransaction,String status);
	/**
	 * 校验商户是否允许出款
	 * 
	 * @param payerType
	 * @param payerCode
	 * @param payerAccCode
	 * @param ccyCode
	 * @param tranAmt
	 */
    void checkMerAllowOut(String payerType, String payerCode, String payerAccCode,String ccyCode,BigDecimal tranAmt);
    /**
     * 创建收费记账交易流水
     * 
     * @param request
     */
    Transaction createTransaction(FeeChargeRequest request);
    /**
     * 收费同步记账
     * 
     * @param transaction
     * @param accDate
     * @param checkRed
     * @param entryKeyFeeCharge
     */
    void feeChargeSynAccount(Transaction transaction, Date accDate, boolean checkRed, String entryKeyFeeCharge) throws Exception;
    /**
     * 超额冻结，交易流水、收费附属流水落地，返回处理结果
     * 
     * @param transaction
     * @param subAccCode
     * @return
     */
    TrnTransaction totalFeeChargeDeal(Transaction transaction, String subAccCode);
    /**
     * 收费同步记账
     * 
     * @param transaction
     * @param accDate
     * @param b
     * @param entryKeyUnfeeCharge
     */
    Transaction unFeeChargeSynAccount(Transaction transaction, Date accDate, boolean checkRed, String entryKeyUnfeeCharge) throws Exception;

}
