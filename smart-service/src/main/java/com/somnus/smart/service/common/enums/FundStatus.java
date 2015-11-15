package com.somnus.smart.service.common.enums;

/**
 * 个人账户出入款状态
 */
public enum FundStatus {

    CAN_IN_OUT("0", "正常"), 
    CAN_IN("1", "只进不出"), 
    CAN_OUT("2", "只出不进"),
    NOT_CAN_IN_OUT("3","不进不出");

    private final String code;

    private final String description;

    /**
     * 私有构造函数。
     * 
     * @param code
     * @param description
     */
    private FundStatus(String code, String description) {
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
    public static FundStatus getByCode(String code) {
        for (FundStatus accountType : values()) {
            if (accountType.getCode().equals(code)) {

                return accountType;
            }
        }
        return null;
    }
}
