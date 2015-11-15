package com.somnus.smart.service.common.enums;

/**
 * 账户状态
 */
public enum AccStatus {

    NORMAL("0", "正常"), DESTORY("1", "销户"), FREEZE("2", "冻结");

    private final String code;

    private final String description;

    /**
     * 私有构造函数。
     * 
     * @param code
     * @param description
     */
    private AccStatus(String code, String description) {
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
    public static AccStatus getByCode(String code) {
        for (AccStatus accountType : values()) {
            if (accountType.getCode().equals(code)) {

                return accountType;
            }
        }
        return null;
    }
}
