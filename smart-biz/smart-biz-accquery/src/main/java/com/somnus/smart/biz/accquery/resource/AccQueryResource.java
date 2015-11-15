package com.somnus.smart.biz.accquery.resource;

import javax.validation.Valid;

import com.somnus.smart.message.accquery.CussubQueryRequest;
import com.somnus.smart.message.accquery.CussubQueryResponse;
import com.somnus.smart.message.accquery.IssuedAccDetailQueryRequest;
import com.somnus.smart.message.accquery.IssuedAccDetailQueryResponse;
import com.somnus.smart.message.accquery.IssuedAccQueryRequest;
import com.somnus.smart.message.accquery.IssuedAccQueryResponse;
import com.somnus.smart.message.accquery.QueryAccDetailRequest;
import com.somnus.smart.message.accquery.QueryAccDetailResponse;
import com.somnus.smart.message.accquery.QueryCusFifRequest;
import com.somnus.smart.message.accquery.QueryCusFifResponse;
import com.somnus.smart.message.accquery.QueryCusSubAccRequest;
import com.somnus.smart.message.accquery.QueryCusSubResponse;
import com.somnus.smart.message.accquery.QueryPayAppRequest;
import com.somnus.smart.message.accquery.QueryPayAppResponse;

public interface AccQueryResource {

	/**
	 * 账户可用余额查询
	 * @param request
	 * @return
	 */
	CussubQueryResponse queryCusCurBal(@Valid CussubQueryRequest request);
	
	/**
	 * 账户余额查询
	 * @param request
	 * @return
	 */
	public QueryCusSubResponse queryCusSubAccInfo(@Valid QueryCusSubAccRequest request);
	
	/**
	 * 下发审核查询
	 * @param request
	 * @return
	 */
	IssuedAccQueryResponse queryIssuedAcc(@Valid IssuedAccQueryRequest request);
	
	/**
	 * 下发审核明细查询
	 * @param request
	 * @return
	 */
	IssuedAccDetailQueryResponse queryIssuedAccDetail(@Valid IssuedAccDetailQueryRequest request);
	
	/**
	 * 商户账户收支明细查询
	 * @param request
	 * @return
	 */
	public QueryAccDetailResponse queryAccDetail(@Valid QueryAccDetailRequest request);
	
	/**
	 * 商户在途交易明细查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	QueryCusFifResponse queryCusFif(@Valid QueryCusFifRequest request);
	
	/**
	 * 拒付审批查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	QueryPayAppResponse queryPaymentApp(@Valid QueryPayAppRequest request);
	
}
