package com.somnus.smart.biz.custom.common;

import org.springframework.beans.BeanUtils;

import com.somnus.smart.domain.account.TranVoucher;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.voucher.VoucherEnterRequest;
import com.somnus.smart.service.common.BasConstants;
import com.somnus.smart.service.common.CommonTransfer;
import com.somnus.smart.support.util.DateUtil;

public class VoucherTransfer {

	/**
	 * 报文转换为实体
	 * 
	 * @param incomeRequest
	 */
	public static Transaction msgToTransaction(VoucherEnterRequest.Voucher voucher, VoucherEnterRequest request) {
		Transaction transaction = Transaction.getInstance();
		BeanUtils.copyProperties(request, transaction);
		BeanUtils.copyProperties(voucher, transaction);
		transaction.setMachineNo(request.getFrontNo());
		CommonTransfer.initial(transaction);
		return transaction;
	}

	public static TranVoucher msgToTranVoucher(VoucherEnterRequest.Voucher voucher) {
		TranVoucher tranVoucher = TranVoucher.getInstance();
		BeanUtils.copyProperties(voucher, tranVoucher);
		tranVoucher.setCreateTime(DateUtil.getCurrentTimeStamp());
		tranVoucher.setModifyTime(tranVoucher.getCreateTime());
		tranVoucher.setCreateBy(BasConstants.DEFAULT_OPERATOR);
		tranVoucher.setModifyBy(tranVoucher.getCreateBy());
		return tranVoucher;
	}

}
