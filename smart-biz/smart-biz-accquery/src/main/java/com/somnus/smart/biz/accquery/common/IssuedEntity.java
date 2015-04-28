package com.somnus.smart.biz.accquery.common;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @description: TODO 
 * @author yh.liu
 * date 2015年3月6日 下午6:14:57
 */
public class IssuedEntity {
	
	private String issTranNo;
	private BigDecimal tranAmt;
    private String payeeBankCode;
    private String payeeBankAccCode;
    private String payeeBankAccName;
    
    private String payerCode;
    private String payerAccCode;
    private Date accDate;
    private String ccyCode;
    private String appBatchNo;
    
    private String merName;

	public String getIssTranNo() {
		return issTranNo;
	}

	public void setIssTranNo(String issTranNo) {
		this.issTranNo = issTranNo;
	}

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getPayeeBankCode() {
		return payeeBankCode;
	}

	public void setPayeeBankCode(String payeeBankCode) {
		this.payeeBankCode = payeeBankCode;
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

	public String getPayerCode() {
		return payerCode;
	}

	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

	public String getPayerAccCode() {
		return payerAccCode;
	}

	public void setPayerAccCode(String payerAccCode) {
		this.payerAccCode = payerAccCode;
	}

	public Date getAccDate() {
		return accDate;
	}

	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}

	public String getCcyCode() {
		return ccyCode;
	}

	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public String getAppBatchNo() {
		return appBatchNo;
	}

	public void setAppBatchNo(String appBatchNo) {
		this.appBatchNo = appBatchNo;
	}
}
