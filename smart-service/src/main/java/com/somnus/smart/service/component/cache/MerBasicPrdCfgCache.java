package com.somnus.smart.service.component.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.somnus.smart.base.dao.MerBasicPrdCfgDao;
import com.somnus.smart.base.domain.MerBasicPrdCfg;
import com.somnus.smart.service.common.CacheConstants;

/**
 * InfAccTypeCache
 * 
 * @author IH745
 * @version 1.0 13-10-9
 */
@Component
public class MerBasicPrdCfgCache {

	@Autowired
	private MerBasicPrdCfgDao merBasicPrdCfgDao;

	@Cacheable(value = CacheConstants.CACHE_MERBASICPRDCFG, key = "#p0.acctCode+'|'+#p0.systemCode+'|'+#p0.basicPrdCode")
	public MerBasicPrdCfg getMerBasicPrdCfg(MerBasicPrdCfg basicprdcfg) {
		return merBasicPrdCfgDao.selectConstraints(basicprdcfg);
	}

}
