package com.somnus.smart.message.account;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class IpsRefundRequest extends Message {
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
	private String payeeCode;
	@NotEmpty
	private String payeeType;
	@NotEmpty
	private String payeeAccCode;
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
	private String tranRemark;
	@NotEmpty
	private String refKind;

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

	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public String getPayeeType() {
		return payeeType;
	}

	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
	}

	public String getPayeeAccCode() {
		return payeeAccCode;
	}

	public void setPayeeAccCode(String payeeAccCode) {
		this.payeeAccCode = payeeAccCode;
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

	public String getTranRemark() {
		return tranRemark;
	}

	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}

	public String getRefKind() {
		return refKind;
	}

	public void setRefKind(String refKind) {
		this.refKind = refKind;
	}

}
