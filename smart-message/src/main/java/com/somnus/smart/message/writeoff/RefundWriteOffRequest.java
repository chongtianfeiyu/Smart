package com.somnus.smart.message.writeoff;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class RefundWriteOffRequest extends Message {

	@NotEmpty
	private String writeOffType;
	@NotEmpty
	private String refundId;
	public String getWriteOffType() {
		return writeOffType;
	}
	public void setWriteOffType(String writeOffType) {
		this.writeOffType = writeOffType;
	}
	public String getRefundId() {
		return refundId;
	}
	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

}
