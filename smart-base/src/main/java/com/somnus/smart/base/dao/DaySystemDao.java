package com.somnus.smart.base.dao;

import com.somnus.smart.base.domain.DaySystem;
import com.somnus.smart.support.mybatis.annotation.MyBatisRepository;

@MyBatisRepository
public interface DaySystemDao {
	
	/**
	 * @Description: 获取当前工作日
	 * @param sysId    系统编码
	 * @return void    当前工作日对象
	 * @throws
	 */
	DaySystem getWorkDay(String cutCode);
	
	/**
	 * 获取核心日期信息
	 * @return
	 */
	DaySystem getDaySystem(String cutCode);
	
	

}
