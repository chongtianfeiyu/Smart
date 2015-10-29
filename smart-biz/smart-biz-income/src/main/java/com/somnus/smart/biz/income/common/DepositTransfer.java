package com.somnus.smart.biz.income.common;

import org.springframework.beans.BeanUtils;

import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.DepositRequest;
import com.somnus.smart.service.common.BasConstants;
import com.somnus.smart.service.common.CommonTransfer;

/** 
 * @description: TODO 
 * @author Somnus
 * date 2015年2月27日 上午11:45:20  
 */
public class DepositTransfer extends CommonTransfer {
	/**
     * 报文转换为实体
     * 
     * @param depositRequest
     */
    public static Transaction msgToTransaction(DepositRequest depositRequest) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(depositRequest, transaction);
        msgAdditional(depositRequest, transaction);
        incomeSet(transaction);
        return transaction;
    }

    private static void msgAdditional(DepositRequest depositRequest, Transaction transaction) {
        transaction.setMachineNo(depositRequest.getFrontNo());
        transaction.setCusTranNo(depositRequest.getMerBillNo());
        transaction.setChlTranNo(depositRequest.getPayTranNo());
        transaction.setFeeFlag(depositRequest.getFeeWay());
        transaction.setThirdAccCode(depositRequest.getThdAccCode());
    }

    private static void incomeSet(Transaction transaction) {
        CommonTransfer.initial(transaction);
        transaction.setBlnStatus(BasConstants.BLN_STATUS_NOTENTER);
        transaction.setBlnMode(BasConstants.BLN_MODE_NOW);
        transaction.setAccMode(BasConstants.ACC_MODE_SYN);
        transaction.setAccStatus(BasConstants.ACC_STATUS_HANDLING);
    }
}
