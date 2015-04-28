package com.somnus.smart.message.account;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

public class IssuedBatchConfirmRequest extends Message {
	@NotEmpty
	@Valid
	@Size(min=1)
	List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public static class Order {
		@NotEmpty
		private String batchNo;

		public String getBatchNo() {
			return batchNo;
		}

		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}
	}
}
