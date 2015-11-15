package com.somnus.smart.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.somnus.smart.base.dao.CusSubAccInfoDao;
import com.somnus.smart.service.CoreService;
import com.somnus.smart.service.common.CusSubAccInfoUtil;
import com.somnus.smart.service.common.enums.AccountType;
import com.somnus.smart.support.exceptions.BizException;

@Component
public class CoreServiceImpl implements CoreService {


    @Autowired
    private CusSubAccInfoDao cusSubAccInfoDao;

    @Override
    public void addBizFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt) {
        cusSubAccInfoDao.addBizFreezeBal(CusSubAccInfoUtil.getTableByAccountType(accountType),subAccCode, tranAmt);
    }

    @Override
    public void subtractBizFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt) {
        int count = cusSubAccInfoDao.addBizFreezeBal(CusSubAccInfoUtil.getTableByAccountType(accountType),subAccCode, tranAmt.multiply(new BigDecimal(-1)));
        if (count == 0) {
            throw new BizException("解冻失败,解冻金额超额");
        }
    }

    @Override
    public void addMagFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt) {
        cusSubAccInfoDao.addMagFreezeBal(CusSubAccInfoUtil.getTableByAccountType(accountType),subAccCode, tranAmt);
    }

    @Override
    public void subtractMagFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt) {
        int count = cusSubAccInfoDao.addMagFreezeBal(CusSubAccInfoUtil.getTableByAccountType(accountType),subAccCode, tranAmt.multiply(new BigDecimal(-1)));
        if (count == 0) {
            throw new BizException("解冻失败,解冻金额超额");
        }
    }

    /**
     * 新增应付冻结金额
     * 
     * @param subAccCode
     * @param tranAmt
     */
    public void addPayableFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt) {
        int count = cusSubAccInfoDao.addPayableFreezeBal(CusSubAccInfoUtil.getTableByAccountType(accountType),subAccCode, tranAmt);
        if (count == 0) {
            throw new BizException("账户余额不足");
        }
    }

    /**
     * 减少应付冻结金额
     * 
     * @param subAccCode
     * @param tranAmt
     */
    public void subtracPayableFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt) {
        int count = cusSubAccInfoDao.addPayableFreezeBal(CusSubAccInfoUtil.getTableByAccountType(accountType),subAccCode, tranAmt.multiply(new BigDecimal(-1)));
        if (count == 0) {
            throw new BizException("解冻失败,解冻金额超额");
        }
    }

}
