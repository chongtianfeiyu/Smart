package com.somnus.smart.biz.account.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.smart.biz.account.common.AccountTransfer;
import com.somnus.smart.biz.account.service.AccountService;
import com.somnus.smart.domain.account.Account;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.AccountTransRequest;
import com.somnus.smart.service.BasBizService;
import com.somnus.smart.service.common.AccountConstants;
import com.somnus.smart.service.common.DrawConstants;
import com.somnus.smart.service.common.enums.AccountType;
import com.somnus.smart.support.common.MsgCodeList;
import com.somnus.smart.support.exceptions.BizException;

@Service
public class AccountServiceImpl implements AccountService {
	/** basBizService */
	@Autowired
	private BasBizService basBizService;
	
	@Autowired
    private MessageSourceAccessor msa;

	@Override
	public Transaction createTransaction(AccountTransRequest request) {
		Transaction transaction = AccountTransfer.msgToTransaction(request);
		// 设置当前帐务日期
		transaction.setAccDate(basBizService.getSystemAccDate());
		// 设置记账流水号
		transaction.setAccTranNo(basBizService.getAccTranNo());
		return transaction;
	}

	@Override
	@Transactional
	public void accountSysAccount(Transaction transaction, String entryKey,
			Date accDate, boolean checkRed) throws Exception {
		if (transaction == null) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302019, new Object[] {}));
		}
		Account account = Account.getInstance();
		account.ipsPayAccount(transaction, entryKey, accDate, checkRed);
	}

	@Override
	public void checkCanTrans(String payerType, String payerCode,
			String payerAccCode, String payeeType, String payeeCode,
			String payeeAccCode, String ccyCode, BigDecimal tranAmt) {
		// 1、校验付款方是否允许出款
		basBizService.checkAllowOut(payerType, payerCode, payerAccCode);
		// 2、校验收款方是否允许出款
		basBizService.checkAllowIn(payeeType, payeeCode, payeeAccCode);
		// 3、检查商户流动资金账户余额是否足够出款
		String accountType = null;
		if (payerType.equals(DrawConstants.BIZ_KIND_PERSON)) {
			accountType = AccountType.IDV.getCode();
		} else if (payerType.equals(DrawConstants.BIZ_KIND_CUS)) {
			accountType = AccountType.BIZ.getCode();
		}
		BigDecimal availableBal = basBizService.getAvailableBal(
				AccountType.getByCode(accountType),
				AccountConstants.REL_SUB_CODE_FREE + payerAccCode,
				payerAccCode, ccyCode);
		if (availableBal.compareTo(tranAmt) < 0) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_304001, 
					new Object[] { payerAccCode}));
		}
	}
}
