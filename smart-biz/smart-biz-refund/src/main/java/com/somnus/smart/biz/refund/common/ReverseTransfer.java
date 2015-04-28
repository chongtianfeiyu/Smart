package com.somnus.smart.biz.refund.common;

import org.springframework.beans.BeanUtils;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.ReverseRequest;
import com.somnus.smart.service.common.BasConstants;
import com.somnus.smart.service.common.CommonTransfer;

public class ReverseTransfer extends CommonTransfer {
    /**
     * 报文转换为实体
     * @param reserveRequest
     */
    public static Transaction msgToTransaction(ReverseRequest reserveRequest) {
        Transaction transaction = Transaction.getInstance();
        BeanUtils.copyProperties(reserveRequest, transaction);
        msgAdditional(reserveRequest, transaction);
        incomeSet(transaction);
        return transaction;
    }

    private static void msgAdditional(ReverseRequest reserveRequest, Transaction transaction) {
        transaction.setMachineNo(reserveRequest.getFrontNo());
        transaction.setCusTranNo(reserveRequest.getMerBillNo());
        transaction.setChlTranNo(reserveRequest.getPayTranNo());
        transaction.setFeeFlag(reserveRequest.getFeeWay());
        transaction.setThirdAccCode(reserveRequest.getThdAccCode());
    }

    private static void incomeSet(Transaction transaction) {
        CommonTransfer.initial(transaction);
        transaction.setBlnStatus(BasConstants.BLN_STATUS_NOTENTER);
        transaction.setAccMode(BasConstants.ACC_MODE_SYN);
        transaction.setAccStatus(BasConstants.ACC_STATUS_HANDLING);
    }
}
