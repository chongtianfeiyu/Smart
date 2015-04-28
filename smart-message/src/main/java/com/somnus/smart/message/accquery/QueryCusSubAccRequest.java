package com.somnus.smart.message.accquery;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 账户余额查询输入参数
 * @author dell
 *
 */
public class QueryCusSubAccRequest extends Message {
	
	/**商户账户号*/
	@NotEmpty
	private String merAccCode;
	/**币种*/
	@NotEmpty
	private String ccyCode;
	/**账户类型*/
	private String accType;
	
	public String getMerAccCode() {
		return merAccCode;
	}
	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
}
