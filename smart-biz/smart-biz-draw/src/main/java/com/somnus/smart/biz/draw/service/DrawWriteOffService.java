package com.somnus.smart.biz.draw.service;

import com.somnus.smart.domain.account.DrawTransaction;
import com.somnus.smart.domain.account.Transaction;

/**
 * 核销接口
 * @author IH745
 *
 */
public interface DrawWriteOffService {
	
	/**
	 * 创建记账交易流水
	 * 
	 * @param request
	 * @return
	 */
    public Transaction createTransaction( DrawTransaction drawTransaction);
    /**
     * 出款核销成功记账
     */
    public void drawWriteOffSynAccount(Transaction transaction,DrawTransaction drawTransaction,String entryKey,boolean checkRed)throws Exception;
	

}
