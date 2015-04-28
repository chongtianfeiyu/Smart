/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.smart.service.component.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.somnus.smart.base.dao.InfAcctypeDao;
import com.somnus.smart.base.domain.InfAcctype;
import com.somnus.smart.service.common.CacheConstants;

/**
 * InfAccTypeCache
 *
 * @author IH745
 * @version 1.0 13-10-9
 */
@Component
public class InfAccTypeCache {

    @Autowired
    private InfAcctypeDao infAcctypeDao;

    /**
     * 获取InfAcctype
     *
     * @param 账户类型
     * @return
     */
    @Cacheable(value = CacheConstants.CACHE_INFACCTYPE, key = "#p0")
    public InfAcctype getInfAcctype(String accType){
        return infAcctypeDao.selectByPrimaryKey(accType);
    }

}
