package com.somnus.smart.domain.account;

/**
 * 记账回调
 * 
 * @author 李太平
 * @version $Id: AccountCallBack.java, v 0.1 2014-11-18 下午01:38:08 李太平  Exp $
 */
public interface AccountCallBack {
    /**
     * 记账回调
     */
    Object callBack() throws Exception;
}
