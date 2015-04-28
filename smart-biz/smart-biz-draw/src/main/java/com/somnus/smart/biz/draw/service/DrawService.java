package com.somnus.smart.biz.draw.service;

import java.math.BigDecimal;
import java.util.Date;

import com.somnus.smart.domain.account.DrawTransaction;
import com.somnus.smart.domain.account.TranDraw;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.BankDrawRequest;

public interface DrawService {

	/**
	 * 校验商户是否允许出款
	 * 
	 * @param payerType
	 * @param payerCode
	 * @param payerAccCode
	 * @param ccyCode
	 * @param orderAmt
	 */
	void checkMerCanDraw(String payerType, String payerCode,
			String payerAccCode, String ccyCode, BigDecimal orderAmt,
			String feeWay, String thdAccCode);

	/**
	 * 创建出款记账流水
	 * 
	 * @param request
	 */
	Transaction createTransaction(BankDrawRequest request);

	/**
	 * 创建出款附属流水
	 * 
	 * @param request
	 * @param accTranNo
	 * @return
	 */
	TranDraw createTranDraw(BankDrawRequest request, String accTranNo);

	/**
	 * 创建出款交易流水
	 * 
	 * @param transaction
	 * @param tranDraw
	 * @return
	 */
	DrawTransaction createDrawTransaction(Transaction transaction,
			TranDraw tranDraw);

	/**
	 * 出款记账
	 * 
	 * @param transaction
	 * @param entryKey
	 * @param accDate
	 * @param checkRed
	 * @param tranDraw
	 * @param drawTransaction
	 * @return
	 */
	void drawSynAccount(Transaction transaction, String entryKey, Date accDate,
			boolean checkRed, TranDraw tranDraw, DrawTransaction drawTransaction)
			throws Exception;
}
