package com.somnus.smart.biz.custom.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.smart.base.domain.DiffTraninfo;
import com.somnus.smart.biz.custom.service.AddAccountService;
import com.somnus.smart.domain.account.Account;
import com.somnus.smart.domain.account.AccountCallBack;
import com.somnus.smart.domain.account.LedgerDetail;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.service.BasBizService;
import com.somnus.smart.service.common.BasConstants;
import com.somnus.smart.support.exceptions.BizException;
import com.somnus.smart.support.util.DateUtil;

@Service
public class AddAccountServiceImpl implements AddAccountService {

    private transient Logger                       log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BasBizService                          basBizService;

    @Override
    @Transactional
    public void addAccount(String errNo) throws Exception {
        if (errNo == null || "".equals(errNo.trim())) {
            throw new BizException("errNo为空！");
        }
        DiffTraninfo diffTraninfo = basBizService.selectDiffTraninfoByPrimaryKey(errNo);
        
        if(diffTraninfo==null){
            throw new BizException("差异不存在！");
        }
        log.info(">>>> 错误流水: {}开始", new Object[] { diffTraninfo.getErrTranNo() });
        if(BasConstants.DIFF_TRANINFO_STATUS_YES.equals(diffTraninfo.getStatus())){
            return;
        }
        try {
            if (BasConstants.DIFF_TRANINFO_ERR_KIND_TRAN.equals(diffTraninfo.getErrKind())) {
                Transaction transaction = Transaction.selectByAccTranNo(diffTraninfo
                    .getErrTranNo());
                if (transaction != null) {
                    Account account=Account.getInstance();
                    AccountCallBack callBack=new AccountCallBack() {
                        
                        @Override
                        public Object callBack() {
                            return null;
                        }
                    };
                    account.addAccount(transaction, BasConstants.ENTRY_KEY_INCOME_PRE + transaction.getBlnMode()
                                + transaction.getFeeFlag() + transaction.getFeeStlMode(), transaction.getAccDate(), false, callBack);
                } else {
                    throw new BizException("记账流水:" + diffTraninfo.getErrTranNo() + "不存在");
                }
            } else if (BasConstants.DIFF_TRANINFO_ERR_KIND_LEDGER.equals(diffTraninfo.getErrKind())) {
                LedgerDetail ledgerDetail = LedgerDetail.getInstance();
                ledgerDetail = ledgerDetail.selectByPrimaryKey(diffTraninfo.getErrTranNo());
                if (ledgerDetail != null) {
                    ledgerDetail.setAccDate(basBizService.getSystemAccDate());
                    Account account=Account.getInstance();
                    account.addAccount(false, ledgerDetail);
                } else {
                    throw new BizException("台账:" + diffTraninfo.getErrTranNo() + "不存在");
                }
            }
            diffTraninfo.setStatus(BasConstants.DIFF_TRANINFO_STATUS_YES);
            diffTraninfo.setModifyTime(DateUtil.getCurrentTimeStamp());
            basBizService.updateDiffTraninfoByPrimaryKey(diffTraninfo);
        } catch (BizException e) {
            log.error("流水号：" + diffTraninfo.getErrTranNo() + "不记账异常，", e);
            throw e;
        } catch (Exception e) {
            log.error("流水号：" + diffTraninfo.getErrTranNo() + "不记账异常，", e);
            throw e;
        }
    }
}
