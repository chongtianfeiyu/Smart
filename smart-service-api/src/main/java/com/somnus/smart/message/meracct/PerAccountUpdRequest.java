package com.somnus.smart.message.meracct;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class PerAccountUpdRequest extends Message {
	
	@NotEmpty
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
    
}
