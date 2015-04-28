package com.somnus.smart.biz.custom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somnus.smart.biz.custom.dao.CusTranRefundDao;
import com.somnus.smart.biz.custom.service.TrnTranRefundService;

@Service
public class TrnTranRefundServiceImpl implements TrnTranRefundService {
	
	@Autowired
	private CusTranRefundDao trnTranRefundDao;

	@Override
	public String queryRefType(String appTranNo) {
		return trnTranRefundDao.selectRefType(appTranNo);
	}

}
