package com.somnus.smart.biz.income;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.somnus.rest.core.client.RESTfulJsonClientFactory;
import com.somnus.smart.biz.income.resource.IncomeResource;
import com.somnus.smart.message.account.AccountResponse;
import com.somnus.smart.message.account.DepositRequest;
import com.somnus.smart.message.account.IncomeRequest;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.holder.ApplicationContextHolder;


/** 
 * @description: TODO 
 * @author yh.liu
 * @date 2015年2月27日 下午4:20:10  
 */
public class IncomeResourceTestCase extends AbstractTestSupport {
	private static final String BASE_URL = "http://localhost:8080/bacs/resource/";
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
    	IncomeResource incomeResource= ApplicationContextHolder.getBean(IncomeResource.class);
    	AccountResponse accountResponse = incomeResource.deposit(request);
        System.out.println("个人充值响应<<<:"+JsonUtils.toString(accountResponse));
    } 
	
	
	@Test
    public void bankIncome() throws Exception {
	    IncomeRequest request = new IncomeRequest();
	    request.setSysCode("1002");//商户后台
        request.setPrdCode("1301");//
        
        request.setBrcCode("test");
        request.setChannelNo("test");
        request.setTerminalNo("test");
        request.setFrontNo("test");
        request.setFrontTime("test");
        
        request.setTranCode("1302");
        
        request.setAppTranNo("APP201504301001532500");
        request.setAppTranDate(new Date());
        request.setMerBillNo("BA123456789");//商户流水号
        request.setInitiatorFlg("1");//发起方标识 0:收款方 1：付款方 2：其他
        
        request.setPayeeCode("100976");//个人没有，商户才有  其实就是商户号 merCode MER_CODE
        request.setPayeeType("1");//0： 个人  1： 商户  2 : IPS
        request.setPayeeAccCode("1009760040");
        
        request.setTranAmt(new BigDecimal(100));
        request.setOrdAmt(new BigDecimal(100));
        
        request.setTranType("1111");
        request.setCcyCode("156");
        request.setSupplierCode("1100");//支付供应商编号 也就是银行啦
        
        request.setChannelCode("1101");
        
        request.setBankCost(new BigDecimal(10));//通道成本
        request.setBankAccCode("1001278619005534066");//通道对应的银行收款账号
        request.setBankFeeType("1");//计费方式（百分比、固定、包量）
        request.setBankFeeRate(new BigDecimal(10));//通道费率
        request.setSecurityDeposit(new BigDecimal(10));//保证金

        
        request.setIsFee("0");//手续费是否已计算 0:未计算 1：已计算
        request.setFeeAmt(new BigDecimal(1));//交易手续费
        request.setFeeWay("1");//手续费承担方 1：付款方 2：收款方 3：第三方
        request.setFeeType("1");//手续费计算方式1：定额 2：百分比
        request.setFeeRate(new BigDecimal(0.1));//手续费费率
        /*request.setThdAccCode("");*/
        request.setFeeStlMode("1");//手续费结算模式 1:日结  2：预付费  2：后结算
        request.setRefundFeeBk("0");//退款是否退手续费 0 不退手续费、1 退手续费
        
        System.out.println("银行收单请求>>>:"+ JsonUtils.toString(request));
        IncomeResource incomeResource= ApplicationContextHolder.getBean(IncomeResource.class);
        AccountResponse accountResponse = incomeResource.bankIncome(request);
        System.out.println("银行收单响应<<<:"+JsonUtils.toString(accountResponse));
    } 
}
