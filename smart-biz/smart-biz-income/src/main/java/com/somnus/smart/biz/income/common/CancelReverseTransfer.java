package com.somnus.smart.biz.income.common;

import org.springframework.beans.BeanUtils;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.CancelReverseRequest;
import com.somnus.smart.service.common.BasConstants;
import com.somnus.smart.service.common.CommonTransfer;

public class CancelReverseTransfer extends CommonTransfer {

    /**
     * 报文转换为实体
     * 
     * @param cancelReserveRequest
     */
    public static Transaction msgToTransaction(CancelReverseRequest cancelReserveRequest) {
        Transaction transaction = Transaction.getInstance();
        BeanUtils.copyProperties(cancelReserveRequest, transaction);
        msgAdditional(cancelReserveRequest, transaction);
        incomeSet(transaction);
        return transaction;
    }

    private static void msgAdditional(CancelReverseRequest cancelReserveRequest, Transaction transaction) {
        transaction.setMachineNo(cancelReserveRequest.getFrontNo());
        transaction.setCusTranNo(cancelReserveRequest.getMerBillNo());
        transaction.setChlTranNo(cancelReserveRequest.getPayTranNo());
        transaction.setFeeFlag(cancelReserveRequest.getFeeWay());
        transaction.setThirdAccCode(cancelReserveRequest.getThdAccCode());
    }

    private static void incomeSet(Transaction transaction) {
        CommonTransfer.initial(transaction);
        transaction.setBlnStatus(BasConstants.BLN_STATUS_NOTENTER);
        transaction.setAccMode(BasConstants.ACC_MODE_SYN);
        transaction.setAccStatus(BasConstants.ACC_STATUS_HANDLING);
    }
}
