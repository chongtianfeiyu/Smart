package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.PrdRecognizeDelay;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 
 * @author IH745
 *
 */
@MyBatisRepository
public interface PrdRecognizeDelayDao {
	
	/**
	 * 
	 * @param prdRecognizeDelay
	 * @return
	 */
	PrdRecognizeDelay selectConstraints(PrdRecognizeDelay prdRecognizeDelay);

	void merge(PrdRecognizeDelay prdRecognizeDelay);
	
	/**
	 * 根据唯一性约束删除数据
	 * @param prdRecognizeDelay
	 */
	void deleteByContains(PrdRecognizeDelay prdRecognizeDelay);

}
