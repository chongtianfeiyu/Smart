package com.somnus.smart.message.master;

/**
 * 科目查询接口输出明细
 * @author bo.zhang
 *
 */
public class SubManageOrder {
	
	/**科目号*/
	private String subCode;
	/**科目名称*/
	private String subName;
	/**状态*/
	private String status;
	
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
