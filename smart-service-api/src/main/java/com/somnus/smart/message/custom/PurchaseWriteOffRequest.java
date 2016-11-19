package com.somnus.smart.message.custom;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 购汇核销记账输入参数
 * @author bo.zhang
 *
 */
public class PurchaseWriteOffRequest extends Message {
	
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
	private String channelCode;
	@NotEmpty
	private String supplierCode;
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
	@NotNull
	@DecimalMin("0")
	private BigDecimal bankCost;
	@NotEmpty
	private String bankAccCode;
	@NotEmpty
	private String bankFeeType;
	@NotNull
	@DecimalMin("0")
	private BigDecimal bankFeeRate;
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
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
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
	public BigDecimal getBankCost() {
		return bankCost;
	}
	public void setBankCost(BigDecimal bankCost) {
		this.bankCost = bankCost;
	}
	public String getBankAccCode() {
		return bankAccCode;
	}
	public void setBankAccCode(String bankAccCode) {
		this.bankAccCode = bankAccCode;
	}
	public String getBankFeeType() {
		return bankFeeType;
	}
	public void setBankFeeType(String bankFeeType) {
		this.bankFeeType = bankFeeType;
	}
	public BigDecimal getBankFeeRate() {
		return bankFeeRate;
	}
	public void setBankFeeRate(BigDecimal bankFeeRate) {
		this.bankFeeRate = bankFeeRate;
	}
	public String getTranRemark() {
		return tranRemark;
	}
	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}
}
