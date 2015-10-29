package com.somnus.smart.message.custom;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 扣划请求
 * 
 * @author IH745
 *
 */
public class BuckleDrawRequest extends Message {

	private static final long serialVersionUID = 1L;
	/** 记账交易码6201 */
    @NotEmpty
    private String tranCode;
    /** 基础产品代码 */
	private String prdCode;
	/** 订单号 */
	private String ipsBillNo;
	/** 应用交易流水号 */
	@NotEmpty
	private String appTranNo;
	/** 应用交易时间 */
	@NotNull
	private Date appTranDate;
	/** 付款方代码 */
	@NotEmpty
	private String payerCode;
	@NotEmpty
	/** 付款方类型0： 个人  1： 商户  2 : ISP */
	private String payerType;
	/** 付款方账号 */
	@NotEmpty
	private String payerAccCode;
	/** 交易类型 */
	@NotEmpty
	private String tranType;
	/** 币种 */
	@NotEmpty
	private String ccyCode;
	/** 交易金额 */
	@NotNull
	@DecimalMin("0.01") 
	private BigDecimal tranAmt;
	/** 公安凭证号 */
	@NotEmpty
	private String voucherNo;
	/** 1：余额扣划  2：冻结扣划 */
	@NotEmpty
	private String deductType;
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
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	public String getDeductType() {
		return deductType;
	}
	public void setDeductType(String deductType) {
		this.deductType = deductType;
	}

	
}
