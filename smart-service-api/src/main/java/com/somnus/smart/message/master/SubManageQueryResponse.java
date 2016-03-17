package com.somnus.smart.message.master;

import java.util.List;

import com.somnus.smart.message.Message;

/**
 * 科目查询接口输出
 * @author bo.zhang
 *
 */
public class SubManageQueryResponse extends Message {

	private static final long serialVersionUID = 1L;
	
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	/**总条数*/
	private int rowCount;
	/**当页结果集*/
	private List<SubManageOrder> orders;

	
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
	public List<SubManageOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<SubManageOrder> orders) {
		this.orders = orders;
	}
}
