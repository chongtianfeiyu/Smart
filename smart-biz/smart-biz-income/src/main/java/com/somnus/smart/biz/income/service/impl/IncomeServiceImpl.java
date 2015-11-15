package com.somnus.smart.biz.income.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.smart.base.domain.MerBasicPrdCfg;
import com.somnus.smart.biz.income.common.CancelReverseTransfer;
import com.somnus.smart.biz.income.common.DepositTransfer;
import com.somnus.smart.biz.income.common.IncomeConstants;
import com.somnus.smart.biz.income.common.IncomeTransfer;
import com.somnus.smart.biz.income.service.IncomeService;
import com.somnus.smart.domain.account.Account;
import com.somnus.smart.domain.account.Transaction;
import com.somnus.smart.message.account.CancelReverseRequest;
import com.somnus.smart.message.account.DepositRequest;
import com.somnus.smart.message.account.IncomeRequest;
import com.somnus.smart.message.account.IpsPayRequest;
import com.somnus.smart.service.BasBizService;
import com.somnus.smart.service.common.BasConstants;
import com.somnus.smart.service.common.enums.AccountType;
import com.somnus.smart.support.exceptions.BizException;

/**
 * 收单记账业务处理器实现
 */
@Component
public class IncomeServiceImpl implements IncomeService {

    @Resource
    private BasBizService basBizService;

    @Override
    public Transaction createTransaction(IncomeRequest incomeRequest) throws Exception {
        //根据收款方账号、产品码、系统编号查询商户基础产品配置
        MerBasicPrdCfg merBasicPrdCfg = basBizService.getMerBasicPrdCfg(
        		incomeRequest.getPayeeAccCode(), 
        		incomeRequest.getPrdCode(), 
        		incomeRequest.getSysCode().substring(0, 2));//系统编号需要截取前两位，无特殊含义
        if (merBasicPrdCfg == null) {
            throw new BizException("交易账户号" + incomeRequest.getPayeeAccCode() 
            		+ "基础产品" + incomeRequest.getPrdCode() + "配置信息不存在");
        }
        Transaction transaction = IncomeTransfer.msgToTransaction(incomeRequest);
        // 设置当前帐务日期
        transaction.setAccDate(basBizService.getSystemAccDate());
        transaction.setAccTranNo(basBizService.getAccTranNo());
        //设置是否为保证金交易、保证金缴纳状态、保证金返还时间
        if (null != transaction.getSecurityDeposit() && transaction.getSecurityDeposit().
        		compareTo(new BigDecimal(0)) > 0) {
            transaction.setIsDeposit(IncomeConstants.IS_DEPOSIT_TRUE);
            transaction.setDepositStatus(IncomeConstants.DEPOSIT_STATUS_NOTGATHER);
            transaction.setDepositRefundDate(DateUtils.addDays(transaction.getAccDate(), 
            		incomeRequest.getDepositDeadLine()));
        } else {
            transaction.setIsDeposit(IncomeConstants.IS_DEPOSIT_FALSE);
        }
        //设置入账模式、预计入账日期、预计入账时间
        basBizService.blnRelaSet(transaction, merBasicPrdCfg);
        return transaction;
    }
    
    @Override
    public Transaction createDepositTran(DepositRequest depositRequest) throws Exception {
        Transaction transaction = DepositTransfer.msgToTransaction(depositRequest);
        // 设置当前帐务日期
        transaction.setAccDate(basBizService.getSystemAccDate());
        transaction.setAccTranNo(basBizService.getAccTranNo());
        return transaction;
    }

    /**
     * 创建撤销冲正记账交易流水
     * 
     * @param cancelReverseRequest
     * @return
     */
    public Transaction createCancelReverseTran(CancelReverseRequest cancelReverseRequest) throws Exception {
        //根据收款方账号、产品码、系统编号查询商户基础产品配置
        MerBasicPrdCfg merBasicPrdCfg = basBizService.getMerBasicPrdCfg(
        		cancelReverseRequest.getPayeeAccCode(), 
        		cancelReverseRequest.getPrdCode(),
        		cancelReverseRequest.getSysCode().substring(0, 2));//系统编号需要截取前两位，无特殊含义
        if (merBasicPrdCfg == null) {
            throw new BizException("交易账户号" + cancelReverseRequest.getPayeeAccCode() 
            		+ "基础产品" + cancelReverseRequest.getPrdCode() + "配置信息不存在");
        }
        Transaction transaction = CancelReverseTransfer.msgToTransaction(cancelReverseRequest);
        //设置当前帐务日期
        transaction.setAccDate(basBizService.getSystemAccDate());
        //原交易系统编号赋值
        transaction.setSysCode(cancelReverseRequest.getSysCode());
        // 设置记账流水号
        transaction.setAccTranNo(basBizService.getAccTranNo());

        //设置是否保证金
        if (null != transaction.getSecurityDeposit() 
        		&& transaction.getSecurityDeposit().compareTo(new BigDecimal(0)) > 0) {
            transaction.setIsDeposit(BasConstants.IS_DEPOSIT_TRUE);
            transaction.setDepositStatus(BasConstants.DEPOSIT_STATUS_NOTGATHER);
            transaction.setDepositRefundDate(DateUtils.addDays(transaction.getAccDate(), 
            		cancelReverseRequest.getDepositDeadLine()));
        } else {
            transaction.setIsDeposit(BasConstants.IS_DEPOSIT_FALSE);
        }

        // 4设置入账模式、预计入账日期、预计入账时间
        basBizService.blnRelaSet(transaction, merBasicPrdCfg);
        return transaction;
    }

    /**
     * 
     * @see com.somnus.smart.biz.income.service.IncomeService#createIPSPayTran(com.somnus.smart.message.account.IpsPayRequest)
     */
    public Transaction createIPSPayTran(IpsPayRequest ipsPayRequest) throws Exception {
        Transaction transaction = IncomeTransfer.msgToTransaction(ipsPayRequest);
        // 设置当前帐务日期
        transaction.setAccDate(basBizService.getSystemAccDate());
        // 设置记账流水号
        transaction.setAccTranNo(basBizService.getAccTranNo());
        return transaction;
    }

    @Override
    public void checkMerAccAndMerSub(String payeeCode, String payeeAccCode, String supplierCode, String bankAccCode) {
        boolean merAccountIsExist = basBizService.checkMerAccountIsExist(payeeCode, payeeAccCode);
        if (!merAccountIsExist) {
            throw new BizException(payeeAccCode + "商户账户信息不存在!");
        }
        //校验应收银行科目
        boolean bandAccCodeIsExist = basBizService.checkCusSubaccinfoIsExits(AccountType.INT,
        		BasConstants.REL_SUB_CODE_BANK + supplierCode + bankAccCode);
        if (!bandAccCodeIsExist) {
            throw new BizException(payeeAccCode + "应收银行未开户!");
        }

        //校验流动资金科目
        boolean merSubAccCodeIsExist = basBizService.checkCusSubaccinfoIsExits(AccountType.BIZ,
        		BasConstants.REL_SUB_CODE_FREE + payeeAccCode);
        if (!merSubAccCodeIsExist) {
            throw new BizException(payeeAccCode + "商户交易账户未开户!");
        }
    }
    
    @Override
    public void checkPerAccAndPerSub(String payeeAccCode, String supplierCode, 
    		String bankAccCode,String feeWay, String thirdAccCode) {
        boolean perAccountIsExist = basBizService.checkPerAccountIsExist(payeeAccCode);
        if (!perAccountIsExist) {
            throw new BizException(payeeAccCode + "个人账户信息不存在!");
        }
        //校验应收银行科目
        boolean bandAccCodeIsExist = basBizService.checkCusSubaccinfoIsExits(AccountType.INT,
        		BasConstants.REL_SUB_CODE_BANK + supplierCode + bankAccCode);
        if (!bandAccCodeIsExist) {
            throw new BizException(payeeAccCode + "应收银行未开户!");
        }

        //校验流动资金科目
        boolean perSubAccCodeIsExist = basBizService.checkCusSubaccinfoIsExits(AccountType.IDV,
        		BasConstants.REL_SUB_CODE_FREE + payeeAccCode);
        if (!perSubAccCodeIsExist) {
            throw new BizException(payeeAccCode + "个人交易账户未开户!");
        }
        //手续费收取方式为第三方时校验第三方账号
        if (BasConstants.FEE_FLAG_THD.equals(feeWay)) {
            if (StringUtils.isBlank(thirdAccCode)) {
                throw new BizException("手续费收取方式为第三方时,第三方手续费账号不能为空!");
            }
            basBizService.accountExists(thirdAccCode);
        }
    }

    /**
     * 校验手续费相关的参数
     * 
     * @param feeStlMode
     * @param sysCode
     * @param feeWay
     * @param thirdAccCode
     */
    public void checkFee(String feeStlMode, String sysCode, String feeWay, String thirdAccCode) throws Exception {
        //如果是POSP撤销冲正，手续费承担方必须是收款方
        if (BasConstants.POST_SYS_CODE.equals(sysCode) && !BasConstants.FEE_FLAG_REC.equals(feeWay)) {
            throw new BizException("POSP收单交易手续费承担方必须为收款方!");
        }
        //非POS撤销冲正
        else {
            //如果手续费承担发是付款方或者是第三方，手续费结算模式必须是实时结算
            if (feeWay.equals(BasConstants.FEE_FLAG_PAY) || feeWay.equals(BasConstants.FEE_FLAG_THD)) {
                if (!feeStlMode.equals(BasConstants.FEE_STL_MODE_TRAN)) {
                    throw new BizException("手续费承担方(feeWay)为付款方(1)或第三方(3)时手续费结算模式(feeStlMode)必须为实时清算(1)");
                }
                //手续费收取方式为第三方时校验第三方账号
                if (BasConstants.FEE_FLAG_THD.equals(feeWay)) {
                    if (StringUtils.isBlank(thirdAccCode)) {
                        throw new BizException("手续费收取方式为第三方时,第三方手续费账号不能为空!");
                    }
                    basBizService.accountExists(thirdAccCode);
                }
            }
        }
    }

    @Override
    @Transactional
    public void incomeSynAccount(Transaction transaction, String entryKey, Date accDate, boolean checkRed) 
    		throws Exception {
        if (transaction == null) {
            throw new BizException("交易流水不能为空！");
        }
        Account account = Account.getInstance();
        account.synAccount(transaction, entryKey, accDate, checkRed, null);
    }
    
    @Override
    @Transactional
    public void depositSynAccount(Transaction transaction, String entryKey, Date accDate, boolean checkRed) 
    		throws Exception {
        if (transaction == null) {
            throw new BizException("交易流水不能为空！");
        }
        Account account = Account.getInstance();
        account.synAccount(transaction, entryKey, accDate, checkRed, null);
    }

    @Override
    public void ipsPayAccount(Transaction transaction, String entryKey, Date accDate, boolean checkRed) 
    		throws Exception {
        if (transaction == null) {
            throw new BizException("交易流水不能为空！");
        }
        Account account = Account.getInstance();
        account.ipsPayAccount(transaction, entryKey, accDate, checkRed);
    }

    @Override
    public void incomeAsynAccount(Transaction transaction, String entryKey, Date accDate, boolean checkRed) 
    		throws Exception {
        if (transaction == null) {
            throw new BizException("交易流水不能为空！");
        }
        Account account = Account.getInstance();
        account.asynAccount(transaction, entryKey, accDate, checkRed);
    }

	@Override
	public void depositBizCheck(DepositRequest depositRequest) {
        //1、数据合法性校验
        checkPerAccAndPerSub(depositRequest.getPayeeAccCode(), depositRequest.getSupplierCode(),
        		depositRequest.getBankAccCode(),depositRequest.getFeeWay(),depositRequest.getThdAccCode());
        //2、手續費如果是第三方承擔手续费校验第三方账户是否存在
        if(depositRequest.getFeeWay().equals(BasConstants.FEE_FLAG_THD)){
        	if (StringUtils.isBlank(depositRequest.getThdAccCode())) {
                throw new BizException("手续费收取方式为第三方时,第三方手续费账号不能为空!");
            }
        	basBizService.accountExists(depositRequest.getThdAccCode());
        }
	}

}
