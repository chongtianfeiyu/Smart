package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.Date;

public class ProtocolTransferOrder {
	private String transferId;
	private String batchNo;
	private Date accDate;
	private String merCode;
	private String merName;
	private String merAccCode;
	private String ccyCode;
	private BigDecimal tranAmount;
	private BigDecimal curBal;
	private BigDecimal reserveBal;
	private BigDecimal freezeBal;
	private String status;
	public String getTransferId() {
		return transferId;
	}
	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public Date getAccDate() {
		return accDate;
	}
	public void setAccDate(Date accDate) {
		this.accDate = accDate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
