package com.somnus.smart.service.common.enums;

/**
 * 账户类型
 */
public enum AccountType {

    BIZ("1", "企业账户"), IDV("2", "个人账户"), INT("0", "内部");

    private final String code;

    private final String description;

    /**
     * 私有构造函数。
     * 
     * @param code
     * @param description
     */
    private AccountType(String code, String description) {
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
    public static AccountType getByCode(String code) {
        for (AccountType accountType : values()) {
            if (accountType.getCode().equals(code)) {

                return accountType;
            }
        }
        return null;
    }
}
