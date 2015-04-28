package com.somnus.smart.message.master;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 科目录入接口输入
 * @author bo.zhang
 *
 */
public class SubManageEntryRequest extends Message {

	private static final long serialVersionUID = 1L;
	
	/**科目号*/
	@NotEmpty
	private String subCode;
	/**科目名称*/
	@NotEmpty
	private String subCodeName;
	/**币种*/
	@NotEmpty
	private String ccyCode;
	/**是否开户:0:不开户 1：开户*/
	@NotEmpty
	@Pattern(regexp = "^[01]$",message = "must be either 0, 1" )
	private String isOpen;
	
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getSubCodeName() {
		return subCodeName;
	}
	public void setSubCodeName(String subCodeName) {
		this.subCodeName = subCodeName;
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
}
