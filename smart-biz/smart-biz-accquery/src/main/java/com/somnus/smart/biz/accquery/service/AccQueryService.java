package com.somnus.smart.biz.accquery.service;

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

/**
 * 查询接口
 * @author bo.zhang
 *
 */
public interface AccQueryService {
	
	/**
	 * 账户可用余额查询
	 * @param request
	 * @return
	 */
	CussubQueryResponse queryCusCurBal(CussubQueryRequest request);
	
	/**
	 * 下发审批明细查询
	 * @param request
	 * @return
	 */
	IssuedAccDetailQueryResponse queryIssuedAccDetail(IssuedAccDetailQueryRequest request);
	
	/**
	 * 下发审批查询
	 * @param request
	 * @return
	 */
	IssuedAccQueryResponse queryIssuedAcc(IssuedAccQueryRequest request);
	
	/**
	 * 账户余额查询
	 * @param request
	 * @return
	 */
	QueryCusSubResponse queryCusSubAccInfo(QueryCusSubAccRequest request) throws Exception ;
	
	/**
	 * 商户账户收支明细查询
	 * @param request
	 * @return
	 */
	QueryAccDetailResponse queryAccDetail(QueryAccDetailRequest request) throws Exception ;
	
	/**
	 * 商户在途交易明细查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	QueryCusFifResponse queryCusFif(QueryCusFifRequest request) throws Exception;
	
	/**
	 * 拒付审批查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	QueryPayAppResponse queryPaymentApp(QueryPayAppRequest request) throws Exception;

}
