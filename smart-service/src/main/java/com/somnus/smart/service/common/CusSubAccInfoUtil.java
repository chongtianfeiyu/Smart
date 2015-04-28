package com.somnus.smart.service.common;

import com.somnus.smart.service.common.enums.AccountType;

/**
 * 余额工具类
 * 
 * @author 李太平
 * @version $Id: CusSubAccInfoUtil.java, v 0.1 2015-2-9 下午02:24:03 李太平 Exp $
 */
public class CusSubAccInfoUtil {

    /** 商户余额表 */
    public final static String  BIZ_CUS_SUB_INFO_TBL       = "TCOR_CUS_SUBACCINFO";

    /** 内部账户余额表 */
    public final static String  INT_CUS_SUB_INFO_TBL       = "TCOR_CUS_SUBACCINFO_INT";

    /** 个人账户余额表 */
    public final static String IDV_CUS_SUB_INFO_TBL       = "TCOR_CUS_SUBACCINFO_IDV";

    private final static String BIZ_SUB_ACC_CODE__PREFIX   = "1";

    private final static String INT_SUB_ACC_CODE__PREFIX   = "2";

    private final static String IDV_SUB_ACC_CODE__PREFIX   = "3";

    private final static int    MERCHANT_ACC_CODE_LENGTH   = 10;

    private final static int    INDIVIDUAL_ACC_CODE_LENGTH = 12;

    /**
     * 获取表名
     * 
     * @param str
     * @return
     */
    public static String getTableBySubAccCode(String subAccCode) {
        String tableName = BIZ_CUS_SUB_INFO_TBL;
        if (subAccCode.startsWith(BIZ_SUB_ACC_CODE__PREFIX)) {
            return BIZ_CUS_SUB_INFO_TBL;
        } else if (subAccCode.startsWith(INT_SUB_ACC_CODE__PREFIX)) {
            return INT_CUS_SUB_INFO_TBL;
        } else if (subAccCode.startsWith(IDV_SUB_ACC_CODE__PREFIX)) {
            return IDV_CUS_SUB_INFO_TBL;
        }
        return tableName;
    }

    /**
     * 获取表名
     * 
     * @param str
     * @return
     */
    public static String getTableBySubType(String subType) {
        String tableName = BIZ_CUS_SUB_INFO_TBL;
        if (subType.equals(AccountType.BIZ.getCode())) {
            return BIZ_CUS_SUB_INFO_TBL;
        } else if (subType.equals(AccountType.INT.getCode())) {
            return INT_CUS_SUB_INFO_TBL;
        } else if (subType.equals(AccountType.IDV.getCode())) {
            return IDV_CUS_SUB_INFO_TBL;
        }
        return tableName;
    }

    /**
     * 获取表名
     * 
     * @param str
     * @return
     */
    public static String getTableByAccCodeLength(int accCodeLength) {
        if (accCodeLength == MERCHANT_ACC_CODE_LENGTH) {
            return BIZ_CUS_SUB_INFO_TBL;
        } else if (accCodeLength == INDIVIDUAL_ACC_CODE_LENGTH) {
            return IDV_CUS_SUB_INFO_TBL;
        } else {
            return INT_CUS_SUB_INFO_TBL;
        }
    }
    
    /**
     * 获取表名
     * 
     * @param str
     * @return
     */
    public static String getTableByAccountType(AccountType accountType) {
        if (accountType.equals(AccountType.BIZ)) {
            return BIZ_CUS_SUB_INFO_TBL;
        } else if (accountType.equals(AccountType.IDV)) {
            return IDV_CUS_SUB_INFO_TBL;
        } else {
            return INT_CUS_SUB_INFO_TBL;
        }
    }
}
