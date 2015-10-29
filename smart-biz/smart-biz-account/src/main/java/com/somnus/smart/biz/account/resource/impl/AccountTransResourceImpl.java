package com.somnus.smart.biz.account.resource.impl;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.somnus.smart.base.domain.TrnTransaction;
import com.somnus.smart.biz.account.resource.AccountTransResource;
import com.somnus.smart.biz.account.service.AccountService;
import com.somnus.smart.domain.account.AccEntryCfg;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.AccountTransRequest;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.service.common.MessageUtil;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.exceptions.BizException;

/**
 * 账户转账记账接口
 * 
 * @author 李太平
 * @version $Id: AccountTransResourceNewImpl.java, v 0.1 2014-11-28 下午02:14:02 李太平  Exp $
 */
@Component
@Validated
@Path("/com.somnus.smart.biz.account.resource.AccountTransResource")
public class AccountTransResourceImpl implements AccountTransResource {

    protected static Logger log = LoggerFactory.getLogger(AccountTransResourceImpl.class);


    @Resource
    private AccountService  accountService;

    @Path("/accountTrans")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public AccountResponse accountTrans(AccountTransRequest request) {
        log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
        AccountResponse repMsg = new AccountResponse();
        try {
            // 1、重复记账检查
            Transaction queryTransaction = Transaction.selectByAppTranNo(request.getAppTranNo());
            if (queryTransaction != null) {
                setRepMsg(repMsg, queryTransaction);
                log.info(Constants.REPONSE_MSG, JsonUtils.toString(repMsg));
                return repMsg;
            }
            // 2、业务校验
            accountService.checkCanTrans(request.getPayerType(), request.getPayerCode(), request.getPayerAccCode(),request.getPayeeType(),request.getPayeeCode(),request.getPayeeAccCode(),request.getCcyCode(),request.getTranAmt());
            
            // 3、创建记账交易流水
            Transaction transaction = accountService.createTransaction(request);
            
            // 4、获取entryKey
            String entryKey = AccEntryCfg.getEntryKeyByTranCode(request.getTranCode(), transaction.getFeeFlag() , transaction.getFeeStlMode(),null);
            
            // 5、账户同步记账
            accountService.accountSysAccount(transaction, entryKey, transaction.getAccDate(), true);

            setRepMsg(repMsg, transaction);
        } catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            MessageUtil.errRetrunInAction(repMsg, e);
        } catch (Exception ex) {
            log.error(Constants.EXCEPTION_ERROR, ex);
            // 组织错误报文
            MessageUtil.createErrorMsg(repMsg);
        }
        log.info(Constants.REPONSE_MSG, JsonUtils.toString(repMsg));
        return repMsg;
    }

    private void setRepMsg(AccountResponse repMsg, TrnTransaction trntransaction) {
        MessageUtil.createCommMsg(repMsg);
        repMsg.setAccDate(trntransaction.getAccDate());
        repMsg.setAccTranNo(trntransaction.getAccTranNo());
        repMsg.setAppTranNo(trntransaction.getAppTranNo());
    }

}
