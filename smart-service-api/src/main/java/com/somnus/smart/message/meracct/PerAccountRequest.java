package com.somnus.smart.message.meracct;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class PerAccountRequest extends Message {
	
	@NotEmpty
	@Length(min = 12,max = 12,message = "acctCode length must be 12")
	private String acctCode;//		交易账户号	M
    @NotEmpty
    private String acctName;//		交易账户名称	M
    @NotEmpty
    private String userId;//		登录用户名	M
    
    private String email;//			绑定邮箱	M
    @NotEmpty
    private String mobile;//		绑定手机	M
    @NotEmpty
    private String bankCode;//		开户银行	M
    @NotEmpty
    private String bankName;//		开户银行名称	M
    @NotEmpty
    private String bankAcctNo;//	银行账号	M
    @NotEmpty
    private String bankAcctName;//	银行账号名称	M
    @NotEmpty
    private String ccyCode;//		货币码		M
    @NotEmpty
    private String level;//			会员等级	M
    @NotEmpty
    private String openDate;//		开户日期	M
    @NotEmpty
    private String openBy;//		开户人		M
    @NotEmpty
    private String acctType;//		账户类型	M（1：标准账户 2：专用账户）
    private String stdAcctCode;//	标准交易账户号
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
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
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getOpenBy() {
		return openBy;
	}
	public void setOpenBy(String openBy) {
		this.openBy = openBy;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getStdAcctCode() {
		return stdAcctCode;
	}
	public void setStdAcctCode(String stdAcctCode) {
		this.stdAcctCode = stdAcctCode;
	}
}
