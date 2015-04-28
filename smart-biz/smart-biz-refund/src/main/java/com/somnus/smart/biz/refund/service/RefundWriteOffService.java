package com.somnus.smart.biz.refund.service;

import com.somnus.smart.domain.account.RefundTransaction;
import com.somnus.smart.message.writeoff.RefundWriteOffRequest;

/**
 * 核销接口
 * 
 * @author IH745
 * 
 */
public interface RefundWriteOffService {

    /**
     * 退款核销调用
     * 
     * @param request
     * @return
     */
    public void refundWriteOff(RefundWriteOffRequest request);

    /**
     * 退款成功核销记账
     * 
     * @param request
     */
    public void refundedWriteOffAccount(RefundWriteOffRequest request) throws Exception;

    /**
     * 退款撤销核销记账
     * 
     * @param request
     * @throws Exception
     */
    public void refundCancelWriteOffAccount(RefundWriteOffRequest request,RefundTransaction refundTransaction) throws Exception;

}
