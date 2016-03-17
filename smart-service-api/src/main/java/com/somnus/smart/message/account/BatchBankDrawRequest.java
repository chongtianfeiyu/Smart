package com.somnus.smart.message.account;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class BatchBankDrawRequest extends Message {
	/** 下发批次号 */
    @NotEmpty
    private String tranCode;
	@NotEmpty
	private String appBatchNo;
	/** 下发总笔数 */
	private int batchCount;
	/** 下发总金额 */
	@NotNull
	private BigDecimal batchAmt;
	/** 基础产品代码 */
	@NotEmpty
	private String prdCode;
	/** 发起方标识 */
	@NotEmpty
	private String initiatorFlg;
	/** 付款方代码 */
	@NotEmpty
	private String payerCode;
	/** 付款方类型 */
	@NotEmpty
	private String payerType;
	/** 付款方账户号 */
	@NotEmpty
	private String payerAccCode;
	/** 交易类型 */
	@NotEmpty
	private String tranType;
	/** 币种 */
	@NotEmpty
	private String ccyCode;
	/** 手续费是否已计算 */
	@NotEmpty
	private String isFee;
	/** 手续费承担方 */
	@NotEmpty
	@Pattern(regexp = "^[13]$",message = "must be either 1,3" )
	private String feeWay;
	/** 手续费 */
	@NotNull
	@DecimalMin("0") 
	private BigDecimal totalFeeAmt;
	/** 手续费计算方式 */
	@NotEmpty
	@Pattern(regexp = "^[12]$",message = "must be either 1, 2" )
	private String feeType;
	/** 手续费费率 */
	@NotNull
	private BigDecimal feeRate;
	/** 第三方手续费账户 */
	private String thdAccCode;
	/** 手续费结算模式 */
	@NotEmpty
	@Pattern(regexp = "^[1]$",message = "must be either 1" )
	private String feeStlMode;
	/** 退款是否退手续费 */
	@NotEmpty
	private String refundFeeBk;
	/** 集合  */
	@NotEmpty
	@Valid
	@Size(min=1)
	private List<Order> orders;

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getAppBatchNo() {
		return appBatchNo;
	}
	public void setAppBatchNo(String appBatchNo) {
		this.appBatchNo = appBatchNo;
	}
	public int getBatchCount() {
		return batchCount;
	}
	public void setBatchCount(int batchCount) {
		this.batchCount = batchCount;
	}
	public BigDecimal getBatchAmt() {
		return batchAmt;
	}
	public void setBatchAmt(BigDecimal batchAmt) {
		this.batchAmt = batchAmt;
	}
	public String getPrdCode() {
		return prdCode;
	}
	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
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
	public String getIsFee() {
		return isFee;
	}
	public void setIsFee(String isFee) {
		this.isFee = isFee;
	}
	public String getFeeWay() {
		return feeWay;
	}
	public void setFeeWay(String feeWay) {
		this.feeWay = feeWay;
	}
	public BigDecimal getTotalFeeAmt() {
		return totalFeeAmt;
	}
	public void setTotalFeeAmt(BigDecimal totalFeeAmt) {
		this.totalFeeAmt = totalFeeAmt;
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
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	public static class Order{
		@NotEmpty
		private String ipsBillNo;
		@NotEmpty
		private String appTranNo;
		@NotNull
		private Date appTranDate;
		@NotEmpty
		private String merBillNo;
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
		@NotNull
		@DecimalMin("0.01") 
		private BigDecimal tranAmt;
		@NotNull
		@DecimalMin("0") 
		private BigDecimal feeAmt;
		@NotNull
		@DecimalMin("0") 
		private BigDecimal ordAmt;
		private String tranRemark;
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
		public String getTranRemark() {
			return tranRemark;
		}
		public void setTranRemark(String tranRemark) {
			this.tranRemark = tranRemark;
		}
		public BigDecimal getFeeAmt() {
			return feeAmt;
		}
		public void setFeeAmt(BigDecimal feeAmt) {
			this.feeAmt = feeAmt;
		}
	}

}
