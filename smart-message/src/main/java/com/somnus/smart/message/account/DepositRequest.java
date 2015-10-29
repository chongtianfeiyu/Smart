package com.somnus.smart.message.account;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * DepositRequest 个人充值记账请求
 * 
 * @author Somnus
 */
public class DepositRequest extends Message {

	private static final long serialVersionUID = 1L;
	/** 记账交易码 */
    @NotEmpty
    private String tranCode;
    
    /** 基础产品代码*/
	@NotEmpty
	private String prdCode;
	
	/** isp订单号 */
	private String ipsBillNo;
    
    /** 应用交易流水号 */
    @NotEmpty
	private String appTranNo;
    
    /** 应用交易时间 */
	@NotNull
	private Date appTranDate;
	
	/** 商户订单号 */
	private String merBillNo;
	
	/** 支付流水号 */
	private String payTranNo;
	
	/** 收款方代码 */
	@NotEmpty
	private String payeeCode;
	
	/** 收款方类型 */
	@NotEmpty
	private String payeeType;
	
	/** 收款方账户号 */
	@NotEmpty
	private String payeeAccCode;
	
	/** 交易类型 */
	@NotEmpty
	private String tranType;
	
	/** 支付通道号 */
	@NotEmpty
	private String channelCode;
	
	/** 支付供应商编号 */
	@NotEmpty
	private String supplierCode;
	
	/** 币种 */
	@NotEmpty
	private String ccyCode;
	
	/** 交易金额 */
	@NotNull
	@DecimalMin("0.01") 
	private BigDecimal tranAmt;
	
	/** 订单金额 */
	@NotNull
	@DecimalMin("0")
	private BigDecimal ordAmt;
	
	/** 手续费承担方 */
	@NotEmpty
	@Pattern(regexp = "^[123]$",message = "must be either 1, 2, or 3" )
	private String feeWay;
	
	/** 手续费 */
	@NotNull
	@DecimalMin("0") 
	private BigDecimal feeAmt;
	
	/** 第三方手续费账户 */
	private String thdAccCode;
	
	/** 手续费结算模式 */
	@NotEmpty
    @Pattern(regexp = "^[123]$",message = "must be either 1, 2, or 3" )
	private String feeStlMode;
	
	/** 银行成本 */
	@NotNull
	@DecimalMin("0") 
	private BigDecimal bankCost;
	
	/** 通道对应银行收款账号 */
	@NotEmpty
	private String bankAccCode;
	
	/** 交易备注 */
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

	public String getPayTranNo() {
		return payTranNo;
	}

	public void setPayTranNo(String payTranNo) {
		this.payTranNo = payTranNo;
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

	public String getThdAccCode() {
		return thdAccCode;
	}

	public void setThdAccCode(String thdAccCode) {
		this.thdAccCode = thdAccCode;
	}

	public BigDecimal getBankCost() {
		return bankCost;
	}

	public void setBankCost(BigDecimal bankCost) {
		this.bankCost = bankCost;
	}

	public String getTranRemark() {
		return tranRemark;
	}

	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}

	public String getFeeStlMode() {
		return feeStlMode;
	}

	public void setFeeStlMode(String feeStlMode) {
		this.feeStlMode = feeStlMode;
	}

	public String getBankAccCode() {
		return bankAccCode;
	}

	public void setBankAccCode(String bankAccCode) {
		this.bankAccCode = bankAccCode;
	}

}
