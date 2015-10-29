package com.somnus.smart.message.custom;

import java.util.List;

import com.somnus.smart.message.Message;

/**
 * 差异补记账输入
 * @author tp.li
 *
 */
public class AddAccountRequest extends Message {

    private static final long serialVersionUID = 1L;
    private List<Order>       orders;

    public static class Order {
        /** 补记账差异流水号 */
        private String errNo;

        public String getErrNo() {
            return errNo;
        }
        
        public void setErrNo(String errNo) {
            this.errNo = errNo;
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
