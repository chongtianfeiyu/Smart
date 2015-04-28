package com.somnus.smart.message.custom;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

/**
 * 差异补记账输出
 * @author tp.li
 *
 */
public class AddAccountResponse extends Message {

	private static final long serialVersionUID = 1L;
	/** 发送系统编号 */
    @NotEmpty
    private String sysCode;
    /** 机构码 */
	@NotEmpty
	private String prdCode;
	/** 渠道编号 */
	@NotEmpty
	private String channelNo;
	/** 终端号 */
	private String terminalNo;
	/** 前置机编号 */
	@NotEmpty
	private String frontNo;
	/** 前置发起时间 */
	@NotNull
	private String frontTime;
    public String getSysCode() {
        return sysCode;
    }
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }
    public String getPrdCode() {
        return prdCode;
    }
    public void setPrdCode(String prdCode) {
        this.prdCode = prdCode;
    }
    public String getChannelNo() {
        return channelNo;
    }
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }
    public String getTerminalNo() {
        return terminalNo;
    }
    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }
    public String getFrontNo() {
        return frontNo;
    }
    public void setFrontNo(String frontNo) {
        this.frontNo = frontNo;
    }
    public String getFrontTime() {
        return frontTime;
    }
    public void setFrontTime(String frontTime) {
        this.frontTime = frontTime;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
