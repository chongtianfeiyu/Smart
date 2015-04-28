package com.somnus.smart.base.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import com.somnus.smart.base.domain.TrnAccDetail;
import com.somnus.smart.message.accquery.QueryAccDetailRequest;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface TrnAccDetailDao {

	
	/**
	 * 验证是否已经记账
	 * @param accDetail
	 * @return
	 */
	List<TrnAccDetail> getBizAccDetailToDo(TrnAccDetail accDetail);	
	   /**
     * 验证是否已经记账
     * @param accDetail
     * @return
     */
    List<TrnAccDetail> getIntAccDetailToDo(TrnAccDetail accDetail); 
    /**
     * 验证是否已经记账
     * @param accDetail
     * @return
     */
    List<TrnAccDetail> getIdvAccDetailToDo(TrnAccDetail accDetail); 
	

	/**
	 * @Title:insert
	 * @Description:插入商户账户明细
	 * @param trnAccDetail
	 * @return int 成功条数
	 */
	int insertBizAccDetail(TrnAccDetail trnAccDetail);
	
	   /**
     * @Title:insert
     * @Description:插入个人账户明细
     * @param trnAccDetail
     * @return int 成功条数
     */
    int insertIdvAccDetail(TrnAccDetail trnAccDetail);
    
    /**
     * @Title:insert
     * @Description:插入内部账户明细
     * @param trnAccDetail
     * @return int 成功条数
     */
    int insertIntAccDetail(TrnAccDetail trnAccDetail);
	
	/**
	 * 商户账户收支明细查询
	 * @param pageBounds
	 * @param request
	 * @return
	 */
	PageList<TrnAccDetail> selectBizAccDetailOrders(PageBounds pageBounds, QueryAccDetailRequest request);
	
	/**
     * 个人账户收支明细查询
     * @param pageBounds
     * @param request
     * @return
     */
    PageList<TrnAccDetail> selectIdvAccDetailOrders(PageBounds pageBounds, QueryAccDetailRequest request);
	
	/**
	 * 查询商户账户总收入总支出
	 * @param request
	 * @return
	 */
	TrnAccDetail selectBizAccDetailTotals(QueryAccDetailRequest request);
	
	   /**
     * 查询个人账户总收入总支出
     * @param request
     * @return
     */
    TrnAccDetail selectIdvAccDetailTotals(QueryAccDetailRequest request);
	
	

}