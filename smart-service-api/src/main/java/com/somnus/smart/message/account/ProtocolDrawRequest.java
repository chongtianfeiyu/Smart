package com.somnus.smart.message.account;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class ProtocolDrawRequest extends Message {
	@NotEmpty
	private String transferType;
	private List<Order> orders;
	
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	public static class Order{
		private String merAccCode;
		private String transferId;

		public String getMerAccCode() {
			return merAccCode;
		}

		public void setMerAccCode(String merAccCode) {
			this.merAccCode = merAccCode;
		}

		public String getTransferId() {
			return transferId;
		}

		public void setTransferId(String transferId) {
			this.transferId = transferId;
		}
		
	}

}
