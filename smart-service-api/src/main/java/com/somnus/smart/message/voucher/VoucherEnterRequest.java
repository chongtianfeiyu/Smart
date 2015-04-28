package com.somnus.smart.message.voucher;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class VoucherEnterRequest  extends Message {


	private static final long serialVersionUID = 1L;
	@NotEmpty
	@Valid
	@Size(min=1)
	private List<Voucher> vouchers;
	
	
	public List<Voucher> getVouchers() {
		return vouchers;
	}


	public void setVouchers(List<Voucher> vouchers) {
		this.vouchers = vouchers;
	}
	public static class Voucher{
		/** 记账交易码 6501 */
		@NotEmpty 
		private String tranCode;
		@NotEmpty
		private String prdCode;//	基础产品代码
		@NotEmpty
		private String appTranNo;//	应用交易流水号
		@NotNull
		private Date appTranDate;//	应用交易时间
		@NotEmpty
		private String tranType;//	交易类型
		@NotEmpty
		private String ccyCode;//	币种
		private String tranRemark;//	备注
		@NotEmpty
		private String subCode1st;//	科目号1
		@NotNull
		private Short subIndex1st;//	科目序号1
		@NotEmpty
		private String cdFlag1st;//	借贷方向1
		@NotNull
		private BigDecimal tranAmt1st;//	金额1
		@NotEmpty
		private String subCode2nd;//	科目号2
		@NotNull
		private Short subIndex2nd;//	科目序号2
		@NotEmpty
		private String cdFlag2nd;//	借贷方向2
		@NotNull
		private BigDecimal tranAmt2nd;//	金额2
		private String subCode3rd;//	科目号3
		private Short subIndex3rd;//	科目序号3
		private String cdFlag3rd;//	借贷方向3
		private BigDecimal tranAmt3rd;//	金额3
		private String subCode4th;//	科目号4
		private Short subIndex4th;//	科目序号4
		private String cdFlag4th;//	借贷方向4
		private BigDecimal tranAmt4th;//	金额4
		
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


		public String getTranRemark() {
			return tranRemark;
		}


		public void setTranRemark(String tranRemark) {
			this.tranRemark = tranRemark;
		}

		public String getSubCode1st() {
			return subCode1st;
		}
		public void setSubCode1st(String subCode1st) {
			this.subCode1st = subCode1st;
		}
		public Short getSubIndex1st() {
			return subIndex1st;
		}
		public void setSubIndex1st(Short subIndex1st) {
			this.subIndex1st = subIndex1st;
		}
		public String getCdFlag1st() {
			return cdFlag1st;
		}
		public void setCdFlag1st(String cdFlag1st) {
			this.cdFlag1st = cdFlag1st;
		}
		public BigDecimal getTranAmt1st() {
			return tranAmt1st;
		}
		public void setTranAmt1st(BigDecimal tranAmt1st) {
			this.tranAmt1st = tranAmt1st;
		}
		public String getSubCode2nd() {
			return subCode2nd;
		}
		public void setSubCode2nd(String subCode2nd) {
			this.subCode2nd = subCode2nd;
		}
		public Short getSubIndex2nd() {
			return subIndex2nd;
		}
		public void setSubIndex2nd(Short subIndex2nd) {
			this.subIndex2nd = subIndex2nd;
		}
		public String getCdFlag2nd() {
			return cdFlag2nd;
		}
		public void setCdFlag2nd(String cdFlag2nd) {
			this.cdFlag2nd = cdFlag2nd;
		}
		public BigDecimal getTranAmt2nd() {
			return tranAmt2nd;
		}
		public void setTranAmt2nd(BigDecimal tranAmt2nd) {
			this.tranAmt2nd = tranAmt2nd;
		}
		public String getSubCode3rd() {
			return subCode3rd;
		}
		public void setSubCode3rd(String subCode3rd) {
			this.subCode3rd = subCode3rd;
		}
		public Short getSubIndex3rd() {
			return subIndex3rd;
		}
		public void setSubIndex3rd(Short subIndex3rd) {
			this.subIndex3rd = subIndex3rd;
		}
		public String getCdFlag3rd() {
			return cdFlag3rd;
		}
		public void setCdFlag3rd(String cdFlag3rd) {
			this.cdFlag3rd = cdFlag3rd;
		}
		public BigDecimal getTranAmt3rd() {
			return tranAmt3rd;
		}
		public void setTranAmt3rd(BigDecimal tranAmt3rd) {
			this.tranAmt3rd = tranAmt3rd;
		}
		public String getSubCode4th() {
			return subCode4th;
		}
		public void setSubCode4th(String subCode4th) {
			this.subCode4th = subCode4th;
		}
		public Short getSubIndex4th() {
			return subIndex4th;
		}
		public void setSubIndex4th(Short subIndex4th) {
			this.subIndex4th = subIndex4th;
		}
		public String getCdFlag4th() {
			return cdFlag4th;
		}
		public void setCdFlag4th(String cdFlag4th) {
			this.cdFlag4th = cdFlag4th;
		}
		public BigDecimal getTranAmt4th() {
			return tranAmt4th;
		}
		public void setTranAmt4th(BigDecimal tranAmt4th) {
			this.tranAmt4th = tranAmt4th;
		}


		public String getTranCode() {
			return tranCode;
		}


		public void setTranCode(String tranCode) {
			this.tranCode = tranCode;
		}
		
	}
}
