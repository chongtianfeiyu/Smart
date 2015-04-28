package com.somnus.smart.base.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.smart.base.domain.CfgSubdict;
import com.somnus.smart.message.master.SubManageQueryRequest;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 科目配置表DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface CfgSubdictDao {

	/**
	 * 新增对象
	 * @param record
	 * @return
	 */
    int insert(CfgSubdict record);

    /**
     * 根据主键查询对象
     * @param subCode
     * @return
     */
    CfgSubdict selectByPrimaryKey(String subCode);

    /**
     * 根据主键更新对象
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CfgSubdict record);

    
	/**
	 * 查询科目配置是否存在
	 * @param subCode
	 * @return
	 */
	int selectExistByCfgSubdict(String subCode);
	
	/**
	 * 查询科目配置是否存在
	 * @param subCode
	 * @return
	 */
	CfgSubdict selectByCfgSubdictForUpdate(String subCode);
	
	
	/**
	 * 科目分页查询
	 * @param entity
	 * @param pageBounds
	 * @return
	 */
	 public PageList<CfgSubdict> selectByParams(SubManageQueryRequest request, PageBounds pageBounds);
}