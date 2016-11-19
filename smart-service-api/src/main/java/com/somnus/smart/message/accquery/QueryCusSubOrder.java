package com.somnus.smart.message.accquery;

import java.math.BigDecimal;

public class QueryCusSubOrder {
	
	/**账户类型*/
	private String accType;
	/**币种*/
	private String ccyCode;
	/**账户余额*/
	private BigDecimal curBal;
	/**可用余额*/
	private BigDecimal availBal;
	/**业务冻结金额*/
	private BigDecimal magFreezeBal;
	/**监管冻结金额*/
	private BigDecimal bizFreezeBal;
	/**应付冻结金额*/
	private BigDecimal payableFreezeBal;
	
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
	public BigDecimal getMagFreezeBal() {
		return magFreezeBal;
	}
	public void setMagFreezeBal(BigDecimal magFreezeBal) {
		this.magFreezeBal = magFreezeBal;
	}
	public BigDecimal getBizFreezeBal() {
		return bizFreezeBal;
	}
	public void setBizFreezeBal(BigDecimal bizFreezeBal) {
		this.bizFreezeBal = bizFreezeBal;
	}
	public BigDecimal getPayableFreezeBal() {
		return payableFreezeBal;
	}
	public void setPayableFreezeBal(BigDecimal payableFreezeBal) {
		this.payableFreezeBal = payableFreezeBal;
	}
}
