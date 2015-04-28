package com.somnus.smart.message.accquery;

import java.util.Date;

import com.somnus.smart.message.Message;

public class ProtocolTransferQueryRequest extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	
	private Date accDate;
	/**商户号*/
	private String merCode;
	
	private String merName;
	/**商户账户号*/
	private String merAccCode;
	
	private String ccyCode;
	
	private String status;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getMerCode() {
		return merCode;
	}
	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}
	public String getMerAccCode() {
		return merAccCode;
	}
	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}
	public Date getAccDate() {
		return accDate;
	}
	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
