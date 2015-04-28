package com.somnus.smart.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.smart.base.dao.CfgSubdictDao;
import com.somnus.smart.base.dao.CusSubAccInfoDao;
import com.somnus.smart.base.dao.DaySystemDao;
import com.somnus.smart.base.dao.InfAcctypeDao;
import com.somnus.smart.base.domain.Accsubentity;
import com.somnus.smart.base.domain.CfgSubdict;
import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.base.domain.DaySystem;
import com.somnus.smart.service.MeracctInnerService;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.service.common.CusSubAccInfoUtil;
import com.somnus.smart.support.common.MsgCodeList;
import com.somnus.smart.support.exceptions.BizException;
import com.somnus.smart.support.util.DateUtil;

@Service
public class MeracctInnerServiceImpl implements MeracctInnerService {

    @Autowired
    private MessageSourceAccessor msa;

    @Autowired
    private CusSubAccInfoDao      cusSubaccinfoDao;

    @Autowired
    private DaySystemDao          daySystemDao;

    @Autowired
    private InfAcctypeDao         infAcctypeDao;

    @Autowired
    private CfgSubdictDao         cfgSubdictDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public CusSubaccinfo txnMerInnerCreate(String relSubCode, String ccyCode) throws Exception {

        if (StringUtils.isBlank(relSubCode)) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, new Object[] { "实际科目号" }));
        }

        //先锁科目，再查下账户是否存在，存在直接返回，不存在重新创建
        CfgSubdict cfgSubdict = cfgSubdictDao.selectByCfgSubdictForUpdate(relSubCode);
        if (cfgSubdict == null) {
            throw new BizException("科目未配置!");
        }
        //根据relSubCode查询是否存在账户
        CusSubaccinfo cusSubaccinfo = cusSubaccinfoDao.selectBycode(CusSubAccInfoUtil.INT_CUS_SUB_INFO_TBL, relSubCode, null, ccyCode);
        if (cusSubaccinfo != null) {
            return cusSubaccinfo;
        }
        //查询内部账户类型和科目
        Accsubentity innerAcc = infAcctypeDao.selectInnerAcc(relSubCode.substring(0, 2));
        if (innerAcc == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_305005));
        }
        //构建功能账户
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("subAccCode", Constants.SUB_ACC_HEAD_2.concat(ccyCode).concat(innerAcc.getSubCode()).concat(cusSubaccinfoDao.getCussubaccSequences()));
        map.put("subAccName", innerAcc.getAccTypeName());
        map.put("accDate", getSystemDate());
        map.put("subCode", innerAcc.getSubCode());
        map.put("relSubCode", relSubCode);
        map.put("balDir", innerAcc.getBalCtrlDir());
        map.put("ccyCode", ccyCode);
        map.put("curBal", new BigDecimal("0"));
        map.put("availBal", new BigDecimal("0"));
        map.put("bizFreezeBal", new BigDecimal("0"));
        map.put("magFreezeBal", new BigDecimal("0"));
        map.put("payableFreezeBal", new BigDecimal("0"));
        map.put("initialBal", new BigDecimal("0"));
        map.put("debitAmt", new BigDecimal("0"));
        map.put("creditAmt", new BigDecimal("0"));
        map.put("accType", innerAcc.getAccType());
        map.put("overFlag", innerAcc.getRedFlag());
        map.put("accStatus", Constants.ACC_STATUS_0);
        map.put("openDate", new Date());
        map.put("openBy", "ADMIN");
        map.put("createTime", DateUtil.getCurrentTimeStamp());
        map.put("createBy", "ADMIN");
        map.put("lastInitialBal", new BigDecimal("0"));
        map.put("tableName", CusSubAccInfoUtil.INT_CUS_SUB_INFO_TBL);
        cusSubaccinfoDao.insert(map);

        cusSubaccinfo = cusSubaccinfoDao.selectBycode(CusSubAccInfoUtil.INT_CUS_SUB_INFO_TBL, relSubCode, null, ccyCode);

        return cusSubaccinfo;
    }

  
    /**
     * 查询账务日期
     * 
     * @return
     */
    private Date getSystemDate() {
        Date systemDate = null;
        DaySystem daySystem = daySystemDao.getDaySystem(Constants.CORE_CUT_CODE);
        if (daySystem != null) {
            systemDate = DateTime.parse(daySystem.getCoreDate()).toDate();
        } else {
            systemDate = new Date();
        }
        return systemDate;
    }


}
