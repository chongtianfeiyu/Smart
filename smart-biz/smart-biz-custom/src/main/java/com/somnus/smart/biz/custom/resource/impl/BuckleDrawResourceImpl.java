package com.somnus.smart.biz.custom.resource.impl;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.base.domain.TrnTransaction;
import com.somnus.smart.biz.custom.common.ReticketConstants;
import com.somnus.smart.biz.custom.resource.BuckleDrawResource;
import com.somnus.smart.biz.custom.service.BuckleDrawService;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.custom.BuckleDrawRequest;
import com.somnus.smart.service.BasBizService;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.service.common.MessageUtil;
import com.somnus.smart.service.common.enums.AccountType;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.exceptions.BizException;


/**
 * 扣划记账接口
 * 
 * @author 李太平
 * @version $Id: BuckleDrawResourceNewImpl.java, v 0.1 2014-11-24 下午02:25:32 李太平 Exp $
 */
@Component
@Validated
@Path("/com.somnus.smart.biz.custom.resource.BuckleDrawResource")
public class BuckleDrawResourceImpl implements BuckleDrawResource {

    private transient Logger  log = LoggerFactory.getLogger(this.getClass());

    /** 核销接口 */
    @Resource
    private BuckleDrawService buckleDrawService;

    @Resource
    private BasBizService     basbizService;

    /**
     * 扣划（流动资金->扣划总户）
     * 
     * @param request
     * @return
     */
    @Path("/buckleDraw")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public AccountResponse buckleDraw(BuckleDrawRequest request) {
        log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
        AccountResponse repMsg = new AccountResponse();
        try {
            // 1、重复记账校验
            Transaction queryTransaction = Transaction.selectByAppTranNo(request.getAppTranNo());
            if (queryTransaction != null) {
                log.info("重复记账：{}", request.getAppTranNo());
                setRepMsg(repMsg, queryTransaction);
                return repMsg;
            }

            // 2、创建记账交易流水
            Transaction transaction = buckleDrawService.createTransaction(request);

            // 3、校验商户的流动资金户
            CusSubaccinfo cusSubaccinfo = basbizService.getCusSubaccinfo(AccountType.BIZ,ReticketConstants.REL_SUB_CODE_FREE.concat(transaction.getPayerAccCode()),
                transaction.getPayerAccCode(), transaction.getCcyCode());
            if (cusSubaccinfo == null) {
                throw new BizException("流动资金账户为空！");
            }
            // 4、扣划记账
            buckleDrawService.buckDrawSynAccount(transaction,request,cusSubaccinfo.getSubAccCode());
            
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
