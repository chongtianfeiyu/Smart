package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.List;

import com.somnus.smart.message.Message;

public class QueryAccDetailResponse extends Message {
	/**商户号*/
	private String merCode;
	/**商户账户号*/
	private String merAccCode;
	/**总收入*/
	private BigDecimal totalIncome;
	/**总支出*/
	private BigDecimal totalExpenditure;
	/**账户类型*/
	private String accType;
	/**总条数*/
	private int rowCount;
	/**每页大小*/
	private int pageSize;
	/**当前页码*/
	private int pageNum;
	
	private List<QueryAccDetailOrder> accDetails;

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

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<QueryAccDetailOrder> getAccDetails() {
		return accDetails;
	}

	public void setAccDetails(List<QueryAccDetailOrder> accDetails) {
		this.accDetails = accDetails;
	}

	public BigDecimal getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}

	public BigDecimal getTotalExpenditure() {
		return totalExpenditure;
	}

	public void setTotalExpenditure(BigDecimal totalExpenditure) {
		this.totalExpenditure = totalExpenditure;
	}
}
