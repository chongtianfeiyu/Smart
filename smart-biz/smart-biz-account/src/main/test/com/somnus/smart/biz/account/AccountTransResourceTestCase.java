package com.somnus.smart.biz.account;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.somnus.smart.biz.account.resource.AccountTransResource;
import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.AccountTransRequest;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.holder.ApplicationContextHolder;
import com.somnus.rest.core.client.RESTfulJsonClientFactory;

/** 
 * @description: TODO 
 * @author yh.liu
 * @date 2015年2月27日 下午4:20:10  
 */
public class AccountTransResourceTestCase extends AbstractTestSupport {
	private static final String BASE_URL = "http://localhost:8080/bacs/resource/";
	AccountTransResource accountTransResource = RESTfulJsonClientFactory.createClient(AccountTransResource.class, BASE_URL);
	@Test
    public void accountTrans() throws Exception {
	    AccountTransRequest request = new AccountTransRequest();
    	request.setSysCode("1002");//商户后台
    	request.setPrdCode("2001");//
    	
    	request.setBrcCode("test");
    	request.setChannelNo("test");
    	request.setTerminalNo("test");
    	request.setFrontNo("test");
    	request.setFrontTime("test");
    	
    	request.setTranCode("130101");//记账交易码  130101：标准转账 130102：标准到专用 130103：专用到标准 130104：专用道专用
    	
    	request.setIpsBillNo("BO123456789");
    	request.setAppTranNo("APP201504281001532400");
    	request.setAppTranDate(new Date());
    	request.setMerBillNo("BA123456789");//商户流水号
    	request.setInitiatorFlg("1");//发起方标识 0:收款方 1：付款方 2：其他
    	
    	request.setPayeeCode("/*100100100100*/");//个人没有，商户才有  其实就是商户号 merCode MER_CODE
        request.setPayeeType("0");//0： 个人  1： 商户  2 : ISP
        request.setPayeeAccCode("100100100100");
        
        request.setPayerCode("/*100100100110*/");//个人没有，商户才有  其实就是商户号 merCode MER_CODE
        request.setPayerType("0");//0： 个人  1： 商户  2 : ISP
        request.setPayerAccCode("100100100110");
        
        request.setTranType("111");
        request.setCcyCode("156");
        
        request.setTranAmt(new BigDecimal(100));//交易金额
        request.setOrdAmt(new BigDecimal(100));//商户递交的订单金额
        
        request.setIsFee("0");//手续费是否已计算 0:未计算 1：已计算
        request.setFeeWay("2");//手续费承担方 1：付款方 2：收款方 3：第三方
        request.setFeeAmt(new BigDecimal(1));
        request.setFeeType("1");//手续费计算方式1：定额 2：百分比
        request.setFeeRate(new BigDecimal(0.1));//手续费费率
        /*request.setThdAccCode("");*/
        request.setFeeStlMode("1");//手续费结算模式 1:日结  2：预付费  2：后结算
        request.setRefundFeeBk("0");//退款是否退手续费 0 不退手续费、1 退手续费
    	
    	
    	
    	System.out.println("账户转账请求>>>:"+ JsonUtils.toString(request));
    	AccountTransResource accountTransResource= ApplicationContextHolder.getBean(AccountTransResource.class);
    	AccountResponse accountResponse = accountTransResource.accountTrans(request);
        System.out.println("账户转账响应<<<:"+JsonUtils.toString(accountResponse));
    } 
}
