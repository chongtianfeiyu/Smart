package com.somnus.smart.message.custom;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 冻结解冻请求
 * 
 * @author Administrator
 *
 */
public class AccountFreezeRequest extends Message {

	private static final long serialVersionUID = 1L;
	/** 交易账户号 */
	@NotEmpty
	private String merAccCode;	
	/** 交易类型	1:冻结 2:解冻 */
	@NotEmpty
	private String tranType;
	/** 币种 */
	@NotEmpty
	private String ccyCode;
	/** 交易金额 */
	@NotNull
	@DecimalMin("0.01") 
	private BigDecimal tranAmt;
	/** 凭证号 */
	@NotEmpty
	private String voucherNo;
	/** 应用冻结流水号 */
	@NotEmpty
	private String appFreezeNo;
	/** 业务类型	1:监管 2:业务 */
	@NotEmpty
	private String bizType;
	
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
	public BigDecimal getTranAmt() {
		return tranAmt;
	}
	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getAppFreezeNo() {
		return appFreezeNo;
	}
	public void setAppFreezeNo(String appFreezeNo) {
		this.appFreezeNo = appFreezeNo;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	
}
