package com.somnus.smart.message.writeoff;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class DrawWriteOffRequest extends Message {
	/** 核销类型	1:出款成功核销 2: 出款撤销核销 */
	@NotEmpty
	private String writeOffType;
	/** 出款流水号 */
	@NotEmpty
	private String drawId;

	public String getWriteOffType() {
		return writeOffType;
	}

	public void setWriteOffType(String writeOffType) {
		this.writeOffType = writeOffType;
	}

	public String getDrawId() {
		return drawId;
	}

	public void setDrawId(String drawId) {
		this.drawId = drawId;
	}

}
