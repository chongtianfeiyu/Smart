package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.Date;

public class IssuedAccDetailOrder {

	/**下发明细流水号*/
	private String issTranNo;
	/**商户号*/
	private String merCode;
	/**商户名称*/
	private String merName;
	/**商户账户号*/
	private String merAccCode;
	/**划款日期*/
	private Date tranDate;
	/**业务类型*/
	private String bizType;
	/**币种*/
	private String ccyCode;
	/**划款金额*/
	private BigDecimal tranAmount;
	/**出款银行*/
	private String payerBankCode;
	/**收款银行*/
    private String payeeBankCode;
    /**收款账户号*/
    private String payeeBankAccCode;
    /**收款账户名*/
    private String payeeBankAccName;
    
	public String getIssTranNo() {
		return issTranNo;
	}
	public void setIssTranNo(String issTranNo) {
		this.issTranNo = issTranNo;
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
	public String getMerAccCode() {
		return merAccCode;
	}
	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public BigDecimal getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(BigDecimal tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getPayerBankCode() {
		return payerBankCode;
	}
	public void setPayerBankCode(String payerBankCode) {
		this.payerBankCode = payerBankCode;
	}
	public String getPayeeBankCode() {
		return payeeBankCode;
	}
	public void setPayeeBankCode(String payeeBankCode) {
		this.payeeBankCode = payeeBankCode;
	}
	public String getPayeeBankAccCode() {
		return payeeBankAccCode;
	}
	public void setPayeeBankAccCode(String payeeBankAccCode) {
		this.payeeBankAccCode = payeeBankAccCode;
	}
	public String getPayeeBankAccName() {
		return payeeBankAccName;
	}
	public void setPayeeBankAccName(String payeeBankAccName) {
		this.payeeBankAccName = payeeBankAccName;
	}
}
