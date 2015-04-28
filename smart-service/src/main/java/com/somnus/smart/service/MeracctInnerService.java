package com.somnus.smart.service;

import com.somnus.smart.base.domain.CusSubaccinfo;

/**
 * 开内部账户
 * @author bo.zhang
 *
 */
public interface MeracctInnerService {
	
	/**
	 * 开内部账户
	 * @param request
	 * @throws Exception
	 * @return
	 */
	CusSubaccinfo txnMerInnerCreate(String relSubCode, String ccyCode) throws Exception;

}
