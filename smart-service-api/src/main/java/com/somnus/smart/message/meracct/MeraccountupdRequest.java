package com.somnus.smart.message.meracct;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class MeraccountupdRequest extends Message {
	/**交易账户号*/
	@NotEmpty
    private String acctCode;
    /**交易账户名*/
	@NotEmpty
    private String acctName;
    /**所属系统:1:基础应用平台 2：易收付 3：高校缴费 4：物业缴费*/
	@NotEmpty
    private String system;
    /**币种:156：人民币*/
	@NotEmpty
    private String currency;
    /**开户银行*/
	@NotEmpty
    private String bankCode;
    /**其他银行名称*/
    private String otherBank;
    /**银行联行号*/
    @NotEmpty
    private String bankKey;
    /**分行编号*/
    @NotEmpty
    private String branchCode;
    /**分行名称*/
    @NotEmpty
    private String branchName;
    /**商户银行账号*/
    @NotEmpty
    private String bankAcctNo;
    /**商户银行户名*/
    @NotEmpty
    private String bankAcctName;
    /**清算类型:1:对公 2：对私*/
    @NotEmpty
    private String stlType;
    /**余额下限*/
    @NotNull
    private BigDecimal balFloor;
    /**是否开通协议划款:0：否 1：是*/
    @NotNull
    private Short autoTransfer;
    /**最低划款金额*/
    @NotNull
    private BigDecimal minTransfer;
    /**划款周期:1:工作日划款 2:一周两次 3:一周一次*/
    @NotEmpty
    private String transferPeriod;
    /**是否自动出款:0：否 1：是*/
    @NotEmpty
    private String isAutoStl;
    /**开始划款日期*/
    @NotEmpty
    private String beginTransfer;
    /**出款优先级:1:1 2:2 3:3*/
    @NotEmpty
    private String transferPriority;
    /**是否允许收款:0：否 1：是*/
    @NotEmpty
    private String allowIn;
    /**是否允许出款:0：否 1：是*/
    @NotEmpty
    private String allowOut;
    /**备注*/
    private String remark;
    /**版本*/
    @NotEmpty
    private Integer version;
    /**版本状态:1:审核中 2:有效 3:无效*/
    @NotEmpty
    private String status;
    /**操作标志:1:被删除 2:被新版本替换*/
    @NotEmpty
    private String operFlag;
    /**生效日期*/
    @NotEmpty
    private String effectDate;
    /**失效日期*/
    @NotEmpty
    private String loseEffectDate;
    /**修改人*/
    @NotEmpty
    private String modifyBy;
    /**修改时间*/
    @NotEmpty
    private Date modifyTime;
    
    private String outFlag;
    
    
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
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
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
	public String getOtherBank() {
		return otherBank;
	}
	public void setOtherBank(String otherBank) {
		this.otherBank = otherBank;
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
	public String getIsAutoStl() {
		return isAutoStl;
	}
	public void setIsAutoStl(String isAutoStl) {
		this.isAutoStl = isAutoStl;
	}
	public String getBeginTransfer() {
		return beginTransfer;
	}
	public void setBeginTransfer(String beginTransfer) {
		this.beginTransfer = beginTransfer;
	}
	public String getTransferPriority() {
		return transferPriority;
	}
	public void setTransferPriority(String transferPriority) {
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperFlag() {
		return operFlag;
	}
	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
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
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getOutFlag() {
		return outFlag;
	}
	public void setOutFlag(String outFlag) {
		this.outFlag = outFlag;
	}
}
