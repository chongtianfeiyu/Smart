package com.somnus.smart.message.custom;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class TranFreezeRequest extends Message {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String appTranNo;//	交易流水号	M	10	
	@NotEmpty
	private String tranType;//	交易类型	M	8	1:冻结 2:解冻
	@NotEmpty
	private String appFreezeNo;
	public String getAppTranNo() {
		return appTranNo;
	}
	public void setAppTranNo(String appTranNo) {
		this.appTranNo = appTranNo;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getAppFreezeNo() {
		return appFreezeNo;
	}
	public void setAppFreezeNo(String appFreezeNo) {
		this.appFreezeNo = appFreezeNo;
	}
}
