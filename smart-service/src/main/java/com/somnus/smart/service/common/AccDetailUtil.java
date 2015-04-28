package com.somnus.smart.service.common;

/**
 * 收支明细工具类
 * 
 * @author 李太平
 * @version $Id: AccDetailUtil.java, v 0.1 2015-2-9 下午02:23:44 李太平  Exp $
 */
public class AccDetailUtil {
    /** 商户收支明细表 */
    public final static String BIZ_ACC_DETAIL_TBL="TCOR_TRN_ACC_DETAIL";
    /** 内部收支明细表 */
    public final static String INT_ACC_DETAIL_TBL="TCOR_TRN_ACC_DETAIL_INT";
    /** 个人收支明细表 */
    private final static String IDV_ACC_DETAIL_TBL="TCOR_TRN_ACC_DETAIL_IDV";
    
    private final static String BIZ_SUB_ACC_CODE__PREFIX="1";
    
    private final static String INT_SUB_ACC_CODE__PREFIX="2";
    
    private final static String IDV_SUB_ACC_CODE__PREFIX="3";
    /**
     * 获取表名
     * 
     * @param str
     * @return
     */
    public static String getTableBySubAccCode(String subAccCode){
        String tableName=BIZ_ACC_DETAIL_TBL;
        if(subAccCode.startsWith(BIZ_SUB_ACC_CODE__PREFIX)){
            return BIZ_ACC_DETAIL_TBL;
        }else if(subAccCode.startsWith(INT_SUB_ACC_CODE__PREFIX)){
            return INT_ACC_DETAIL_TBL;
        }
        else if(subAccCode.startsWith(IDV_SUB_ACC_CODE__PREFIX)){
            return IDV_ACC_DETAIL_TBL;
        }
        return tableName;
    }
}
