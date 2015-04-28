package com.somnus.smart.message.reticket;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class ReticketRequest extends Message {

    @NotEmpty
    private String tranCode;
	/**基础产品代码*/
	@NotEmpty
	private String prdCode;
	/**应用交易流水号*/
	@NotEmpty
	private String appTranNo;
	/**应用交易时间*/
	@NotNull
	private Date appTranDate;
	/**发起方标识0:收款方 1：付款方 2：其他*/
	@NotEmpty
	private String initiatorFlg;
	/**收款方代码*/
	@NotEmpty
	private String payeeCode;
	/**收款方类型*/
	@NotEmpty
	private String payeeType;
	/**收款方账户号*/
	@NotEmpty
	private String payeeAccCode;
	/**交易类型*/
	@NotEmpty
	private String tranType;
	/**币种*/
	@NotEmpty
	private String ccyCode;
	/**交易金额*/
	@NotNull
	@DecimalMin("0.01") 
	private BigDecimal tranAmt;
	/**交易备注*/
	private String tranRemark;
	/**银行号*/
	private String supplierCode;
	/**银行账号*/
	private String bankAccCode;
	/**原交易流水号*/
	@NotEmpty
	private String oriAppTranNo;

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
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getBankAccCode() {
		return bankAccCode;
	}
	public void setBankAccCode(String bankAccCode) {
		this.bankAccCode = bankAccCode;
	}
	public String getOriAppTranNo() {
		return oriAppTranNo;
	}
	public void setOriAppTranNo(String oriAppTranNo) {
		this.oriAppTranNo = oriAppTranNo;
	}
}
