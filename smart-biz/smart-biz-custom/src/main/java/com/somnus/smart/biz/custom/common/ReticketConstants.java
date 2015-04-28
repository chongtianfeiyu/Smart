package com.somnus.smart.biz.custom.common;

import com.somnus.smart.service.common.BasConstants;

public class ReticketConstants extends BasConstants {
	/**
	 * 出款处理状态 0: 未出款 1：已出款
	 */
	public static final String DRAW_STATUS_NOT = "0";
	public static final String DRAW_STATUS_OUT = "1";
	public static final String DRAW_STATUS_CONFIRM = "2";

	/**
	 * 冻结-扣划
	 */
	public static final String ENTRY_KEY_BUCKLE = "6101700";
	
	/** 冻结类型 1:冻结*/
	public static final String FREEZE_TRANTYPE_FREEZE = "1";
	/** 冻结类型 2::解冻*/
	public static final String FREEZE_TRANTYPE_UNFREEZE = "2";

	/** 冻结类型 1:交易冻结  */
	public static final String FREEZE_TYPE_TRAN="1";
	/** 冻结类型  2:余额冻结 */
	public static final String FREEZE_TYPE_CUR="2";
}
