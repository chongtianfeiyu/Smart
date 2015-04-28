package com.somnus.smart.service.common;


public class AccountConstants extends BasConstants {
	/**
	 * IPS下发处理状态 0: 未出款 1：已出款
	 */
	public static final String ISSUED_STATUS_NOT = "0";
	public static final String ISSUED_STATUS_OUT = "1";
	public static final String ISSUED_STATUS_CONFIRM = "2";
	/**
	 * 标准转账前缀
	 */
	public static final String ENTRY_KEY_STD_TRANS_PRE = "13010";
	/**
     * 标准到专用转账前缀
     */
    public static final String ENTRY_KEY_STD_2_SPE_TRANS_PRE = "13011";
    /**
     * 专用到标准转账前缀
     */
    public static final String ENTRY_KEY_SPE_2_STD_TRANS_PRE = "13012";
	/**
     * 专用到专用转账前缀
     */
    public static final String ENTRY_KEY_SPE_2_SPE_TRANS_PRE = "13013";
    /**
     * 个人标准账户充值前缀
     */
    public static final String ENTRY_KEY_STD_CHARGE_PRE = "110301";
    /**
     * 个人专用账户充值前缀
     */
    public static final String ENTRY_KEY_SPE_CHARGE_PRE = "110302";
    
	/**
	 * 下发前缀 
	 */
	public static final String ENTRY_KEY_ISSUEDIPS_TOTAL_PRE = "13020";
	public static final String ENTRY_KEY_ISSUEDIPS_DETAIL_PRE = "13021";
}
