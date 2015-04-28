package com.somnus.smart.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import com.somnus.smart.base.dao.CusSubAccInfoDao;
import com.somnus.smart.base.dao.DaySystemDao;
import com.somnus.smart.base.dao.DiffTraninfoDao;
import com.somnus.smart.base.dao.MerAccountDao;
import com.somnus.smart.base.dao.PerAccountDao;
import com.somnus.smart.base.dao.PrdRecognizeDelayDao;
import com.somnus.smart.base.dao.TrnDrawDao;
import com.somnus.smart.base.dao.TrnRefundDao;
import com.somnus.smart.base.dao.TrnTranIssuedDao;
import com.somnus.smart.base.dao.TrnTranReverseDao;
import com.somnus.smart.base.dao.TrnTransactionDao;
import com.somnus.smart.base.dao.TrnTransactionHisDao;
import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.base.domain.DaySystem;
import com.somnus.smart.base.domain.DiffTraninfo;
import com.somnus.smart.base.domain.MerAccount;
import com.somnus.smart.base.domain.MerBasicPrdCfg;
import com.somnus.smart.base.domain.MerMerchant;
import com.somnus.smart.base.domain.PerAccount;
import com.somnus.smart.base.domain.PrdRecognizeDelay;
import com.somnus.smart.base.domain.TrnDraw;
import com.somnus.smart.base.domain.TrnRefund;
import com.somnus.smart.base.domain.TrnTranIssued;
import com.somnus.smart.base.domain.TrnTranReverse;
import com.somnus.smart.base.domain.TrnTransaction;
import com.somnus.smart.base.domain.TrnTransactionHis;
import com.somnus.smart.service.BasBizService;
import com.somnus.smart.service.common.BasConstants;
import com.somnus.smart.service.common.CusSubAccInfoUtil;
import com.somnus.smart.service.common.enums.AccStatus;
import com.somnus.smart.service.common.enums.AccountType;
import com.somnus.smart.service.common.enums.FundStatus;
import com.somnus.smart.service.component.cache.BasAccountCache;
import com.somnus.smart.service.component.cache.MerAccountCache;
import com.somnus.smart.service.component.cache.MerMerchantCache;
import com.somnus.smart.support.common.MsgCodeList;
import com.somnus.smart.support.exceptions.BizException;
import com.somnus.smart.support.util.ValidateUtil;

/**
 * 
 * @author IH745
 * @date 2013-10-09
 * 
 */
@Component
public class BasBizServiceImpl implements BasBizService {

    private final Logger          log = LoggerFactory.getLogger(this.getClass());
    /** msa */
    @Autowired
    private MessageSourceAccessor msa;
    /** trnTransactionDao */
    @Autowired
    private TrnTransactionDao     trnTransactionDao;
    /** merAccountCache */
    @Autowired
    private MerAccountCache       merAccountCache;
    /** basAccountCache */
    @Autowired
    private BasAccountCache       basAccountCache;
    /** daySystemDao */
    @Autowired
    private DaySystemDao          daySystemDao;
    /** merMerchantCache */
    @Autowired
    private MerMerchantCache      merMerchantCache;
    /** perAccountDao */
    @Autowired
    private PerAccountDao         perAccountDao;
    /** cusSubAccInfoDao */
    @Autowired
    private CusSubAccInfoDao      cusSubAccInfoDao;
    /** trnTranIssuedDao */
    @Autowired
    private TrnTranIssuedDao      trnTranIssuedDao;
    /** prdRecognizeDelayDao */
    @Autowired
    private PrdRecognizeDelayDao  prdRecognizeDelayDao;
    /** trnTransactionHisDao */
    @Autowired
    private TrnTransactionHisDao  trnTransactionHisDao;
    /** trnDrawDao */
    @Autowired
    private TrnDrawDao            trnDrawDao;
    /** trnDrawDao */
    @Autowired
    private TrnRefundDao          trnRefundDao;
    /** merAccountDao */
    @Autowired
    private MerAccountDao         merAccountDao;
    /** trnTranReverseDao */
    @Autowired
    private TrnTranReverseDao     trnTranReverseDao;
    /** diffTraninfoDao */
    @Autowired
    private DiffTraninfoDao       diffTraninfoDao;

    @Override
    public TrnRefund queryRefundFlagByApp(String appTranNo) {
        return trnRefundDao.selectByAppFlag(appTranNo);
    }

    @Override
    public TrnDraw queryDrawFlagByApp(String appTranNo) {
        return trnDrawDao.selectByAppFlag(appTranNo);
    }

    @Override
    public TrnDraw queryDrawFlagById(String drawId) {
        return trnDrawDao.selectByFlag(drawId);
    }

    @Override
    public TrnTransaction selectSuccessTranByAppTranNo(String appTranNo) {
        return trnTransactionDao.selectSuccessTranByAppTranNo(appTranNo);
    }

    @Override
    public TrnTranIssued queryIssuedByAppStatus(String appTranNo) {
        return trnTranIssuedDao.selectByAppStatus(appTranNo);
    }

    @Override
    public TrnTransaction queryTransaction(String appTranNo) {
        //查询交易流水
        TrnTransaction tran = trnTransactionDao.selectByAppTranNo(appTranNo);
        //交易流水存在则直接返回
        if (tran != null) {
            return tran;
        }
        //交易流水不存在则查询历史交易流水
        TrnTransactionHis tranhis = trnTransactionHisDao.selectByAppTranNo(appTranNo);
        //历史交易流水不存在则返回空
        if (tranhis == null) {
            return null;
        }
        //历史交易流水存在则将记录拷贝到交易流水对象并返回
        tran = new TrnTransaction();
        BeanUtils.copyProperties(tranhis, tran);
        return tran;
    }

    @Override
    public MerAccount getMerAccountNoCache(String merCode, String acctCode) {
        MerAccount merAccount = new MerAccount();
        merAccount.setMerCode(merCode);
        merAccount.setAcctCode(acctCode);
        return merAccountDao.selectByConstraints(merAccount);
    }

    @Override
    public MerAccount getMerAccount(String merCode, String acctCode) {
        MerAccount merAccount = new MerAccount();
        merAccount.setMerCode(merCode);
        merAccount.setAcctCode(acctCode);
        return merAccountCache.selectByConstraints(merAccount);
    }
    
    @Override
    public PerAccount getPerAccount(String accCode) {
        return perAccountDao.selectByAcctCode(accCode);
    }

    @Override
    public MerBasicPrdCfg getMerBasicPrdCfg(String acctCode, String basicPrdCode, String systemCode) {
        MerBasicPrdCfg basicprdcfg = new MerBasicPrdCfg();
        basicprdcfg.setAcctCode(acctCode);
        basicprdcfg.setBasicPrdCode(basicPrdCode);
        basicprdcfg.setSystemCode(systemCode);
        return basAccountCache.getMerBasicPrdCfg(basicprdcfg);
    }

    @Override
    public Date getSystemAccDate() {
        DaySystem daySystem = daySystemDao.getDaySystem(BasConstants.CORE_CUT_CODE);
        if (daySystem != null) {
            Date result = null;
            // 输出格式
            DateFormat outfomater = new SimpleDateFormat("yyyy-MM-dd");
            try {
                result = outfomater.parse(daySystem.getCoreDate());
            } catch (Exception e) {
                log.error("获取帐务日期出错");
                result = new Date();
            }
            return result;
        }
        return new Date();
    }

    @Override
    public MerMerchant getMerMerchant(String merCode) {
        return merMerchantCache.selectByMercode(merCode);
    }

    @Override
    public void checkAllowOut(String bizKind, String merCode, String merAccCode) {
        if (!isAccAllowOut(bizKind, merCode, merAccCode)) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_505017, new Object[] { merAccCode }));
        }
    }

    public boolean isAccAllowOut(String bizKind, String merCode, String merAccCode) {
        boolean isAllowOut = false;
        if (BasConstants.BIZ_KIND_CUS.equals(bizKind)) {//如果商户类型是商户
            //根据商户号和交易账户号获取商户信息
            MerAccount merAccount = getMerAccountNoCache(merCode, merAccCode);
            if (merAccount == null) {//商户不存在
                throw new BizException(msa.getMessage(MsgCodeList.ERROR_505016, new Object[] { merAccCode }));
            } else if (BasConstants.ALLOW_OUT_TRUE.equals(merAccount.getAllowOut())) {//如不允许出款
                isAllowOut = true;
            }
        } else {//如果商户类型是个人
            PerAccount perAccount = perAccountDao.selectByAcctCode(merAccCode);//根据交易账户号查询个人信息
            if (perAccount == null||!AccStatus.NORMAL.getCode().equals(perAccount.getAccStatus())) {
                throw new BizException(msa.getMessage(MsgCodeList.ERROR_505016, new Object[] { merAccCode }));
            } else if (FundStatus.CAN_IN_OUT.getCode().equals(perAccount.getFundStatus())
                       || FundStatus.CAN_OUT.getCode().equals(perAccount.getFundStatus())) {//如果允许出款
                isAllowOut = true;
            }
        }
        return isAllowOut;
    }

    @Override
    public boolean checkMerAccountIsExist(String merCode, String merAccCode) {
        MerAccount merAccount = getMerAccountNoCache(merCode, merAccCode);
        if (merAccount == null) {//商户不存在
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public boolean checkPerAccountIsExist(String accCode) {
        PerAccount perAccount = getPerAccount(accCode);
        if (perAccount == null) {//个人账户不存在
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public boolean checkCusSubaccinfoIsExits(AccountType accountType, String relSubCode) {
        CusSubaccinfo cusSubAccInfo = cusSubAccInfoDao.selectByRelSubCode(CusSubAccInfoUtil.getTableBySubType(accountType.getCode()), relSubCode);
        if (cusSubAccInfo == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 设置入账模式、预计入账日期、预计入账时间
     */
    @Override
    public void blnRelaSet(TrnTransaction trntransaction, MerBasicPrdCfg merBasicPrdCfg) {
        String accCode = null;
        String bizKind = null;
        String merCode = null;
        if (BasConstants.INITIATOR_FLG_REC.equals(trntransaction.getInitiatorFlg())) {
            accCode = trntransaction.getPayeeAccCode();
            bizKind = trntransaction.getPayeeType();
            merCode = trntransaction.getPayeeCode();
        } else {
            accCode = trntransaction.getPayerAccCode();
            bizKind = trntransaction.getPayerType();
            merCode = trntransaction.getPayerCode();
        }
        if (BasConstants.BIZ_KIND_PERSON.equals(bizKind)) {
            trntransaction.setBlnMode(BasConstants.BLN_MODE_NOW);
            trntransaction.setCanBlnDate(trntransaction.getAccDate());
            //			trntransaction.setCanBlnDate(new Date());
            Calendar estAccTime = Calendar.getInstance();
            Date accTime = trntransaction.getAccDate();
            Calendar accTimeC = Calendar.getInstance();
            accTimeC.setTime(accTime);
            estAccTime.set(Calendar.YEAR, accTimeC.get(Calendar.YEAR));
            estAccTime.set(Calendar.MONTH, accTimeC.get(Calendar.MONTH));
            estAccTime.set(Calendar.DAY_OF_YEAR, accTimeC.get(Calendar.DAY_OF_YEAR));
            trntransaction.setEstAccTime(estAccTime.getTime());
        } else {
            // T+0
            if (null == merBasicPrdCfg.getRecognizePeriod() || merBasicPrdCfg.getRecognizePeriod().intValue() < 1) {
                String delay = "0";
                if (merBasicPrdCfg.getRecognizePeriod() != null && merBasicPrdCfg.getRecognizePeriod().compareTo(new BigDecimal("0.5")) == 0) {
                    try {
                        PrdRecognizeDelay prdRecognizeDelay = new PrdRecognizeDelay();
                        prdRecognizeDelay.setBasicPrdCode(merBasicPrdCfg.getBasicPrdCode());
                        prdRecognizeDelay.setSystemCode(merBasicPrdCfg.getSystemCode());
                        MerMerchant merMerchant = getMerMerchant(merCode);
                        if (merMerchant != null) {
                            prdRecognizeDelay.setMerLevel(merMerchant.getMerLevel());
                        }
                        prdRecognizeDelay = prdRecognizeDelayDao.selectConstraints(prdRecognizeDelay);
                        if (prdRecognizeDelay != null && !ValidateUtil.isEmpty(prdRecognizeDelay.getRecognizeDelay())) {
                            String[] cimsDelay = prdRecognizeDelay.getRecognizeDelay().split(":");
                            int daylayint = Integer.valueOf(cimsDelay[0]) * 60 + Integer.valueOf(cimsDelay[1]);
                            delay = String.valueOf(daylayint);
                        }
                    } catch (Exception e) {
                        log.error("入账延迟时间转换错误" + accCode);
                    }
                }

                Calendar estAccTime = Calendar.getInstance();
                Date accTime = trntransaction.getAccDate();
                Calendar accTimeC = Calendar.getInstance();
                accTimeC.setTime(accTime);
                estAccTime.set(Calendar.YEAR, accTimeC.get(Calendar.YEAR));
                estAccTime.set(Calendar.MONTH, accTimeC.get(Calendar.MONTH));
                estAccTime.set(Calendar.DAY_OF_YEAR, accTimeC.get(Calendar.DAY_OF_YEAR));
                if (ValidateUtil.isEmpty(delay) || Integer.valueOf(delay).intValue() == 0) {
                    trntransaction.setBlnMode(BasConstants.BLN_MODE_NOW);
                } else {
                    trntransaction.setBlnMode(BasConstants.BLN_MODE_DELAY);
                    estAccTime.add(Calendar.MINUTE, Integer.valueOf(delay));
                    //					trntransaction.setEstAccTime(estAccTime.getTime());
                }
                trntransaction.setEstAccTime(estAccTime.getTime());
                //				trntransaction.setCanBlnDate(new Date());
                trntransaction.setCanBlnDate(trntransaction.getAccDate());
            } else {
                // T+N
                trntransaction.setBlnMode(BasConstants.BLN_MODE_N);

                Calendar canBlnDate = Calendar.getInstance();
                Date accTime = trntransaction.getAccDate();
                Calendar accTimeC = Calendar.getInstance();
                accTimeC.setTime(accTime);
                canBlnDate.set(Calendar.YEAR, accTimeC.get(Calendar.YEAR));
                canBlnDate.set(Calendar.MONTH, accTimeC.get(Calendar.MONTH));
                canBlnDate.set(Calendar.DAY_OF_YEAR, accTimeC.get(Calendar.DAY_OF_YEAR));

                // Calendar canBlnDate = Calendar.getInstance();
                // canBlnDate.setTime(trntransaction.getAccDate());
                canBlnDate.add(Calendar.DAY_OF_YEAR, merBasicPrdCfg.getRecognizePeriod().intValue());
                trntransaction.setCanBlnDate(canBlnDate.getTime());
                //				trntransaction.setEstAccTime(canBlnDate.getTime());
            }
        }

    }

    @Override
    public String getAccTranNo() {
        // 设置记账流水
        return trnTransactionDao.getAccTranNo();
    }

    @Override
    public BigDecimal getAvailableBal(AccountType accountType, String relSubCode, String merAccCode, String ccyCode) {
        //根据实际科目、交易账户、币种查询账户余额
        CusSubaccinfo cusSubaccinfo = cusSubAccInfoDao.selectBycode(CusSubAccInfoUtil.getTableBySubType(accountType.getCode()), relSubCode,
            merAccCode, ccyCode);
        if (cusSubaccinfo == null) {
            log.error("relSubCode:{}, merAccCode:{}, ccyCode:{}", new Object[] { relSubCode, merAccCode, ccyCode });
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, new Object[] { merAccCode + "商户余额信息" }));
        }
        //计算可用余额 可用余额=当前余额-冻结余额-监管冻结余额
        return cusSubaccinfo.getCurBal().subtract(cusSubaccinfo.getBizFreezeBal()).subtract(cusSubaccinfo.getMagFreezeBal())
            .subtract(cusSubaccinfo.getPayableFreezeBal());
    }

    @Override
    public CusSubaccinfo getCusSubaccinfo(AccountType accountType, String relSubCode, String merAccCode, String ccyCode) {
        return cusSubAccInfoDao.selectBycode(CusSubAccInfoUtil.getTableBySubType(accountType.getCode()), relSubCode, merAccCode, ccyCode);
    }

    @Override
    public void accountExists(String merAccCode) {
    	if(merAccCode.length()==BasConstants.MERCHANT_ACC_CODE_LENGTH){
            List<MerAccount> accountList = merAccountCache.selectByAcctcode(merAccCode);
            if (accountList == null || accountList.isEmpty()) {
                log.error("thirdmerAccCode:{}", new Object[] { merAccCode });
                throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, new Object[] { merAccCode + "商户账户信息" }));
            }
    	}else if(merAccCode.length()==BasConstants.INDIVIDUAL_ACC_CODE_LENGTH){
            boolean perAccountIsExist = checkPerAccountIsExist(merAccCode);
            if (!perAccountIsExist) {
                throw new BizException(merAccCode + "个人账户信息不存在!");
            }
    	}
    }

    @Override
    public TrnTransaction selectByOriAppTranNoAndTranCode(String oriAppTranNo, String tranCode) {
        return trnTransactionDao.selectByOrgAppTranNoAndTranCode(oriAppTranNo, tranCode);
    }

    @Override
    public TrnTranReverse selectReverseByAccTranNo(String accTranNo) {
        if (accTranNo == null) {
            return null;
        }
        return trnTranReverseDao.selectByAccTranNo(accTranNo);
    }

    @Override
    public DiffTraninfo selectDiffTraninfoByPrimaryKey(String errNo) {
        DiffTraninfo diffTraninfo = diffTraninfoDao.selectByPrimaryKey(errNo);
        return diffTraninfo;
    }

    @Override
    public void updateDiffTraninfoByPrimaryKey(DiffTraninfo diffTraninfo) {
        diffTraninfoDao.update(diffTraninfo);
    }

	@Override
	public boolean checkAllowIn(String payeeType, String payeeCode,
			String payeeAccCode) {
		boolean isAllowIn = false;
        if (BasConstants.BIZ_KIND_CUS.equals(payeeType)) {//如果商户类型是商户
            //根据商户号和交易账户号获取商户信息
            MerAccount merAccount = getMerAccountNoCache(payeeCode, payeeAccCode);
            if (merAccount == null) {//商户不存在
                throw new BizException(msa.getMessage(MsgCodeList.ERROR_505016, new Object[] { payeeAccCode }));
            } else if (BasConstants.ALLOW_IN_TRUE.equals(merAccount.getAllowIn())) {//如不允许入款
                isAllowIn = true;
            }
        } else {//如果商户类型是个人
            PerAccount perAccount = perAccountDao.selectByAcctCode(payeeAccCode);//根据交易账户号查询个人信息
            if (perAccount == null||!AccStatus.NORMAL.getCode().equals(perAccount.getAccStatus())) {
                throw new BizException(msa.getMessage(MsgCodeList.ERROR_505016, new Object[] { payeeAccCode }));
            } else if (FundStatus.CAN_IN_OUT.getCode().equals(perAccount.getFundStatus())
                       || FundStatus.CAN_IN.getCode().equals(perAccount.getFundStatus())) {//如果允许入款
                isAllowIn = true;
            }
        }
        return isAllowIn;
	}
}
