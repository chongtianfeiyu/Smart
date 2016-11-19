package com.somnus.smart.message.meracct;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class SpeAccountRequest extends Message {
	
	private static final long serialVersionUID = -4173614693770664573L;
	/**个人账户号*/
    @NotEmpty
    private String acctCode;
    /**账户类型*/
    @NotEmpty
    private String acctType;
    /**货币码*/
    @NotEmpty
    private String ccyCode;
    /**开户日期*/
    @NotEmpty
    private String openDate;
    /**开户操作人*/
    @NotEmpty
    private String openBy;
	public String getAcctCode() {
		return acctCode;
	}
	public void setAcctCode(String acctCode) {
		this.acctCode = acctCode;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
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
	
}
