package com.somnus.smart.message.accquery;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class IssuedAccDetailQueryRequest extends Message {
	
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	/**下发批次号*/
	@NotEmpty
	private String batchNo;
	
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
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
}
