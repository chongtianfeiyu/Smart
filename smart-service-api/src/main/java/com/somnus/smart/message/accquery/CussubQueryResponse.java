package com.somnus.smart.message.accquery;

import java.math.BigDecimal;

import com.somnus.smart.message.Message;

/**
 * 计费接口输出
 * @author bo.zhang
 *
 */
public class CussubQueryResponse extends Message {
	
	/**商户账户号*/
	private String merAccCode;
	/**账户余额*/
	private BigDecimal curBal;
	/**可用余额*/
	private BigDecimal availBal;
	
	public String getMerAccCode() {
		return merAccCode;
	}
	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}
	public BigDecimal getCurBal() {
		return curBal;
	}
	public void setCurBal(BigDecimal curBal) {
		this.curBal = curBal;
	}
	public BigDecimal getAvailBal() {
		return availBal;
	}
	public void setAvailBal(BigDecimal availBal) {
		this.availBal = availBal;
	}
}
