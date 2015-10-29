package com.somnus.smart.message.meracct;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class AccountAllowInOrOutRequest extends Message {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotEmpty
	String merAccCode;// 交易账户号 M ;
	@NotEmpty
	String allowIn;// 是否允许收款 M ;
	@NotEmpty
	String allowOut;// 是否允许出款 M ;
	@NotEmpty
	String modifyBy;// 操作人 M ;

	public String getMerAccCode() {
		return merAccCode;
	}

	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}

	public String getAllowIn() {
		return allowIn;
	}

	public void setAllowIn(String allowIn) {
		this.allowIn = allowIn;
	}

	public String getAllowOut() {
		return allowOut;
	}

	public void setAllowOut(String allowOut) {
		this.allowOut = allowOut;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

}
