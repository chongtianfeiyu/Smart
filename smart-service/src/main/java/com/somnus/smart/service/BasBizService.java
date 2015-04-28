/**
 * 
 */
package com.somnus.smart.service;

import java.math.BigDecimal;
import java.util.Date;

import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.base.domain.DiffTraninfo;
import com.somnus.smart.base.domain.MerAccount;
import com.somnus.smart.base.domain.MerBasicPrdCfg;
import com.somnus.smart.base.domain.MerMerchant;
import com.somnus.smart.base.domain.PerAccount;
import com.somnus.smart.base.domain.TrnDraw;
import com.somnus.smart.base.domain.TrnRefund;
import com.somnus.smart.base.domain.TrnTranIssued;
import com.somnus.smart.base.domain.TrnTranReverse;
import com.somnus.smart.base.domain.TrnTransaction;
import com.somnus.smart.service.common.enums.AccountType;

/**
 * 余额变更处理service
 * 
 * @author IH745
 * 
 */
public interface BasBizService {

    /**
     * 根据交易流水查询退款表(Flag=1)
     * @param appTranNo
     * @return
     */
    public TrnRefund queryRefundFlagByApp(String appTranNo);

    /**
     * 根据交易流水查询出款表(Flag=1)
     * @param appTranNo
     */
    public TrnDraw queryDrawFlagByApp(String appTranNo);

    /**
     * 根据主键查询出款表(Flag=1)
     * @param drawId
     */
    public TrnDraw queryDrawFlagById(String drawId);

    /**
     * 根据交易流水号查询已出款下发记录
     * @param appTranNo
     * @return
     */
    public TrnTranIssued queryIssuedByAppStatus(String appTranNo);

    /**
     * 根据应用流水查询记账状态为正常记账的交易流水
     * @param appTranNo
     * @return
     */
    public TrnTransaction selectSuccessTranByAppTranNo(String appTranNo);

    /**
     * 根据交易流水号查询交易流水如果不存在查询历史交易流水
     * @param appTranNo
     * @return
     */
    public TrnTransaction queryTransaction(String appTranNo);


    /**
     * 根据商户号账户号获取账户信息
     * @param merCode
     * @param acctCode
     * @return
     */
    MerAccount getMerAccount(String merCode, String acctCode);

    /**
     * 根据账户号和产品号获取
     * @param acctCode
     * @param basicPrdCode
     * @return
     */
    MerBasicPrdCfg getMerBasicPrdCfg(String acctCode, String basicPrdCode, String systemCode);

    /**
     * 获取系统当前帐务日期
     * @return
     */
    Date getSystemAccDate();

    /**
     * 根据商户号获取商户信息
     * @param merCode
     * @return
     */
    MerMerchant getMerMerchant(String merCode);

    /**
     * 允许入款校验
     * @param bizKind
     * @param merCode
     * @param merAccCode
     */
    //	void checkAllowIn(String bizKind,String merCode,String merAccCode);
    /**
     * 根据商户类型、商户号、交易账户号验证是否允许出款
     * @param bizKind
     * @param merCode
     * @param merAccCode
     */
    void checkAllowOut(String bizKind, String merCode, String merAccCode);

    /**
     * 查询交易账户(不用缓存)
     * @param merCode
     * @param acctCode
     * @return
     */
    public MerAccount getMerAccountNoCache(String merCode, String acctCode);

    /**
     * 结算相关信息设置
     * @param trnTransaction
     */
    void blnRelaSet(TrnTransaction trnTransaction, MerBasicPrdCfg merBasicPrdCfg);

    /**
     * 获取记账流水号，'AC'||to_char(sysdate,'yyyymmdd')||SEQ_TRN_TRANSACTION.NEXTVAL
     * @return
     */
    String getAccTranNo();

    /**
     * 根据实际科目号、交易账户、币种查询账户余额，计算可用余额
     * @param relSubCode
     * @param merAccCode
     * @param ccyCode
     * @return
     */
    BigDecimal getAvailableBal(AccountType accountType,String relSubCode, String merAccCode, String ccyCode);

    /**
     * 获取余额信息
     * @param relSubCode
     * @param merAccCode
     * @param ccyCode
     * @return
     */
    CusSubaccinfo getCusSubaccinfo(AccountType accountType,String relSubCode, String merAccCode, String ccyCode);
    
    /**
     * 查询个人账户信息
     * @param accCode
     * @return
     */
    PerAccount getPerAccount(String accCode);

    /**
     * 第三方帐号是否存在
     * @param merAccCode
     */
    void accountExists(String merAccCode);


    /**
     * 校验是否允许出款
     * 
     * @param bizKind
     * @param merCode
     * @param merAccCode
     * @return
     */
    boolean isAccAllowOut(String bizKind, String merCode, String merAccCode);

    /**
     * 校验商户是否存在
     * @param merCode
     * @param merAccCode
     * @return
     */
    boolean checkMerAccountIsExist(String merCode, String merAccCode);
    
    /**
     * 验证个人账户是否存在
     * 
     * @param accCode
     * @return
     */
    public boolean checkPerAccountIsExist(String accCode);
    
    /**
     * 校验应收银行科目
     * @param accountType
     * @param relSubCode
     * @return
     */
    public boolean checkCusSubaccinfoIsExits(AccountType accountType,String relSubCode);
    
    /**
     * 根据记账流水号查询冲正记账附属流水
     * 
     * @param accTranNo
     * @return
     */
    TrnTranReverse selectReverseByAccTranNo(String accTranNo);
    
    DiffTraninfo selectDiffTraninfoByPrimaryKey(String errNo);

    void updateDiffTraninfoByPrimaryKey(DiffTraninfo diffTraninfo);
    
    public TrnTransaction selectByOriAppTranNoAndTranCode(String oriAppTranNo, String tranCode);
    /**
     * 校验账户是否允许入款
     * 
     * @param payeeType
     * @param payeeCode
     * @param payeeAccCode
     */
	public boolean checkAllowIn(String payeeType, String payeeCode,
			String payeeAccCode);
}
