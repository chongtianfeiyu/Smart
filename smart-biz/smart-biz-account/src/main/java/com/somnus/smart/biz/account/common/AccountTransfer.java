package com.somnus.smart.biz.account.common;

import org.springframework.beans.BeanUtils;

import com.somnus.smart.domain.account.TranIssued;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.AccountTransRequest;
import com.somnus.smart.message.account.BatchIpsDrawRequest;
import com.somnus.smart.message.account.BatchIpsDrawRequest.Order;
import com.somnus.smart.service.common.AccountConstants;
import com.somnus.smart.service.common.CommonTransfer;
import com.somnus.smart.support.util.DateUtil;

public class AccountTransfer {
	/**
	 * 报文转换为实体
	 * @param incomeRequest
	 */
	public static Transaction msgToTransaction(AccountTransRequest request){
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		msgAdditional(request, transaction);
		CommonTransfer.initial(transaction);
		return transaction;
	}
	
	private static void msgAdditional(AccountTransRequest request,Transaction transaction){
		transaction.setMachineNo(request.getFrontNo());
		transaction.setCusTranNo(request.getMerBillNo());
		transaction.setFeeFlag(request.getFeeWay());
		transaction.setThirdAccCode(request.getThdAccCode());
	}
	

	public static Transaction msgToTransaction(BatchIpsDrawRequest request) {
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		transaction.setMachineNo(request.getFrontNo());
		transaction.setFeeFlag(request.getFeeWay());
		transaction.setAppTranNo(request.getAppBatchNo());
		transaction.setOrdAmt(request.getBatchAmt());
		if(AccountConstants.FEE_FLAG_PAY.equals(request.getFeeWay())){
			transaction.setTranAmt(request.getBatchAmt().add(request.getTotalFeeAmt()));
		}else{
			transaction.setTranAmt(request.getBatchAmt());
		}
		transaction.setFeeAmt(request.getTotalFeeAmt());
		transaction.setThirdAccCode(request.getThdAccCode());
		CommonTransfer.initial(transaction);
		return transaction;
	}

	public static TranIssued msgToTranIssued(BatchIpsDrawRequest request, Order order) {
		TranIssued tranIssued = TranIssued.getInstance();
		BeanUtils.copyProperties(request, tranIssued);
		BeanUtils.copyProperties(order, tranIssued);
		tranIssued.setStatus(AccountConstants.ISSUED_STATUS_OUT);
		tranIssued.setSubmitTime(DateUtil.getCurrentTimeStamp());
		tranIssued.setCreateTime(DateUtil.getCurrentTimeStamp());
		tranIssued.setModifyTime(tranIssued.getCreateTime());
		tranIssued.setCreateBy(AccountConstants.DEFAULT_OPERATOR);
		tranIssued.setModifyBy(tranIssued.getCreateBy());
		return tranIssued;
	}
}
