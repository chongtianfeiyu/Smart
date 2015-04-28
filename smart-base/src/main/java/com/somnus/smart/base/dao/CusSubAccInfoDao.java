package com.somnus.smart.base.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface CusSubAccInfoDao {

    /**
     * 查询可用余额
     * 
     * @param subaccion
     * @return
     */
    CusSubaccinfo selectFloatingCusBal(@Param("tableName") String tableName, @Param("merAccCode") String merAccCode, @Param("accType") String accType);

    /**
     * @Title:selectRelSubCode
     * @Description:根据商户号查询商户信息
     * @param relSubCode
     * @return SubAccInfoMap
     */
    CusSubaccinfo selectBycode(@Param("tableName") String tableName, @Param("relSubCode") String relSubCode, @Param("merAccCode") String merAccCode,
                               @Param("ccyCode") String ccyCode);

    /**
     * @Title:selectRelSubCode
     * @Description:锁定功能账户记录，锁余额
     * @param subAccCode
     *            功能账户号
     * @return
     */
    CusSubaccinfo selectBySubAcctForUpdate(@Param("tableName") String tableName, @Param("subAccCode") String subAccCode);

    /**
     * @Title:selectRelSubCode
     * @Description:查询功能账户记录
     * @param subAccCode
     *            功能账户号
     * @return
     */
    CusSubaccinfo selectByRelSubCode(@Param("tableName") String tableName, @Param("relSubCode") String relSubCode);

    /**
     * @Title:updateCurBal
     * @Description:更新账户余额
     * @param cusSubAccInfo
     *            余额信息
     * @return int 更新结果
     */
    int updateAcctBal(Map<String, Object> map);

    /**
     * 新增功能账户
     * 
     * @param subaccinfo
     */
    void insert(Map<String, Object> map);

    /**
     * 查询Sequences
     * 
     * @return
     */
    String getCussubaccSequences();

    int addBizFreezeBal(@Param("tableName") String tableName, @Param("subAccCode") String subAccCode, @Param("bizFreezeBal") BigDecimal bizFreezeBal);

    /**
     * 商户账户余额查询
     * 
     * @param request
     * @return
     */
    List<CusSubaccinfo> selectCusSubOrders(@Param("tableName") String tableName, @Param("merAccCode") String merAccCode,
                                           @Param("ccyCode") String ccyCode, @Param("accType") String accType);

    /**
     * 监管冻结
     * 
     * @param subAccCode
     * @param bizFreezeBal
     */
    int addMagFreezeBal(@Param("tableName") String tableName, @Param("subAccCode") String subAccCode, @Param("magFreezeBal") BigDecimal bizFreezeBal);

    /**
     * 应付冻结
     * 
     * @param subAccCode
     * @param payableFreezeBal
     */
    int addPayableFreezeBal(@Param("tableName") String tableName, @Param("subAccCode") String subAccCode,
                            @Param("payableFreezeBal") BigDecimal payableFreezeBal);
}