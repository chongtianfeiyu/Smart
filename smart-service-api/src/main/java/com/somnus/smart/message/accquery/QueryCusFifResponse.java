package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.List;

import com.somnus.smart.message.Message;

public class QueryCusFifResponse extends Message {
	
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	/**总条数*/
	private int rowCount;
	/**商户账户号*/
	private String merAccCode;
	/**总金额*/
	private BigDecimal totalAmt;
	/**查询结果集*/
	private List<QueryCusFifOrder> tranDetails;
	
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
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public String getMerAccCode() {
		return merAccCode;
	}
	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}
	public List<QueryCusFifOrder> getTranDetails() {
		return tranDetails;
	}
	public void setTranDetails(List<QueryCusFifOrder> tranDetails) {
		this.tranDetails = tranDetails;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
}
