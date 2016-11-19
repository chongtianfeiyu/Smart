package com.somnus.smart.message.accquery;

import java.util.List;

import com.somnus.smart.message.Message;

public class QueryCusSubResponse extends Message {
	/**商户号*/
	//private String merCode;
	/**账户号*/
	private String merAccCode;
	/**返回集合元素*/
	private List<QueryCusSubOrder> acounts;

	/*public String getMerCode() {
		return merCode;
	}

	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}*/

	public String getMerAccCode() {
		return merAccCode;
	}

	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}

	public List<QueryCusSubOrder> getAcounts() {
		return acounts;
	}

	public void setAcounts(List<QueryCusSubOrder> acounts) {
		this.acounts = acounts;
	}
}
