package com.somnus.smart.domain.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.somnus.smart.base.dao.TcorTrnTranFeeDao;
import com.somnus.smart.base.domain.TcorTrnTranFee;
import com.somnus.smart.domain.DomainHelper;
import com.somnus.smart.domain.DomainModel;

/**
 * 收费附属
 * 
 * @author Administrator
 * @version $Id: Ledgerdetail.java, v 0.1 2014-10-29 下午04:44:14 Administrator Exp $
 */
public class TranFee extends TcorTrnTranFee implements DomainModel<TranFee, TcorTrnTranFee> {


    private static TcorTrnTranFeeDao     dao;

    private static Logger             LOGGER = LoggerFactory.getLogger(TranFee.class);

    public TranFee() {
    }

    public static TranFee getInstance() {
        return (TranFee) DomainHelper.getDomainInstance(TranFee.class);
    }

    public static void init(ApplicationContext ctx) {
        dao = ctx.getBean(TcorTrnTranFeeDao.class);
    }

    /**
     * 根据TrnAccDetail返回AccDetail
     * 
     * @param model
     * @return
     */
    private static TranFee getTran(TcorTrnTranFeeDao model) {
        TranFee tranFee = getInstance();
        if (model != null) {
            DomainHelper.setDomainData(tranFee, model);
        }
        return tranFee;
    }

    /**
     * 落地
     * 
     * @return
     */
    public boolean save() {
        dao.insert(this);
        return true;
    }

}
