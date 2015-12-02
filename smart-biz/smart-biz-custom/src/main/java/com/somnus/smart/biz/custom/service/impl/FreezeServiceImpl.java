package com.somnus.smart.biz.custom.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.biz.custom.common.ReticketConstants;
import com.somnus.smart.biz.custom.service.FreezeService;
import com.somnus.smart.domain.account.FreezeTransaction;
import com.somnus.smart.domain.account.SubAccInfo;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.custom.AccountFreezeRequest;
import com.somnus.smart.message.custom.TranFreezeRequest;
import com.somnus.smart.service.BasBizService;
import com.somnus.smart.service.common.BasConstants;
import com.somnus.smart.service.common.enums.AccountType;
import com.somnus.smart.support.common.MsgCodeList;
import com.somnus.smart.support.exceptions.BizException;
import com.somnus.smart.support.util.DateUtil;

@Service
public class FreezeServiceImpl implements FreezeService {

    @Resource
    private BasBizService 			basbizService;
    
    @Autowired
    private MessageSourceAccessor 	msa;

    @Override
    public FreezeTransaction createFreezeTransaction(AccountFreezeRequest request) {
        FreezeTransaction freezeTransaction = FreezeTransaction.getInstance();
        freezeTransaction.setAppTranNo(request.getAppFreezeNo());
        freezeTransaction.setBizType(request.getBizType());
        freezeTransaction.setCcyCode(request.getCcyCode());
        freezeTransaction.setCreateBy(ReticketConstants.DEFAULT_OPERATOR);
        freezeTransaction.setCreateTime(DateUtil.getCurrentTimeStamp());
        freezeTransaction.setFreezeType(ReticketConstants.FREEZE_TYPE_CUR);
        freezeTransaction.setStatus(ReticketConstants.FREEZE_STATUS_FREEZE);
        freezeTransaction.setMerAccCode(request.getMerAccCode());
        freezeTransaction.setVoucherNo(request.getVoucherNo());
        freezeTransaction.setTranAmt(request.getTranAmt());
        freezeTransaction.setThawAmt(BigDecimal.ZERO);
        freezeTransaction.setModifyBy(freezeTransaction.getCreateBy());
        freezeTransaction.setModifyTime(freezeTransaction.getCreateTime());
        freezeTransaction.setInitialFreezeType(freezeTransaction.getFreezeType());
        return freezeTransaction;
    }

    @Override
    @Transactional
    public void freezeDeal(FreezeTransaction freezeTransaction, CusSubaccinfo cusSubaccinfo) {
        // 落地冻结交易流水
        freezeTransaction.save();
        // 业务冻结,业务冻结余额增加，可用余额减少，账户余额不变
        if (BasConstants.FREEZE_BIZ_TYPE_BIZ.equals(freezeTransaction.getBizType())) {
            SubAccInfo.addBizFreezeBal(cusSubaccinfo.getSubAccCode(), freezeTransaction.getTranAmt());
        }
        // 监管冻结，监管冻结余额增加，可用余额减少，账户余额不变
        else if (BasConstants.FREEZE_BIZ_TYPE_MAG.equals(freezeTransaction.getBizType())) {
            SubAccInfo.addMagFreezeBal(cusSubaccinfo.getSubAccCode(), freezeTransaction.getTranAmt());
        }
        // 下发冻结
        else if (BasConstants.FREEZE_BIZ_TYPE_PAYABLE.equals(freezeTransaction.getBizType())) {//下发冻结
            //检查余额是否足额
            BigDecimal availBal = cusSubaccinfo.getAvailBal();
            if (availBal.compareTo(freezeTransaction.getTranAmt()) < 0) {
                throw new BizException(msa.getMessage(MsgCodeList.ERROR_304001, 
                		new Object[] {freezeTransaction.getMerAccCode()}));
            }
            SubAccInfo.addPayableFreezeBal(cusSubaccinfo.getSubAccCode(), freezeTransaction.getTranAmt());
        } else {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302033, new Object[] {}));
        }
    }

    @Override
    @Transactional
    public void unFreezeDeal(FreezeTransaction freezeTransaction, CusSubaccinfo cusSubaccinfo, BigDecimal tranAmt) {
        //解冻金额=原解冻金额+请求解冻金额
        freezeTransaction.setThawAmt(freezeTransaction.getThawAmt().add(tranAmt));
        //如果解冻金额等于冻结金额，更新状态为已解冻
        if (freezeTransaction.getThawAmt().compareTo(freezeTransaction.getTranAmt()) == 0) {
            freezeTransaction.setStatus(ReticketConstants.FREEZE_STATUS_UNFREEZE);
        }
        //更新冻结流水
        freezeTransaction.update();
        if (BasConstants.FREEZE_BIZ_TYPE_BIZ.equals(freezeTransaction.getBizType())) {
            //业务冻结余额解冻，可用余额增加，业务冻结余额减少
            SubAccInfo.subtractBizFreezeBal(cusSubaccinfo.getSubAccCode(), tranAmt);
        } else if (BasConstants.FREEZE_BIZ_TYPE_MAG.equals(freezeTransaction.getBizType())) {
            //监管冻结余额解冻，可用余额增加，监管冻结余额减少
            SubAccInfo.subtractMagFreezeBal(cusSubaccinfo.getSubAccCode(), tranAmt);
        } else if (BasConstants.FREEZE_BIZ_TYPE_PAYABLE.equals(freezeTransaction.getBizType())) {//下发解冻
            SubAccInfo.subtracPayableFreezeBal(cusSubaccinfo.getSubAccCode(), freezeTransaction.getTranAmt());
        } else {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302033, new Object[] {}));
        }
    }

    @Override
    @Transactional
    public void tranFreezeDeal(FreezeTransaction freezeTransaction, Transaction transaction) {
        // 落地冻结交易
        freezeTransaction.save();
        if (ReticketConstants.FREEZE_TYPE_CUR.equals(freezeTransaction.getFreezeType())) {
            // 资金户校验
            CusSubaccinfo cusSubaccinfo = basbizService.getCusSubaccinfo(AccountType.BIZ,
                ReticketConstants.REL_SUB_CODE_FREE.concat(freezeTransaction.getMerAccCode()), freezeTransaction.getMerAccCode(),
                freezeTransaction.getCcyCode());
            if (cusSubaccinfo == null) {
                throw new BizException(msa.getMessage(MsgCodeList.ERROR_302034, new Object[] {}));
            }
            // 增加业务冻结金额
            SubAccInfo.addBizFreezeBal(cusSubaccinfo.getSubAccCode(), freezeTransaction.getTranAmt());
        }
        //冻结交易，更新流水冻结标识
        transaction.setFrozenFlag(BasConstants.FROZEN_YES);
        transaction.setModifyTime(DateUtil.getCurrentTimeStamp());
        transaction.update();
    }

    @Override
    @Transactional
    public void tranUnFreezeDeal(FreezeTransaction freezeTransaction, Transaction transaction) {
        //更新冻结交易状态
        freezeTransaction.setThawAmt(freezeTransaction.getTranAmt());
        freezeTransaction.setStatus(ReticketConstants.FREEZE_STATUS_UNFREEZE);
        freezeTransaction.update();
        //余额解冻
        if(ReticketConstants.FREEZE_TYPE_CUR.equals(freezeTransaction.getFreezeType())){
            CusSubaccinfo cusSubaccinfo = basbizService.getCusSubaccinfo(AccountType.BIZ,ReticketConstants.REL_SUB_CODE_FREE.concat(freezeTransaction.getMerAccCode()), freezeTransaction.getMerAccCode(), freezeTransaction.getCcyCode());
            if(cusSubaccinfo == null){
                throw new BizException(msa.getMessage(MsgCodeList.ERROR_302033, new Object[] {}));
            }
            SubAccInfo.subtractBizFreezeBal(cusSubaccinfo.getSubAccCode(), freezeTransaction.getTranAmt());
        }
        //解冻交易，更新流水冻结标识
        transaction.setFrozenFlag(BasConstants.FROZEN_NO);
        transaction.setModifyTime(DateUtil.getCurrentTimeStamp());
        transaction.update();
    }
    
    @Override
    public void checkTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302035, new Object[] {}));
        }
        if (BasConstants.FROZEN_YES.equals(transaction.getFrozenFlag())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302036, new Object[] {}));
        }
        if (BasConstants.STATUS_REFUND.equals(transaction.getStatus())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302037, new Object[] {}));
        }
        if (BasConstants.STATUS_REFUSE.equals(transaction.getStatus())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302038, new Object[] {}));
        }
    }

    @Override
    public FreezeTransaction createFreezeTransaction(TranFreezeRequest request, Transaction transaction) {
        FreezeTransaction freezeTransaction = FreezeTransaction.getInstance();
        freezeTransaction.setAppTranNo(request.getAppFreezeNo());

        freezeTransaction.setBizType(ReticketConstants.FREEZE_BIZ_TYPE_BIZ);
        freezeTransaction.setCcyCode(transaction.getCcyCode());
        freezeTransaction.setCreateBy(ReticketConstants.DEFAULT_OPERATOR);
        freezeTransaction.setCreateTime(DateUtil.getCurrentTimeStamp());
        freezeTransaction.setStatus(ReticketConstants.FREEZE_STATUS_FREEZE);
        freezeTransaction.setMerAccCode(transaction.getPayeeAccCode());
        freezeTransaction.setVoucherNo(request.getAppTranNo());
        //冻结订单金额
        freezeTransaction.setTranAmt(transaction.getOrdAmt());
        freezeTransaction.setModifyBy(freezeTransaction.getCreateBy());
        freezeTransaction.setModifyTime(freezeTransaction.getCreateTime());
        freezeTransaction.setThawAmt(BigDecimal.ZERO);
        freezeTransaction.setInitialFreezeType(ReticketConstants.FREEZE_TYPE_TRAN);

        if (ReticketConstants.BLN_STATUS_ENTERED.equals(transaction.getBlnStatus())) {
            freezeTransaction.setFreezeType(ReticketConstants.FREEZE_TYPE_CUR);
        } else if (ReticketConstants.BLN_STATUS_NOTENTER.equals(transaction.getBlnStatus())) {
            freezeTransaction.setFreezeType(ReticketConstants.FREEZE_TYPE_TRAN);
        }

        return freezeTransaction;
    }

}
