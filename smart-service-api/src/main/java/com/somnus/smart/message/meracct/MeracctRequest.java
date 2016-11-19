package com.somnus.smart.message.meracct;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 商户开户
 * @author bo.zhang
 *
 */
public class MeracctRequest extends Message {
	
	/*//==============================================商户信息===========================================/
    *//**入账延迟时间*//*
    private String recognizeDelay;
    
  //==============================================商户交易账户信息====================================/
    *//**所属系统:1:基础应用平台 2：易收付 3：高校缴费 4：物业缴费*//*
    @NotEmpty
    private String system;
    *//**其他银行名称*//*
    private String otherBank;
    *//**版本*//*
    @NotNull
    private Integer version;
    *//**版本状态:1:审核中 2:有效 3:无效*//*
    @NotEmpty
    private String status;
    *//**操作标志:1:被删除 2:被新版本替换*//*
    @NotEmpty
    private String operFlag;
    *//**修改人*//*
    @NotEmpty
    private String modifyBy;
    *//**修改时间*//*
    @NotNull
    private Date modifyTime;*/
    
    
    
    @NotNull
	private BigDecimal merId	;//商户ID	M
    @NotEmpty
    private String merCode	;//商户号	M
    private String posMerCode	;//POS商户号	O
    /** 商户类型_1：企业 2：个人 3：个体工商户 */
    @NotEmpty
    private String merType;
    @NotEmpty
    private String merName;//	商户名称	M
    @NotEmpty
    private String shortName;//	商户简称	M
    @NotEmpty
    private String gwName;//	网关名称	M
    @NotEmpty
    private String merMail;//	商户邮箱	M
    @NotEmpty
    private String industryL1;//	一级行业分类	M
    @NotEmpty
    private String industryL2;//	二级行业分类	M
    @NotEmpty
    private String industryL3;//	三级行业分类	M
    private String mcc;//	MCC码	O
    private BigDecimal merLevel;//	商户等级	O
    private String risk;//	风险等级	O
    @NotNull
    private Long acctId;//	账户ID	M
    @NotEmpty
    @Length(min = 10,max = 10,message = "acctCode length must be 10")
    private String acctCode;//	交易账户号	M
    @NotEmpty
    private String acctName;//	交易账户名	M
    @NotEmpty
    private String currency;//	币种	M
    @NotEmpty
    private String bankCode;//	开户银行	M
    @NotEmpty
    private String bankName;//	开户银行名称	M
    @NotEmpty
    private String bankKey;//	银行联行号	M
    @NotEmpty
    private String branchCode;//	分行编号	M
    @NotEmpty
    private String branchName;//	分行名称	M
    @NotEmpty
    private String bankAcctNo;//	商户银行账号	M
    @NotEmpty
    private String bankAcctName;//	商户银行户名	M
    @NotEmpty
    private String stlType;//	清算类型	M
    @NotNull
    private BigDecimal balFloor;//	余额下限	M
    @NotNull
    private Short autoTransfer;//	是否开通协议划款	M
    private BigDecimal minTransfer;//	最低划款金额	M
    private String transferPeriod;//	划款周期	M
    @NotNull
    private Integer transferPriority;//	出款优先级	M
    @NotEmpty
    private String allowIn;//	是否允许收款	M
    @NotEmpty
    private String allowOut;//	是否允许出款	M
    private String remark;//	备注	O
    @NotEmpty
    private String effectDate;//	生效日期	M
    @NotEmpty
    private String loseEffectDate;//	失效日期	M

    
    
	public BigDecimal getMerId() {
		return merId;
	}
	public void setMerId(BigDecimal merId) {
		this.merId = merId;
	}
	public String getMerCode() {
		return merCode;
	}
	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getGwName() {
		return gwName;
	}
	public void setGwName(String gwName) {
		this.gwName = gwName;
	}
	public String getMerMail() {
		return merMail;
	}
	public void setMerMail(String merMail) {
		this.merMail = merMail;
	}
	public String getIndustryL1() {
		return industryL1;
	}
	public void setIndustryL1(String industryL1) {
		this.industryL1 = industryL1;
	}
	public String getIndustryL2() {
		return industryL2;
	}
	public void setIndustryL2(String industryL2) {
		this.industryL2 = industryL2;
	}
	public String getIndustryL3() {
		return industryL3;
	}
	public void setIndustryL3(String industryL3) {
		this.industryL3 = industryL3;
	}
	public Long getAcctId() {
		return acctId;
	}
	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}
	public String getAcctCode() {
		return acctCode;
	}
	public void setAcctCode(String acctCode) {
		this.acctCode = acctCode;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankKey() {
		return bankKey;
	}
	public void setBankKey(String bankKey) {
		this.bankKey = bankKey;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBankAcctNo() {
		return bankAcctNo;
	}
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
	}
	public String getBankAcctName() {
		return bankAcctName;
	}
	public void setBankAcctName(String bankAcctName) {
		this.bankAcctName = bankAcctName;
	}
	public String getStlType() {
		return stlType;
	}
	public void setStlType(String stlType) {
		this.stlType = stlType;
	}
	public BigDecimal getBalFloor() {
		return balFloor;
	}
	public void setBalFloor(BigDecimal balFloor) {
		this.balFloor = balFloor;
	}
	public Short getAutoTransfer() {
		return autoTransfer;
	}
	public void setAutoTransfer(Short autoTransfer) {
		this.autoTransfer = autoTransfer;
	}
	public BigDecimal getMinTransfer() {
		return minTransfer;
	}
	public void setMinTransfer(BigDecimal minTransfer) {
		this.minTransfer = minTransfer;
	}
	public String getTransferPeriod() {
		return transferPeriod;
	}
	public void setTransferPeriod(String transferPeriod) {
		this.transferPeriod = transferPeriod;
	}
	public Integer getTransferPriority() {
		return transferPriority;
	}
	public void setTransferPriority(Integer transferPriority) {
		this.transferPriority = transferPriority;
	}
	public String getAllowIn() {
		return allowIn;
	}
	public void setAllowIn(String allowIn) {
		this.allowIn = allowIn;
	}
	public String getAllowOut() {
		return allowOut;
	}
	public void setAllowOut(String allowOut) {
		this.allowOut = allowOut;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEffectDate() {
		return effectDate;
	}
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}
	public String getLoseEffectDate() {
		return loseEffectDate;
	}
	public void setLoseEffectDate(String loseEffectDate) {
		this.loseEffectDate = loseEffectDate;
	}
	public String getPosMerCode() {
		return posMerCode;
	}
	public void setPosMerCode(String posMerCode) {
		this.posMerCode = posMerCode;
	}
	public String getMerType() {
		return merType;
	}
	public void setMerType(String merType) {
		this.merType = merType;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public BigDecimal getMerLevel() {
		return merLevel;
	}
	public void setMerLevel(BigDecimal merLevel) {
		this.merLevel = merLevel;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
