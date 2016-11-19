package com.somnus.smart.message.master;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 科目查询接口输入
 * @author bo.zhang
 *
 */
public class SubManageQueryRequest extends Message {

	private static final long serialVersionUID = 1L;
	
	/**科目号*/
	@NotEmpty
	private String subCode;
	/**科目名称*/
	@NotEmpty
	private String subName;
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	
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
