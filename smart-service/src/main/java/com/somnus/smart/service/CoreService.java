/**
 * 
 */
package com.somnus.smart.service;

import java.math.BigDecimal;

import com.somnus.smart.service.common.enums.AccountType;

/**
 * 余额变更处理service
 * 
 * @author IH745
 * 
 */
public interface CoreService {


	/**
	 * 新增业务冻结金额
	 * 
	 * @param subAccCode
	 * @param tranAmt
	 */
	void addBizFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt);

	/**
	 * 减少业务冻结金额
	 * 
	 * @param subAccCode
	 * @param tranAmt
	 */
	void subtractBizFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt);

	/**
	 * 新增监管冻结金额
	 * 
	 * @param subAccCode
	 * @param tranAmt
	 */
	void addMagFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt);

	/**
	 * 减少监管冻结金额
	 * 
	 * @param subAccCode
	 * @param tranAmt
	 */
	void subtractMagFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt);

	/**
	 * 新增应付冻结金额
	 * 
	 * @param subAccCode
	 * @param tranAmt
	 */
	void addPayableFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt);

	/**
	 * 减少应付冻结金额
	 * 
	 * @param subAccCode
	 * @param tranAmt
	 */
	void subtracPayableFreezeBal(AccountType accountType,String subAccCode, BigDecimal tranAmt);


}
