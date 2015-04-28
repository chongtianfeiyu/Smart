package com.somnus.smart.biz.custom.common;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.custom.BuckleDrawRequest;
import com.somnus.smart.message.custom.FeeChargeRequest;
import com.somnus.smart.message.custom.PurchaseExchangeRequest;
import com.somnus.smart.message.custom.PurchaseWriteOffRequest;
import com.somnus.smart.message.custom.SettlementExchangeRequest;
import com.somnus.smart.message.custom.SettlementWriteOffRequest;
import com.somnus.smart.service.common.CommonTransfer;

public class CustomTransfer extends CommonTransfer{

	public static Transaction msgToTransaction(BuckleDrawRequest request) {
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		transaction.setMachineNo(request.getFrontNo());
		transaction.setOrdAmt(transaction.getTranAmt());
		transaction.setFeeAmt(BigDecimal.ZERO);
		CommonTransfer.initial(transaction);
		return transaction;
	}

	/**
	 * 根据传入参数构造交易主表信息-费用收取记账接口
	 * @param request
	 * @return
	 */
	public static Transaction msgToTransaction(FeeChargeRequest request) {
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		transaction.setMachineNo(request.getFrontNo());
		CommonTransfer.initial(transaction);
		return transaction;
	}
	
	
	/**
	 * 根据传入参数构造交易主表信息-结汇记账接口
	 * @param request
	 * @return
	 */
	public static Transaction msgToTransaction(SettlementExchangeRequest request) {
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		transaction.setMachineNo(request.getFrontNo());
		CommonTransfer.initial(transaction);
		return transaction;
	}
	
	/**
	 * 根据传入参数构造交易主表信息-结汇核销记账接口
	 * @param request
	 * @return
	 */
	public static Transaction msgToTransaction(SettlementWriteOffRequest request) {
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		transaction.setMachineNo(request.getFrontNo());
		transaction.setFeeAmt(BigDecimal.ZERO);
		CommonTransfer.initial(transaction);
		return transaction;
	}
	
	/**
	 * 根据传入参数构造交易主表信息-购汇记账接口
	 * @param request
	 * @return
	 */
	public static Transaction msgToTransaction(PurchaseExchangeRequest request) {
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		transaction.setMachineNo(request.getFrontNo());
		CommonTransfer.initial(transaction);
		return transaction;
	}
	
	/**
	 * 根据传入参数构造交易主表信息-购汇核销记账接口
	 * @param request
	 * @return
	 */
	public static Transaction msgToTransaction(PurchaseWriteOffRequest request) {
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		transaction.setMachineNo(request.getFrontNo());
		transaction.setFeeAmt(BigDecimal.ZERO);
		CommonTransfer.initial(transaction);
		return transaction;
	}
}
