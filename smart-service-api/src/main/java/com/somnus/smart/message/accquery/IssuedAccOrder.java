package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.Date;

public class IssuedAccOrder {

	/**批次号*/
	private String batchNo;
	/**商户号*/
	private String merCode;
	/**商户名称*/
	private String merName;
	/**商户账户号*/
	private String merAccCode;
	/**划款日期*/
	private Date tranDate;
	/**币种*/
	private String ccyCode;
	/**批次总金额*/
	private BigDecimal batchAmt;
	
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public BigDecimal getBatchAmt() {
		return batchAmt;
	}
	public void setBatchAmt(BigDecimal batchAmt) {
		this.batchAmt = batchAmt;
	}
}
