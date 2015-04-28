package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.TrnTranrefuse;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 退款流水附属表DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface TrnTranrefuseDao {

	/**
	 * 新增记录
	 * @param record
	 * @return
	 */
    int insert(TrnTranrefuse record);

    /**
     * 根据主键查询记录
     * @param refTranNo
     * @return
     */
    TrnTranrefuse selectByPrimaryKey(String refTranNo);

    /**
     * 根据主键更新记录
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(TrnTranrefuse record);

}