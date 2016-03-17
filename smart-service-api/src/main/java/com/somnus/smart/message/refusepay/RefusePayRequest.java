package com.somnus.smart.message.refusepay;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class RefusePayRequest extends Message {

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
	private String ccyCode;
	@NotNull
	@DecimalMin("0.01") 
	private BigDecimal tranAmt;
	@NotEmpty
	private String channelCode;
	private String supplierCode;
	@NotEmpty
	private String oriAppTranNo;
	@NotNull
	private Date oriAPPTranDate;
	private String cardHolder;
	private String cardNo;
	private String cardNoEx;
	@NotEmpty
	private String refKind;
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
	public String getOriAppTranNo() {
		return oriAppTranNo;
	}
	public void setOriAppTranNo(String oriAppTranNo) {
		this.oriAppTranNo = oriAppTranNo;
	}
	public Date getOriAPPTranDate() {
		return oriAPPTranDate;
	}
	public void setOriAPPTranDate(Date oriAPPTranDate) {
		this.oriAPPTranDate = oriAPPTranDate;
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
	public String getRefKind() {
		return refKind;
	}
	public void setRefKind(String refKind) {
		this.refKind = refKind;
	}
	public String getTranRemark() {
		return tranRemark;
	}
	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}
}
