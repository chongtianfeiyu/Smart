package com.somnus.smart.message.account;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class BankDrawRequest extends Message {
    @NotEmpty
    private String tranCode;
	@NotEmpty
	private String prdCode;
	@NotEmpty
	private String ipsBillNo;
	@NotEmpty
	private String appTranNo;
	@NotNull
	private Date appTranDate;
	@NotEmpty
	private String merBillNo;
	@NotEmpty
	private String initiatorFlg;
	@NotEmpty
	private String payerCode;
	@NotEmpty
	private String payerType;
	@NotEmpty
	private String payerAccCode;
	@NotEmpty
	private String payeeBankAccCode;
	@NotEmpty
	private String payeeBankAccName;
	@NotEmpty
	private String payeeBankAccType;
	@NotEmpty
	private String payeeBankCode;
	private String payeeBraBankCode;
	private String payeeBraBankName;
	private String payeeBankAreaCode;
	private String payeeBankAreaName;
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
	private String isFee;
	@NotEmpty
	@Pattern(regexp = "^[123]$",message = "must be either 1,2,3" )
	private String feeWay;
	@NotNull
	@DecimalMin("0") 
	private BigDecimal feeAmt;
	@NotEmpty
	@Pattern(regexp = "^[12]$",message = "must be either 1, 2" )
	private String feeType;
	@NotNull
	private BigDecimal feeRate;
	private String thdAccCode;
	@NotEmpty
	@Pattern(regexp = "^[1]$",message = "must be either 1" )
	private String feeStlMode;
	@NotEmpty
	private String refundFeeBk;
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

	public String getMerBillNo() {
		return merBillNo;
	}

	public void setMerBillNo(String merBillNo) {
		this.merBillNo = merBillNo;
	}

	public String getInitiatorFlg() {
		return initiatorFlg;
	}

	public void setInitiatorFlg(String initiatorFlg) {
		this.initiatorFlg = initiatorFlg;
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

	public String getPayeeBankAccCode() {
		return payeeBankAccCode;
	}

	public void setPayeeBankAccCode(String payeeBankAccCode) {
		this.payeeBankAccCode = payeeBankAccCode;
	}

	public String getPayeeBankAccName() {
		return payeeBankAccName;
	}

	public void setPayeeBankAccName(String payeeBankAccName) {
		this.payeeBankAccName = payeeBankAccName;
	}

	public String getPayeeBankAccType() {
		return payeeBankAccType;
	}

	public void setPayeeBankAccType(String payeeBankAccType) {
		this.payeeBankAccType = payeeBankAccType;
	}

	public String getPayeeBankCode() {
		return payeeBankCode;
	}

	public void setPayeeBankCode(String payeeBankCode) {
		this.payeeBankCode = payeeBankCode;
	}

	public String getPayeeBraBankCode() {
		return payeeBraBankCode;
	}

	public void setPayeeBraBankCode(String payeeBraBankCode) {
		this.payeeBraBankCode = payeeBraBankCode;
	}

	public String getPayeeBraBankName() {
		return payeeBraBankName;
	}

	public void setPayeeBraBankName(String payeeBraBankName) {
		this.payeeBraBankName = payeeBraBankName;
	}

	public String getPayeeBankAreaCode() {
		return payeeBankAreaCode;
	}

	public void setPayeeBankAreaCode(String payeeBankAreaCode) {
		this.payeeBankAreaCode = payeeBankAreaCode;
	}

	public String getPayeeBankAreaName() {
		return payeeBankAreaName;
	}

	public void setPayeeBankAreaName(String payeeBankAreaName) {
		this.payeeBankAreaName = payeeBankAreaName;
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

	public String getThdAccCode() {
		return thdAccCode;
	}

	public void setThdAccCode(String thdAccCode) {
		this.thdAccCode = thdAccCode;
	}

	public String getFeeStlMode() {
		return feeStlMode;
	}

	public void setFeeStlMode(String feeStlMode) {
		this.feeStlMode = feeStlMode;
	}

	public String getRefundFeeBk() {
		return refundFeeBk;
	}

	public void setRefundFeeBk(String refundFeeBk) {
		this.refundFeeBk = refundFeeBk;
	}

	public String getTranRemark() {
		return tranRemark;
	}

	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}

	public String getIsFee() {
		return isFee;
	}

	public void setIsFee(String isFee) {
		this.isFee = isFee;
	}

}
