package com.somnus.smart.domain.account;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.somnus.smart.base.dao.TrnTranIssuedDao;
import com.somnus.smart.base.domain.TrnTranIssued;
import com.somnus.smart.domain.DomainHelper;
import com.somnus.smart.domain.DomainModel;

/**
 * 下发审核附属
 * 
 * @author Administrator
 * @version $Id: Ledgerdetail.java, v 0.1 2014-10-29 下午04:44:14 Administrator Exp $
 */
public class TranIssued extends TrnTranIssued implements DomainModel<TranIssued, TrnTranIssued> {


    private static TrnTranIssuedDao   dao;

    private static Logger             LOGGER = LoggerFactory.getLogger(TranIssued.class);

    public TranIssued() {
    }

    public static TranIssued getInstance() {
        return (TranIssued) DomainHelper.getDomainInstance(TranIssued.class);
    }

    public static void init(ApplicationContext ctx) {
        dao = ctx.getBean(TrnTranIssuedDao.class);
    }

    /**
     * 根据TrnAccDetail返回AccDetail
     * 
     * @param model
     * @return
     */
    private static TranIssued getTranIssued(TrnTranIssued model) {
        TranIssued tranIssued = getInstance();
        if (model != null) {
            DomainHelper.setDomainData(tranIssued, model);
        }
        return tranIssued;
    }

    /**
     * 落地
     * 
     * @return
     */
    public boolean save() {
        if (this.getIssTranNo()==null) {
            dao.insert(this);
        } else {
            dao.insertNoSeq(this);
        }
        return true;
    }

    public boolean update() {
        int count = dao.updateByPrimaryKey(this);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static TranIssued selectByPrimaryKey(String issTranNo) {
        TrnTranIssued trnTranIssued = dao.selectByPrimaryKey(issTranNo);
        if (trnTranIssued != null) {
            return getTranIssued(trnTranIssued);
        } else {
            return null;
        }
    }

    public boolean updateByPrimaryKeyStatus() {
        int count = dao.updateByPrimaryKeyStatus(this);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static List<TranIssued> selectByAccTranNoStatus(TranIssued tranIssued) {
        List<TrnTranIssued> issuedList = dao.selectByAccTranNoStatus(tranIssued);
        if (issuedList == null || issuedList.size() < 0) {
            return null;
        }
        List<TranIssued> tranIssueds = new ArrayList<TranIssued>();
        for (TrnTranIssued trnTranIssued : issuedList) {
            tranIssueds.add(getTranIssued(trnTranIssued));
        }
        return tranIssueds;
    }
    
    public static String getIssuedTranNo(){
        return  dao.getIssTranNo();
    }
}
