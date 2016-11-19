package com.somnus.smart.message.custom;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 购汇记账输入参数
 * @author bo.zhang
 *
 */
public class PurchaseExchangeRequest extends Message {
	
	private static final long serialVersionUID = 1L;

    @NotEmpty
    private String tranCode;
	@NotEmpty
	private String prdCode;
	private String ipsBillNo;
	@NotEmpty
	private String appTranNo;
	@NotNull
	private Date appTranDate;
	@NotEmpty
	private String payerCode;
	@NotEmpty
	private String payerType;
	@NotEmpty
	private String payerAccCode;
	@NotEmpty
	private String tranType;
	@NotEmpty
	private String ccyCode;
	@NotNull
	@DecimalMin("0.01") 
	private BigDecimal tranAmt;
	@NotNull
	@DecimalMin("0") 
	private BigDecimal ordAmt;
	@NotEmpty
	private String feeWay;
	@NotNull
	@DecimalMin("0") 
	private BigDecimal feeAmt;
	@NotEmpty
	private String feeType;
	@NotNull
	@DecimalMin("0") 
	private BigDecimal feeRate;
	@NotEmpty
	private String feeStlMode;
	private String tranRemark;

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getPrdCode() {
		return prdCode;
	}
	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}
	public String getIpsBillNo() {
		return ipsBillNo;
	}
	public void setIpsBillNo(String ipsBillNo) {
		this.ipsBillNo = ipsBillNo;
	}
	public String getAppTranNo() {
		return appTranNo;
	}
	public void setAppTranNo(String appTranNo) {
		this.appTranNo = appTranNo;
	}
	public Date getAppTranDate() {
		return appTranDate;
	}
	public void setAppTranDate(Date appTranDate) {
		this.appTranDate = appTranDate;
	}
	public String getPayerCode() {
		return payerCode;
	}
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}
	public String getPayerType() {
		return payerType;
	}
	public void setPayerType(String payerType) {
		this.payerType = payerType;
	}
	public String getPayerAccCode() {
		return payerAccCode;
	}
	public void setPayerAccCode(String payerAccCode) {
		this.payerAccCode = payerAccCode;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
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
	public BigDecimal getOrdAmt() {
		return ordAmt;
	}
	public void setOrdAmt(BigDecimal ordAmt) {
		this.ordAmt = ordAmt;
	}
	public String getFeeWay() {
		return feeWay;
	}
	public void setFeeWay(String feeWay) {
		this.feeWay = feeWay;
	}
	public BigDecimal getFeeAmt() {
		return feeAmt;
	}
	public void setFeeAmt(BigDecimal feeAmt) {
		this.feeAmt = feeAmt;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public BigDecimal getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}
	public String getFeeStlMode() {
		return feeStlMode;
	}
	public void setFeeStlMode(String feeStlMode) {
		this.feeStlMode = feeStlMode;
	}
	public String getTranRemark() {
		return tranRemark;
	}
	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}
}
