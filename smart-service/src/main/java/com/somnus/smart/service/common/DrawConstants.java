package com.somnus.smart.service.common;


public class DrawConstants extends BasConstants {
	
	/**业务类型-拒付*/
	public static final String DRAW_BIZ_TYPE_REFUSE = "05";
	
	/**退款流水状态-受理中*/
	public static final String REFUSE_STATUS0 = "0";
	/**退款流水状态-已拒付*/
	public static final String REFUSE_STATUS1 = "1";
	/**
	 * 出款处理状态 0: 未出款 1：已出款
	 */
	/** 出款处理状态 0: 未出款  */
	public static final String DRAW_STATUS_NOT = "0";
	/** 出款处理状态  1：已出款 */
	public static final String DRAW_STATUS_OUT = "1";
	/** 出款处理状态  2：出款审核中 */
	public static final String DRAW_STATUS_CONFIRM = "2";
	/** 划款类型 0:全部 */
	public static final String TRANSFER_TYPE_ALL = "0";
	/** 划款类型  1：指定商户*/
	public static final String TRANSFER_TYPE_SPECIFIC = "1";
	/** 划款类型  2:指定商户重做*/
	public static final String TRANSFER_TYPE_SPECIFIC_REDO = "2";
	/**
	 * 2001 即时下发到银行卡B2B 2002 即时下发到银行卡B2C 2003 快速下发到银行卡B2B 2004 快速下发到银行卡B2C 2005
	 * 提现B2B、提现B2C 2007 协议出款
	 * 
	 *1701	个人即时委托付款
	 *1702	企业即时委托付款
	 *1703	个人快速委托付款
	 *1704	企业快速委托付款
	 *1705	个人普通委托付款
	 *1706	企业普通委托付款
	 *1902	普通提现
	 *1901	快速提现
	 *1801	协议结算
	 *6701	个人委托账户付款
	 *6702	企业委托账户付款
	 *6801	个人转账
	 *6802	企业转账
	 *6901	充值
	 */
	/** 1701	个人即时委托付款 */
	public static final String ISSUED_IMMEDIATE_B2C="1701";
	/** 1702	企业即时委托付款 */
	public static final String ISSUED_IMMEDIATE_B2B="1702";
	/** 1703	个人快速委托付款 */
	public static final String ISSUED_RAPID_B2C="1703";
	/** 1704	企业快速委托付款 */
	public static final String ISSUED_RAPID_B2B="1704";
	/** 1705	个人普通委托付款 */
	public static final String ISSUED_COMMON_B2C="1705";
	/** 1706	企业普通委托付款 */
	public static final String ISSUED_COMMON_B2B="1706";
	/** 1902	普通提现 */
	public static final String ISSUED_WITHDRAW_B2B="1902";
	/** 1901	快速提现 */
	public static final String ISSUED_WITHDRAW_B2C="1901";
	/** 1801	协议结算 */
	public static final String ISSUED_PROTOCOL_DRAW="1801";
	
	
	
	/**
	 * 2001 即时下发到银行卡B2B 2002 即时下发到银行卡B2C 2003 快速下发到银行卡B2B 2004 快速下发到银行卡B2C 2005
	 * 提现B2B、提现B2C 2007 协议出款
	 * 
	 *6101	个人即时委托付款
	 *6102	企业即时委托付款
	 *6201	个人快速委托付款
	 *6202	企业快速委托付款
	 *6301	个人普通委托付款
	 *6302	企业普通委托付款
	 *6401	普通提现
	 *6501	快速提现
	 *6601	协议结算
	 *6701	个人委托账户付款
	 *6702	企业委托账户付款
	 *6801	个人转账
	 *6802	企业转账
	 *6901	充值
	 
	public static final String ISSUED_IMMEDIATE_B2B="6102";
	public static final String ISSUED_IMMEDIATE_B2C="6101";
	public static final String ISSUED_RAPID_B2B="6202";
	public static final String ISSUED_RAPID_B2C="6201";
	public static final String ISSUED_COMMON_B2B="6302";
	public static final String ISSUED_COMMON_B2C="6301";
	public static final String ISSUED_WITHDRAW_B2B="6401";
	public static final String ISSUED_WITHDRAW_B2C="6501";
	public static final String ISSUED_PROTOCOL_DRAW="6601";*/
	/**
	 * 协议出款类型
	 */
	public static final String TRANTYPE_PROTOCOL_DRAW="1011";
	/**
	 * 入账模式 ： 1 即时下发  2商户委托  3公司审核 4出款
	 */
	/** 1 即时下发  */
	public static final String DRAW_BLN_MODE_IMMEDIATE = "1";
	/** 2快速下发  */
	public static final String DRAW_BLN_MODE_RAPID = "2";
	/** 入账模式 ：   1商户委托  */
	public static final String DRAW_STEP_ENTRUST = "1";
	/** 入账模式 ：   2公司审核  */
	public static final String DRAW_STEP_CONFIRM = "2";
	/** 入账模式 ：    3出款 */
	public static final String DRAW_STEP_OUT = "3";
	/**
	 * 快速下发公司审核
	 */
	public static final String ENTRY_KEY_CONFIRM = "12012200";
	/**
	 * 下发到银行卡前缀
	 */
	public static final String ENTRY_KEY_ISSUEDBANK_PRE = "1201";
	/**
	 * 提现前缀
	 */
	public static final String ENTRY_KEY_DRAW_PRE = "12020";
	
	/**
     * 个人专用账户提现前缀
     */
    public static final String ENTRY_KEY_SPECIAL_DRAW_PRE = "12021";
	/**
	 * 协议出款结算
	 */
	public static final String ENTRY_KEY_PROTOCOLDRAW_BLN_PRE = "1123000";
	/**
	 * 划扣出款确认
	 */
	public static final String ENTRY_KEY_BUCKLEDRAW = "6101800";
	
	/** 划款状态 0:划款处理中 */
	public static final String TRANSFER_STATUS_DEALING = "0";
	/** 划款状态  1：划款成功*/
	public static final String TRANSFER_STATUS_SUCCESS = "1";
	/** 划款状态  2：划款失败*/
	public static final String TRANSFER_STATUS_FAIL = "2";
	
	/** 核销类型: 1：出款成功核销 */
	public static final String WRITEOFF_TYPE_SUCCESS = "1";
	/** 核销类型: 2: 出款撤销核销*/
	public static final String WRITEOFF_TYPE_FAIL = "2";
	
	/**出款确认主KEY*/
	public static final String ENTRY_KEY_DRAW_CONFIRM = "11210300";
	/**出款撤销主KEY*/
	public static final String ENTRY_KEY_DRAW_CANCEL = "1208000";
	
	public static final String ENTRY_KEY_REFUSEPAY_ACCOUNT = "19012100";
	public static final String ENTRY_KEY_REFUSEPAY_ROUTE_PRE = "190111";
	public static final String ENTRY_KEY_REFUSEPAY_CONFIRM_ROUTE = "19011200";
	public static final String ENTRY_KEY_REFUSEPAY_CONFIRM_ACCOUNT = "19012200";
	public static final String ENTRY_KEY_REFUSEPAY_NODRAW = "19010000";
	/** 销账标志_0:未销账 1：已销账 2:销账失败 */
	public static final String FINISH_FLAG_TRUE = "1";
	
}
