package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.List;

import com.somnus.smart.message.Message;


public class IssuedAccQueryResponse extends Message {
	
	private static final long serialVersionUID = 1L;
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	/**总条数*/
	private int rowCount;
	/**查询结果*/
	private List<IssuedAccOrder> orders;
	
	private BigDecimal totalAmt;
	
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
	public List<IssuedAccOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<IssuedAccOrder> orders) {
		this.orders = orders;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
}
