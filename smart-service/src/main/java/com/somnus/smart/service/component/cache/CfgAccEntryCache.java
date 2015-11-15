package com.somnus.smart.service.component.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.somnus.smart.base.dao.CfgAccEntryDao;
import com.somnus.smart.base.domain.CfgAccEntry;
import com.somnus.smart.service.common.CacheConstants;

@Component
public class CfgAccEntryCache {

    @Autowired
    private CfgAccEntryDao cfgAccEntryDao;

    @Cacheable(value = CacheConstants.CACHE_CFGACCENTRY, key = "#p0")
    public CfgAccEntry selectByKey(String key){
        return cfgAccEntryDao.selectByKey(key);
    }

}
