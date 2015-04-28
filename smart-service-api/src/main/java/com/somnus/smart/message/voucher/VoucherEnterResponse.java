package com.somnus.smart.message.voucher;

import java.util.Date;
import java.util.List;

import com.somnus.smart.message.Message;

public class VoucherEnterResponse extends Message {

	private static final long serialVersionUID = 1L;

	private List<Result> results;

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public static class Result {
		private String appTranNo;
		private String accTranNo;
		private Date accDate;
		private String accStatus;

		public String getAppTranNo() {
			return appTranNo;
		}

		public void setAppTranNo(String appTranNo) {
			this.appTranNo = appTranNo;
		}

		public String getAccTranNo() {
			return accTranNo;
		}

		public void setAccTranNo(String accTranNo) {
			this.accTranNo = accTranNo;
		}

		public Date getAccDate() {
			return accDate;
		}

		public void setAccDate(Date accDate) {
			this.accDate = accDate;
		}

		public String getAccStatus() {
			return accStatus;
		}

		public void setAccStatus(String accStatus) {
			this.accStatus = accStatus;
		}

	}
}
