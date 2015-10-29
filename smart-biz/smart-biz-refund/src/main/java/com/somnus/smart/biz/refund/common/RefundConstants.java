package com.somnus.smart.biz.refund.common;

import com.somnus.smart.service.common.BasConstants;

public class RefundConstants extends BasConstants {

	/**
	 * 可退款标志 0: 不可退 1：可退
	 */
	public final static String REF_FLAG_CANNOT ="0";
	public final static String REF_FLAG_CAN ="1";

	/** 退款类型 0:入账退款  */
	public final static String REF_TYPE_ACCOUNT="0";
	/** 退款类型  1:未入账退款 */
	public final static String REF_TYPE_ROUTE="1";
	
	/** 退款处理状态  1：已退款 */
	public final static String REF_STATUS_REFUNDED = "1";
	/** 退款处理状态  2：退款受理中  */
	public final static String REF_STATUS_HANDING= "0";
	/**
	 * 未入账退款，前缀
	 */
	public static final String ENTRY_KEY_NOT_ENTER_REFUND_PRE = "18011";
	/**
	 * 入账退款
	 */
	public static final String ENTRY_KEY_ENTERED_REFUND = "1802100";
	/**
	 * 自动退款  入账
	 */
	public static final String ENTRY_KEY_INCOME_AUTOREFUND = "6101100";
	/**
	 * isp退款
	 */
	public static final String ENTRY_KEY_IPS_REFUND = "1183000";
	
	public static final String ENTRY_KEY_REFUSEPAY_CONFIRM_ROUTE = "19011200";
	public static final String ENTRY_KEY_REFUSEPAY_DRAW_ACCOUNT = "19012300";
	public static final String ENTRY_KEY_REFUSEPAY_DRAW_ROUTE = "19011300";
	
	
	
	/**
	 * 退款返回处理状态 1:退款成功 2：退款受理中 3：退款失败
	 */
	public final static String REF_BACK_STATUS_SUCCESS = "0";
	public final static String REF_BACK_STATUS_DEALING = "1";
	public final static String REF_BACK_STATUS_FAIL= "2";
	
	/** 01: 银行退款 */
	public final static String BIZ_TYPE_BANKREFUND = "01";
	/** 02：自动退款*/
	public final static String BIZ_TYPE_AUTOREFUND = "02";
	/** 03：其他退款*/
	public final static String BIZ_TYPE_OTHERREFUND = "03";
	
	/**核销类型:退款成功核销*/
	public static final String WRITEOFF_TYPE_SUCCESS = "1";
	/**核销类型:退款撤销核销*/
	public static final String WRITEOFF_TYPE_FAIL = "2";
	/** 销账标志_0:未销账,1;已销账,2:销账失败 */
	public static final String FINISH_FLAG_TRUE = "1";
	
	
	/**已入账退款确认主KEY*/
	public static final String ENTRY_KEY_ACCOUNTREFUND_CONFIRM = "1802200";
	/**未入账退款确认主KEY*/
	public static final String ENTRY_KEY_ROUTEREFUND_CONFIRM = "1801200";
	/**重复交易退款主KEY*/
	public static final String ENTRY_KEY_AUTOREFUND_CONFIRM = "6101200";
	
	/**已入账退款撤销主KEY*/
	public static final String ENTRY_KEY_ACCOUNTREFUND_CANCEL = "1802300";
	/**未入账退款撤销主KEY*/
	public static final String ENTRY_KEY_ROUTEREFUND_CANCEL = "1801300";//1801300
	
}
