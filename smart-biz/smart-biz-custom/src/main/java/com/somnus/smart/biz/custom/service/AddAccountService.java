package com.somnus.smart.biz.custom.service;


/**
 * 补记账服务
 * 
 * @author Administrator
 * @version $Id: AddAccountService.java, v 0.1 2014-8-27 下午01:48:46 Administrator Exp $
 */
public interface AddAccountService {
    /**
     * 补记账
     * 
     * @param errNo
     */
    void addAccount(String errNo) throws Exception;

}
