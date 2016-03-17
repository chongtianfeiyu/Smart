package com.somnus.smart.message.accquery;

import java.util.List;

import com.somnus.smart.message.Message;

public class ProtocolTransferQueryResponse extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	/**总条数*/
	private int rowCount;
	/**查询结果*/
	private List<ProtocolTransferOrder> orders;
	
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
	public List<ProtocolTransferOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<ProtocolTransferOrder> orders) {
		this.orders = orders;
	}
}
