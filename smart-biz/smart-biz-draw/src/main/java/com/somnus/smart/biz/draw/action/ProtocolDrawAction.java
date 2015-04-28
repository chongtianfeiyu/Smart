/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.biz.draw.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.smart.base.domain.TrnTransfer;
import com.somnus.smart.biz.draw.service.ProtocolDrawService;
import com.somnus.smart.service.BasBizService;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.service.common.DrawConstants;
import com.somnus.smart.support.exceptions.BizException;
import com.somnus.smart.support.jms.AbstractJmsReceiveTemplate;

/**
 * 账户核心记账
 * 
 * @author IH745
 * @version 1.0 13-10-11
 */
public class ProtocolDrawAction extends AbstractJmsReceiveTemplate {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ProtocolDrawService protocolDrawService;
	@Resource
	private BasBizService basBizService;

	@Override
	protected void execute(Object message) throws Exception {
		log.info("-------协议出款异步调用开始--------");
		log.info("接收消息：{}", message);
		try {
			if (!(message instanceof String)) {
				throw new BizException("报文对象不匹配！");
			}
			String batchNo = (String)message;
			TrnTransfer trnTransferQuery = new TrnTransfer();
			Date accDate = basBizService.getSystemAccDate();
			trnTransferQuery.setStatus(DrawConstants.TRANSFER_STATUS_DEALING);
			trnTransferQuery.setBatchNo(batchNo);
			List<TrnTransfer> transferList = protocolDrawService.selectProtocolTransfer(trnTransferQuery);
			for(TrnTransfer trnTransfer:transferList){
				try{
					protocolDrawService.protocolDraw(trnTransfer, accDate);
				}catch (Exception ex) {
					trnTransfer.setCurBal(null);
					trnTransfer.setFreezeBal(null);
					trnTransfer.setTranAmount(null);
					trnTransfer.setReserveBal(null);
					trnTransfer.setStatus(DrawConstants.TRANSFER_STATUS_FAIL);
					protocolDrawService.update(trnTransfer);
					log.error("异常账户号："+trnTransfer.getMerAccCode());
					log.error(Constants.EXCEPTION_ERROR, ex);
				}
			}
		} catch (BizException e) {
			log.error(Constants.BUSINESS_ERROR, e);
		} catch (Exception ex) {
			log.error(Constants.EXCEPTION_ERROR, ex);
		}
		log.info("-------协议出款异步调用结束--------");
	}
}
