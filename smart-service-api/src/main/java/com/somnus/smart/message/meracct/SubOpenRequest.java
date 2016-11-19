package com.somnus.smart.message.meracct;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 内部科目开户
 * @author bo.zhang
 *
 */
public class SubOpenRequest extends Message {

	private static final long serialVersionUID = 1L;
	
	/**科目号*/
	@NotEmpty
	private String subCode;
	/**币种*/
	@NotEmpty
	private String ccyCode;
	
	public String getSubCode() {
		return subCode;
	}
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}

}
