package com.somnus.smart.message.accquery;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 商户可用余额查询接口输入
 * @author bo.zhang
 *
 */
public class CussubQueryRequest extends Message {
	
	/**商户账户号*/
	@NotEmpty
	private String merAccCode;

	public String getMerAccCode() {
		return merAccCode;
	}

	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}
}
