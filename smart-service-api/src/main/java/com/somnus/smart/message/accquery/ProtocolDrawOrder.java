package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.Date;

public class ProtocolDrawOrder {
	private String merCode;
	private String merName;
	private String merAccCode;
	private Date tranDate;
	private String bizType;
	private String ccyCode;
	private BigDecimal tranAmount;
	private String payerBankCode;
	private String payeeBankCode;
	private String payeeBankAccCode;
	private String payeeBankAccName;
	private BigDecimal curBal;;
	private BigDecimal 	reserveBal;
	private BigDecimal freezeBal;
	
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

	public BigDecimal getCurBal() {
		return curBal;
	}

	public void setCurBal(BigDecimal curBal) {
		this.curBal = curBal;
	}

	public BigDecimal getReserveBal() {
		return reserveBal;
	}

	public void setReserveBal(BigDecimal reserveBal) {
		this.reserveBal = reserveBal;
	}

	public BigDecimal getFreezeBal() {
		return freezeBal;
	}

	public void setFreezeBal(BigDecimal freezeBal) {
		this.freezeBal = freezeBal;
	}

}
