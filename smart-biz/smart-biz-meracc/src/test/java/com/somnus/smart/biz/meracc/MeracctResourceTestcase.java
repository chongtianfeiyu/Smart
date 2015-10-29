package com.somnus.smart.biz.meracc;

import org.junit.Test;

import com.somnus.smart.biz.meracc.resource.MeracctResource;
import com.somnus.smart.message.Message;
import com.somnus.smart.message.meracct.PerAccountRequest;
import com.somnus.smart.message.meracct.PerAccountUpdRequest;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.holder.ApplicationContextHolder;
import com.somnus.smart.support.util.DateUtil;
import com.somnus.rest.core.client.RESTfulJsonClientFactory;

/** 
 * @description: TODO 
 * @author Somnus
 * @date 2015年2月9日 上午10:05:15  
 */
public class MeracctResourceTestcase extends AbstractTestSupport {
	private static final String BASE_URL = "http://localhost:8080/smart/resource/";
	/*MeracctResource meracctResource = RESTfulJsonClientFactory.createClient(MeracctResource.class, BASE_URL);*/
	@Test
    public void insertPerAcct() throws Exception {
    	PerAccountRequest request = new PerAccountRequest();
    	request.setSysCode("test");
    	request.setBrcCode("test");
    	request.setChannelNo("test");
    	request.setTerminalNo("test");
    	request.setFrontNo("test");
    	request.setFrontTime("test");
    	
    	request.setAcctCode("100100100120");//100100100121
    	request.setAcctName("个人账户标准户3");
    	request.setUserId("10002");
    	request.setEmail("10002@qq.com");
    	request.setMobile("18850654039");
    	request.setBankCode("1000");
    	request.setBankName("bank1000");
    	request.setBankAcctNo("62260898");
    	request.setBankAcctName("环迅支付");
    	request.setCcyCode("156");
    	request.setLevel("1");
    	request.setOpenDate(DateUtil.getCurrentDate());
    	request.setOpenBy("Somnus");
    	//1：标准账户 2：专用账户 
    	request.setAcctType("1");
    	/*request.setStdAcctCode("acc10001"); 账户类型为专用账户时必需*/
    	
    	System.out.println("个人开户请求>>>:"+ JsonUtils.toString(request));
    	MeracctResource meracctResource= ApplicationContextHolder.getBean(MeracctResource.class);
    	Message message = meracctResource.createPersonAccount(request);
        System.out.println("个人开户响应<<<:"+JsonUtils.toString(message));
    }
	
	@Test
    public void updatePersonAccount() throws Exception {
		PerAccountUpdRequest request = new PerAccountUpdRequest();
    	request.setSysCode("test");
    	request.setBrcCode("test");
    	request.setChannelNo("test");
    	request.setTerminalNo("test");
    	request.setFrontNo("test");
    	request.setFrontTime("test");
    	
    	request.setAcctCode("100100100100");
    	request.setAcctName("个人账户标准户");
    	request.setUserId("10001");
    	request.setEmail("361674465@qq.com");
    	request.setMobile("15870652038");
    	request.setBankCode("1000");
    	request.setBankName("bank1000");
    	request.setBankAcctNo("62260898");
    	request.setBankAcctName("环迅支付");
    	request.setCcyCode("156");
    	request.setLevel("1");
    	
    	System.out.println("个人账户变更请求>>>:"+ JsonUtils.toString(request));
    	MeracctResource meracctResource= ApplicationContextHolder.getBean(MeracctResource.class);
    	Message message=meracctResource.updatePersonAccount(request);
        System.out.println("个人账户变更响应<<<:"+JsonUtils.toString(message));
    }
}
