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

import com.somnus.smart.base.dao.CfgAccEntryDao;
import com.somnus.smart.base.domain.CfgAccEntry;
import com.somnus.smart.service.common.CacheConstants;

/**
 * CfgAccEntryCache
 *
 * @author IH745
 * @version 1.0 13-10-9
 */
@Component
public class CfgAccEntryCache {

    @Autowired
    private CfgAccEntryDao cfgAccEntryDao;

    @Cacheable(value = CacheConstants.CACHE_CFGACCENTRY, key = "#p0")
    public CfgAccEntry selectByKey(String key){
        return cfgAccEntryDao.selectByKey(key);
    }

}
