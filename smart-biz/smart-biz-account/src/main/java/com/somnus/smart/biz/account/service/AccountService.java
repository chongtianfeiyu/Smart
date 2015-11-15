package com.somnus.smart.biz.account.service;

import java.math.BigDecimal;
import java.util.Date;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.AccountTransRequest;

/**
 * 账户记账业务处理
 */
public interface AccountService {
	/**
	 * 创建记账交易流水
	 * 
	 * @param request
	 * @return
	 */
	Transaction createTransaction(AccountTransRequest request);

	/**
	 * 账户同步记账
	 * 
	 * @param transaction
	 * @param entryKey
	 * @param accDate
	 * @param b
	 */
	void accountSysAccount(Transaction transaction, String entryKey,
			Date accDate, boolean b) throws Exception;

	/**
	 * 转账业务校验
	 * 
	 * @param payerType
	 * @param payerCode
	 * @param payerAccCode
	 * @param payeeType
	 * @param payeeCode
	 * @param payeeAccCode
	 * @param ccyCode
	 * @param tranAmt
	 */
	void checkCanTrans(String payerType, String payerCode, String payerAccCode,
			String payeeType, String payeeCode, String payeeAccCode,
			String ccyCode, BigDecimal tranAmt);
}
