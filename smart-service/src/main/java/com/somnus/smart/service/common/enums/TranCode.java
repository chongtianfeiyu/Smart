package com.somnus.smart.service.common.enums;

/**
 * 账户类型
 * 
 * @author 李太平
 * @version $Id: AccountType.java, v 0.1 2015-2-5 下午03:30:01 李太平 Exp $
 */
public enum TranCode {
    /** 老版本商户提现 */
    MERCHANT_WITHDRAW_OLD("1203", "商户提现"), 

    /** 商户提现 */
    MERCHANT_WITHDRAW("120301", "商户提现"), 
    
    /** 个人标准提现/标准账户转账到银行卡 */
    INDIVIDUAL_WITHDRAW("120302", "个人标准提现"),
    
    /** 个人专用提现/专用账户转账到银行卡 */
    INDIVIDUAL_SPECIAL_WITHDRAW("120303","个人专用提现"),
    
    /** 标准账户转账 */
    ACC_TRANS_STD_2_STD_OLD("1301","标准转账"),
    
    /** 标准账户转账 */
    ACC_TRANS_STD_2_STD("130101","标准转账"),
    
    /** 标准转账到专用账户 */
    ACC_TRANS_STD_2_SPE("130102","标准到专用"),
    
    /** 专用账户转账到标准账户 */
    ACC_TRANS_SPE_2_STD("130103","专用到标准"),
    
    /** 专用账户转账到专用账户 */
    ACC_TRANS_SPE_2_SPE("130104","专用到专用"),
    
    /** 个人标准账户充值 */
    INDIVIDUAL_CHARGE("110301","个人标准账户充值"),
    
    /** 个人专用账户充值 */
    INDIVIDUAL_SPECIAL_CHARGE("110302","个人专用账户充值");

    private final String code;

    private final String description;

    /**
     * 私有构造函数。
     * 
     * @param code
     * @param description
     */
    private TranCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     * 
     * @param code
     * @return
     */
    public static TranCode getByCode(String code) {
        for (TranCode accountType : values()) {
            if (accountType.getCode().equals(code)) {

                return accountType;
            }
        }
        return null;
    }

}
