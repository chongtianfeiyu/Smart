package com.somnus.smart.biz.custom.service;

import com.somnus.smart.domain.account.TranVoucher;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.voucher.VoucherEnterRequest;
import com.somnus.smart.message.voucher.VoucherEnterRequest.Voucher;

public interface VoucherService {
	/**
	 * 凭证记账请求校验
	 * 
	 * @param voucher
	 */
    void checkRquest(Voucher voucher);
    /**
     * 创建记账交易流水
     * 
     * @param voucher
     * @param request
     */
    Transaction createTransaction(Voucher voucher, VoucherEnterRequest request);
    /**
     * 创建凭证附属
     * 
     * @param voucher
     */
    TranVoucher createTranVoucher(Voucher voucher);
    /**
     * 凭证记账
     * 
     * @param transaction
     * @param tranVoucher
     */
    void voucherEnterAccount(Transaction transaction, TranVoucher tranVoucher) throws Exception;

}
