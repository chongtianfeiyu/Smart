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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.somnus.smart.base.dao.MerAccountDao;
import com.somnus.smart.base.domain.MerAccount;
import com.somnus.smart.service.common.CacheConstants;

/**
 * InfAccTypeCache
 *
 * @author IH745
 * @version 1.0 13-10-9
 */
@Component
public class MerAccountCache {

    @Autowired
    private MerAccountDao merAccountDao;

    @Cacheable(value = CacheConstants.CACHE_MERACCOUNT, key = "#p0.merCode+'|'+#p0.acctCode")
    public MerAccount selectByConstraints(MerAccount meraccount){
        return merAccountDao.selectByConstraints(meraccount);
    }
    @Cacheable(value = CacheConstants.CACHE_MERACCOUNT, key = "#p0")
	public List<MerAccount> selectByAcctcode(String merAccCode) {
		return merAccountDao.selectByAcctcode(merAccCode);
	}

}
