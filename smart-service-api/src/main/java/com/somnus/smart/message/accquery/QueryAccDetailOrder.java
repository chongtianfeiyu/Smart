package com.somnus.smart.message.accquery;

import java.math.BigDecimal;
import java.util.Date;

public class QueryAccDetailOrder {
	/**商户订单号*/
	private String cusTranNo;
	/**isp订单号*/
	private String ipsBillNo;
	/**应用交易流水号*/
	private String appTranNo;
	/**应用交易时间*/
	private Date appTranDate;
	/**账务处理时间*/
	private String accTime;
	/**币种代码*/
	private String ccyCode;
	/**交易类型*/
	private String tranType;
	/**交易类型名称*/
	private String tranTypeName;
	/**交易金额*/
	private BigDecimal tranAmt;
	/**收入或支出*/
	private String cdFlag;
	/**交易后发生额*/
	private BigDecimal curBal;
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

	public String getAccTime() {
		return accTime;
	}

	public void setAccTime(String accTime) {
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

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}

	public String getCdFlag() {
		return cdFlag;
	}

	public void setCdFlag(String cdFlag) {
		this.cdFlag = cdFlag;
	}

	public BigDecimal getCurBal() {
		return curBal;
	}

	public void setCurBal(BigDecimal curBal) {
		this.curBal = curBal;
	}

	public String getTranRemark() {
		return tranRemark;
	}

	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}
}
