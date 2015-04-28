package com.somnus.smart.base.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.smart.base.domain.DiffTraninfo;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

/**
 * 账务核对差错DAO
 * @author dell
 *
 */
@MyBatisRepository
public interface DiffTraninfoDao {
	
	/**
	 * 查询记账流水号记录条数
	 * @param errTranNo
	 * @return
	 */
	int selectErrTranNoExist(String errTranNo);
	
	/**
	 * 新增差错记录
	 * @param difftran
	 */
	void insert(DiffTraninfo difftran);
	
	/**
	 * 查询主键
	 * @return
	 */
	String getDiffTranSequences();
	/**
	 * 查询差异信息
	 * @param diffTraninfo
	 * @param pageBounds
	 * @return
	 */
	PageList<DiffTraninfo> selectByDiffTraninfo(DiffTraninfo diffTraninfo, PageBounds pageBounds);
	/**
	 * 处理差异信息
	 * @param diffTraninfo
	 * @return
	 */
	int update(DiffTraninfo diffTraninfo);
	/**
	 * count总笔数
	 * @param diffTraninfo
	 * @return
	 */
	int selectUndoCnt(DiffTraninfo diffTraninfo);
	/**
	 * 根据主键查询
	 * 
	 * @param errNo
	 * @return
	 */
	DiffTraninfo selectByPrimaryKey(String errNo);

}
