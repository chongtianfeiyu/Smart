package com.somnus.smart.biz.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.somnus.smart.biz.account.resource.BatchIpsDrawResource;
import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.BatchIpsDrawRequest;
import com.somnus.smart.message.account.BatchIpsDrawRequest.Order;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.holder.ApplicationContextHolder;
import com.somnus.rest.core.client.RESTfulJsonClientFactory;

/** 
 * @description: TODO 
 * @author Somnus
 * @date 2015年2月27日 下午4:20:10  
 */
public class BatchIpsDrawResourceTestCase extends AbstractTestSupport {
	private static final String BASE_URL = "http://localhost:8080/bacs/resource/";
	BatchIpsDrawResource batchIpsDrawResource = RESTfulJsonClientFactory.createClient(BatchIpsDrawResource.class, BASE_URL);
	@Test
    public void batchIpsDraw() throws Exception {
	    BatchIpsDrawRequest request = new BatchIpsDrawRequest();
    	request.setSysCode("1002");//商户后台
    	request.setPrdCode("2001");//
    	
    	request.setBrcCode("test");
    	request.setChannelNo("test");
    	request.setTerminalNo("test");
    	request.setFrontNo("test");
    	request.setFrontTime("test");
    	
    	request.setTranCode("1302");
    	
    	request.setInitiatorFlg("1");//发起方标识 0:收款方 1：付款方 2：其他
    	
        request.setPayerCode("100976");//个人没有，商户才有  其实就是商户号 merCode MER_CODE
        request.setPayerType("1");//0： 个人  1： 商户  2 : ISP
        request.setPayerAccCode("1009760040");
        
        request.setTranType("111");
        request.setCcyCode("156");
        
        request.setIsFee("0");//手续费是否已计算 0:未计算 1：已计算
        request.setFeeWay("2");//手续费承担方 1：付款方 2：收款方 3：第三方
        request.setFeeType("1");//手续费计算方式1：定额 2：百分比
        request.setFeeRate(new BigDecimal(0.1));//手续费费率
        /*request.setThdAccCode("");*/
        request.setFeeStlMode("1");//手续费结算模式 1:日结  2：预付费  2：后结算
        request.setRefundFeeBk("0");//退款是否退手续费 0 不退手续费、1 退手续费
        
        request.setAppBatchNo("APP201504281001532499");
        request.setBatchCount(1);
        request.setBatchAmt(new BigDecimal(100));
        request.setTotalFeeAmt(new BigDecimal(1));
        
        Order order = new Order();
        order.setIpsBillNo("BO223456789");
        order.setAppTranNo("APP201504281001532498");
        order.setAppTranDate(new Date());
        order.setMerBillNo("BA223456789");//商户流水号
        order.setPayeeCode("/*100100100100*/");//个人没有，商户才有  其实就是商户号 merCode MER_CODE
        order.setPayeeType("0");//0： 个人  1： 商户  2 : ISP
        order.setPayeeAccCode("100100100100");
        order.setTranAmt(new BigDecimal(100));//交易金额
        order.setFeeAmt(new BigDecimal(1));//手续费
        order.setOrdAmt(new BigDecimal(100));//商户递交的订单金额
        
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);
        request.setOrders(orders);
    	
    	
    	System.out.println("委托付款[账户下发]请求>>>:"+ JsonUtils.toString(request));
    	BatchIpsDrawResource batchIpsDrawResource= ApplicationContextHolder.getBean(BatchIpsDrawResource.class);
    	AccountResponse accountResponse = batchIpsDrawResource.batchIpsDraw(request);
        System.out.println("委托付款[账户下发]响应<<<:"+JsonUtils.toString(accountResponse));
    } 
}
