package com.somnus.smart.message.accquery;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class QueryAccDetailRequest extends Message {
	
	/**商户账户号*/
	@NotEmpty
	private String merAccCode;
	/**账户类型*/
	@NotEmpty
	private String accType;
	/**币种代码*/
	@NotEmpty
	private String ccyCode;
	/**收入或支出*/
	private String cdFlag;
	/**记账处理开始时间*/
	@NotEmpty
	private String accDateBegin;
	/**记账处理结束时间*/
	@NotEmpty
	private String accDateEnd;
	/**商户订单号*/
	private String cusTranNo;
	/**isp订单号*/
	private String ipsBillNo;
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
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public String getCdFlag() {
		return cdFlag;
	}
	public void setCdFlag(String cdFlag) {
		this.cdFlag = cdFlag;
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
	public String getCusTranNo() {
		return cusTranNo;
	}
	public void setCusTranNo(String cusTranNo) {
		this.cusTranNo = cusTranNo;
	}
	public String getIpsBillNo() {
		return ipsBillNo;
	}
	public void setIpsBillNo(String ipsBillNo) {
		this.ipsBillNo = ipsBillNo;
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
}
