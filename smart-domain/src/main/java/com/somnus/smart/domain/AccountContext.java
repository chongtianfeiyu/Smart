package com.somnus.smart.domain;

import java.util.List;
import java.util.Map;

import com.somnus.smart.domain.account.SubAccInfo;

/**
 * 记账上下文
 * 
 * @author Administrator
 * @version $Id: AccountContext.java, v 0.1 2014-11-3 上午11:09:26 Administrator Exp $
 */
public class AccountContext {
    /** 是否多笔台账记账 */
    private boolean                              isBatchAccount = false;

    /** 交易账户锁 */
    private ThreadLocal<Map<String, SubAccInfo>> subAccInfoLocks;

    /** RelSubCode和SubCode映射 */
    private ThreadLocal<Map<String, String>>     relSubCodeSubCodeMap;

    /** RelSubCode锁顺序 */
    private ThreadLocal<List<String>>            relSubAccCodeList;

    public AccountContext() {
        subAccInfoLocks = new ThreadLocal<Map<String, SubAccInfo>>();
        relSubCodeSubCodeMap = new ThreadLocal<Map<String, String>>();
        relSubAccCodeList = new ThreadLocal<List<String>>();
    }

    public static AccountContext getInstance() {
        return (AccountContext) DomainHelper.getDomainInstance(AccountContext.class);
    }

    /**
     * 设置交易账户锁
     * 
     * @param map
     */
    public void putSubAccInfoLocks(Map<String, SubAccInfo> map) {
        subAccInfoLocks.set(map);
    }

    /**
     * 获取交易账户锁
     * 
     * @return
     */
    public Map<String, SubAccInfo> getSubAccInfoLocks() {
        return subAccInfoLocks.get();
    }

    /**
     * 设置RelSubCode和SubCode映射
     * 
     * @param map
     */
    public void putRelSubCodeSubCodeMap(Map<String, String> map) {
        relSubCodeSubCodeMap.set(map);
    }

    /**
     * 获取RelSubCode和SubCode映射
     * 
     * @return
     */
    public Map<String, String> getRelSubCodeSubCodeMap() {
        return relSubCodeSubCodeMap.get();
    }

    /**
     * 设置RelSubCode锁顺序
     * 
     * @param list
     */
    public void putRelSubAccCodeList(List<String> list) {
        relSubAccCodeList.set(list);
    }

    /**
     * 获取RelSubCode锁顺序
     * 
     * @return
     */
    public List<String> getRelSubAccCodeList() {
        return relSubAccCodeList.get();
    }
    /**
     * 线程变量Locks remove
     */
    public void removeLocks(){
    	subAccInfoLocks.remove();
    }

    /**
     * 线程变量remove
     */
    public void remove() {
        subAccInfoLocks.remove();
        relSubCodeSubCodeMap.remove();
        relSubAccCodeList.remove();
        isBatchAccount=false;
    }

    
    public boolean isBatchAccount() {
        return isBatchAccount;
    }

    
    public void setBatchAccount(boolean isBatchAccount) {
        this.isBatchAccount = isBatchAccount;
    }
    
}
