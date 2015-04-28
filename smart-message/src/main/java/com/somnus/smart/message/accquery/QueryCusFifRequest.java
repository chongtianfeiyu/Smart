package com.somnus.smart.message.accquery;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class QueryCusFifRequest extends Message {
	
	private static final long serialVersionUID = 1L;
	/**商户账户号*/
	@NotEmpty
	private String merAccCode;
	/**币种代码*/
	@NotEmpty
	private String ccyCode;
	
	/**记账开始日期*/
	@NotEmpty
	private String accDateBegin;
	
	/**记账结束日期*/
	@NotEmpty
	private String accDateEnd;
	
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	
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
	public String getAccDateBegin() {
		return accDateBegin;
	}
	public void setAccDateBegin(String accDateBegin) {
		this.accDateBegin = accDateBegin;
	}
	public String getAccDateEnd() {
		return accDateEnd;
	}
	public void setAccDateEnd(String accDateEnd) {
		this.accDateEnd = accDateEnd;
	}
}
