package com.somnus.smart.message.account;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class AutoRefundRequest extends Message {
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
	private String merBillNo;
	private String payTranNo;
	@NotEmpty
	private String initiatorFlg;
	@NotEmpty
	private String payerCode;
	@NotEmpty
	private String payerType;
	@NotEmpty
	private String payerAccCode;
	@NotEmpty
	private String tranType;
	@NotEmpty
	private String channelCode;
	private String supplierCode;
	@NotEmpty
	private String ccyCode;
	@NotNull
	@DecimalMin("0.01") 
	private BigDecimal tranAmt;
	@NotNull
	private BigDecimal oriBillAmt;
	@NotNull
	private Date oriBillDate;
	@NotEmpty
	private String oriAppTranNo;
	@NotEmpty
	private String oriMerBillNo;
	private String oriSupplierBillNo;
	private String oriAuthCode;
	private String oriRefrenceNo;
	private String cardHolder;
	private String cardNo;
	private String cardNoEx;
	private String billRemark;
	private String refundArg;
    @NotNull
	private BigDecimal bankCost;
	@NotEmpty
	private String bankAccCode;
	private String bankFeeType;
	private BigDecimal bankFeeRate;

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

	public String getPayTranNo() {
		return payTranNo;
	}

	public void setPayTranNo(String payTranNo) {
		this.payTranNo = payTranNo;
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

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
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

	public BigDecimal getOriBillAmt() {
		return oriBillAmt;
	}

	public void setOriBillAmt(BigDecimal oriBillAmt) {
		this.oriBillAmt = oriBillAmt;
	}

	public Date getOriBillDate() {
		return oriBillDate;
	}

	public void setOriBillDate(Date oriBillDate) {
		this.oriBillDate = oriBillDate;
	}

	public String getOriAppTranNo() {
		return oriAppTranNo;
	}

	public void setOriAppTranNo(String oriAppTranNo) {
		this.oriAppTranNo = oriAppTranNo;
	}

	public String getOriMerBillNo() {
		return oriMerBillNo;
	}

	public void setOriMerBillNo(String oriMerBillNo) {
		this.oriMerBillNo = oriMerBillNo;
	}

	public String getOriSupplierBillNo() {
		return oriSupplierBillNo;
	}

	public void setOriSupplierBillNo(String oriSupplierBillNo) {
		this.oriSupplierBillNo = oriSupplierBillNo;
	}

	public String getOriAuthCode() {
		return oriAuthCode;
	}

	public void setOriAuthCode(String oriAuthCode) {
		this.oriAuthCode = oriAuthCode;
	}

	public String getOriRefrenceNo() {
		return oriRefrenceNo;
	}

	public void setOriRefrenceNo(String oriRefrenceNo) {
		this.oriRefrenceNo = oriRefrenceNo;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardNoEx() {
		return cardNoEx;
	}

	public void setCardNoEx(String cardNoEx) {
		this.cardNoEx = cardNoEx;
	}

	public String getBillRemark() {
		return billRemark;
	}

	public void setBillRemark(String billRemark) {
		this.billRemark = billRemark;
	}

	public String getRefundArg() {
		return refundArg;
	}

	public void setRefundArg(String refundArg) {
		this.refundArg = refundArg;
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

}
