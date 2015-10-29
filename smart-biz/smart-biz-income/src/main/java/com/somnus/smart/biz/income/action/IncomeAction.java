package com.somnus.smart.biz.income.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.smart.biz.income.common.IncomeConstants;
import com.somnus.smart.biz.income.service.IncomeService;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.support.exceptions.BizException;
import com.somnus.smart.support.jms.AbstractJmsReceiveTemplate;

/**
 * 收单交易异步记账处理
 * 
 * @author 李太平
 * @version $Id: IncomeActionNew.java, v 0.1 2014-11-17 上午08:50:00 李太平 Exp $
 */
public class IncomeAction extends AbstractJmsReceiveTemplate {

    protected Logger      LOGGER = LoggerFactory.getLogger(this.getClass());

    @Resource
    private IncomeService incomeService;

    @Override
    protected void execute(Object message) throws Exception {
        LOGGER.info("-------收单记账调用开始--------");
        LOGGER.info("接收消息：{}", message);
        if (!(message instanceof Transaction)) {
            throw new BizException("报文对象不匹配！");
        }
        try {
            Transaction transaction = (Transaction) message;
            //异步记账
            incomeService.incomeAsynAccount(transaction, IncomeConstants.ENTRY_KEY_INCOME_PRE + transaction.getBlnMode() + transaction.getFeeFlag()
                                                   + transaction.getFeeStlMode(), transaction.getAccDate(), false);
        } catch (BizException e) {
            LOGGER.error(Constants.BUSINESS_ERROR, e);
        } catch (Exception ex) {
            LOGGER.error(Constants.EXCEPTION_ERROR, ex);
        }
        LOGGER.info("-------收单记账调用结束--------");
    }
}
