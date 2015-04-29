package com.somnus.smart.biz.income;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.somnus.smart.biz.income.resource.IncomeResource;
import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.DepositRequest;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.holder.ApplicationContextHolder;
import com.somnus.rest.core.client.RESTfulJsonClientFactory;

/** 
 * @description: TODO 
 * @author yh.liu
 * @date 2015年2月27日 下午4:20:10  
 */
public class IncomeResourceTestCase extends AbstractTestSupport {
	private static final String BASE_URL = "http://localhost:8080/smart/resource/";
	IncomeResource incomeResource = RESTfulJsonClientFactory.createClient(IncomeResource.class, BASE_URL);
	@Test
    public void deposit() throws Exception {
		DepositRequest request = new DepositRequest();
    	request.setSysCode("1002");
    	request.setBrcCode("test");
    	request.setChannelNo("test");
    	request.setTerminalNo("test");
    	request.setFrontNo("test");
    	request.setFrontTime("test");
    	
    	request.setTranCode("110302");
    	request.setPrdCode("1401");
    	request.setAppTranNo("666");//111标付 222标收 333专收 444专付 555专三
    	request.setAppTranDate(new Date());
    	request.setMerBillNo("111");
    	request.setPayeeCode("111");
    	request.setPayeeType("0");
    	/*request.setPayeeAccCode("100100100100");*/
    	request.setPayeeAccCode("100100100101");
    	request.setTranType("111");
    	request.setChannelCode("1107111100000076");
    	request.setSupplierCode("1124");
    	request.setCcyCode("156");
    	request.setTranAmt(new BigDecimal(20));//如果是付款方承担手续费，金额 = 订单+手续费
    	/*request.setTranAmt(new BigDecimal(20));*/
    	request.setOrdAmt(new BigDecimal(20));
    	request.setFeeWay("3");
    	request.setFeeAmt(new BigDecimal(2));
    	request.setFeeStlMode("1");
    	request.setBankCost(new BigDecimal(2));
    	request.setBankAccCode("1803000103000005101");
    	request.setThdAccCode("1009760040");
    	
    	System.out.println("个人充值请求>>>:"+ JsonUtils.toString(request));
    	/*IncomeResource incomeResource= ApplicationContextHolder.getBean(IncomeResource.class);*/
    	AccountResponse accountResponse = incomeResource.deposit(request);
        System.out.println("个人充值响应<<<:"+JsonUtils.toString(accountResponse));
    } 
}
