package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.Date;

public class QueryCusFifOrder {
	
	/**商户订单号*/
	private String cusTranNo;
	/**IPS订单号*/
	private String ipsBillNo;
	/**应用交易流水号*/
	private String appTranNo;
	/**应用交易时间*/
	private Date appTranDate;
	/**账务处理时间*/
	private Date accTime;
	/**币种代码*/
	private String ccyCode;
	/**交易类型*/
	private String tranType;
	/**交易类型名称*/
	private String tranTypeName;
	/**订单金额*/
	private BigDecimal ordAmt;
	/**交易状态*/
	private String status;
	/**交易备注*/
	private String tranRemark;
	public String getCusTranNo() {
		return cusTranNo;
	}
	public void setCusTranNo(String cusTranNo) {
		this.cusTranNo = cusTranNo;
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
	public Date getAccTime() {
		return accTime;
	}
	public void setAccTime(Date accTime) {
		this.accTime = accTime;
	}
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getTranTypeName() {
		return tranTypeName;
	}
	public void setTranTypeName(String tranTypeName) {
		this.tranTypeName = tranTypeName;
	}
	public BigDecimal getOrdAmt() {
		return ordAmt;
	}
	public void setOrdAmt(BigDecimal ordAmt) {
		this.ordAmt = ordAmt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTranRemark() {
		return tranRemark;
	}
	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}
}
