package com.somnus.smart.biz.accquery.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.smart.base.dao.CusSubAccInfoDao;
import com.somnus.smart.base.dao.TrnAccDetailDao;
import com.somnus.smart.base.dao.TrnTransactionDao;
import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.base.domain.TrnAccDetail;
import com.somnus.smart.base.domain.TrnTransaction;
import com.somnus.smart.biz.accquery.common.IssuedEntity;
import com.somnus.smart.biz.accquery.dao.IssuedAccDao;
import com.somnus.smart.biz.accquery.dao.PaymentAppDao;
import com.somnus.smart.biz.accquery.service.AccQueryService;
import com.somnus.smart.message.accquery.CussubQueryRequest;
import com.somnus.smart.message.accquery.CussubQueryResponse;
import com.somnus.smart.message.accquery.IssuedAccDetailOrder;
import com.somnus.smart.message.accquery.IssuedAccDetailQueryRequest;
import com.somnus.smart.message.accquery.IssuedAccDetailQueryResponse;
import com.somnus.smart.message.accquery.IssuedAccOrder;
import com.somnus.smart.message.accquery.IssuedAccQueryRequest;
import com.somnus.smart.message.accquery.IssuedAccQueryResponse;
import com.somnus.smart.message.accquery.QueryAccDetailOrder;
import com.somnus.smart.message.accquery.QueryAccDetailRequest;
import com.somnus.smart.message.accquery.QueryAccDetailResponse;
import com.somnus.smart.message.accquery.QueryCusFifOrder;
import com.somnus.smart.message.accquery.QueryCusFifRequest;
import com.somnus.smart.message.accquery.QueryCusFifResponse;
import com.somnus.smart.message.accquery.QueryCusSubAccRequest;
import com.somnus.smart.message.accquery.QueryCusSubOrder;
import com.somnus.smart.message.accquery.QueryCusSubResponse;
import com.somnus.smart.message.accquery.QueryPayAppOrder;
import com.somnus.smart.message.accquery.QueryPayAppRequest;
import com.somnus.smart.message.accquery.QueryPayAppResponse;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.service.common.CusSubAccInfoUtil;
import com.somnus.smart.support.common.MsgCodeList;
import com.somnus.smart.support.exceptions.BizException;

/**
 * 
 * @description: TODO 
 * @author Somnus
 * date 2015年3月6日 下午6:13:32
 */
@Service
public class AccQueryServiceImpl implements AccQueryService {

    @Autowired
    private MessageSourceAccessor msa;

    @Autowired
    private CusSubAccInfoDao      cusSubAccInfoDao;

    @Autowired
    private IssuedAccDao          issuedAccDao;

    @Autowired
    private TrnAccDetailDao       trnAccDetailDao;

    @Autowired
    private TrnTransactionDao     trnTransactionDao;

    @Autowired
    private PaymentAppDao         paymentAppDao;
    
    private static final int    MERCHANT_ACC_CODE_LENGTH   = 10;

    private static final int    INDIVIDUAL_ACC_CODE_LENGTH = 12;

    @Override
    public CussubQueryResponse queryCusCurBal(CussubQueryRequest request) {
        if (request == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "CussubQueryRequest" }));
        }
        CusSubaccinfo subaccinfo = cusSubAccInfoDao.selectFloatingCusBal(
        		CusSubAccInfoUtil.getTableByAccCodeLength(request.getMerAccCode().length()), 
        		request.getMerAccCode(), Constants.ACC_TYPE_82);
        if (subaccinfo == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002, 
            		new Object[] { request.getMerAccCode() }));
        }
        CussubQueryResponse response = new CussubQueryResponse();//返回查询结果
        response.setMerAccCode(subaccinfo.getMerAccCode());//商户账户号
        response.setCurBal(subaccinfo.getCurBal());//账户余额
        response.setAvailBal(subaccinfo.getAvailBal());//可用余额
        return response;
    }

    @Override
    public IssuedAccDetailQueryResponse queryIssuedAccDetail(IssuedAccDetailQueryRequest request) {
        if (request == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "IssuedAccDetailQueryRequest" }));
        }
        IssuedEntity entity = new IssuedEntity();
        entity.setAppBatchNo(request.getBatchNo());
        PageList<IssuedEntity> pagelist = issuedAccDao.selectIssuedAccDetail(entity, 
        		new PageBounds(request.getPageNum(), request.getPageSize()));
        if (pagelist == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002, 
            		new Object[] { request.getBatchNo() }));
        }
        int total = pagelist.getPaginator().getTotalCount();//总记录数
        IssuedAccDetailQueryResponse response = new IssuedAccDetailQueryResponse();
        response.setPageNum(request.getPageNum());
        response.setPageSize(request.getPageSize());
        response.setRowCount(total);
        List<IssuedAccDetailOrder> orders = new ArrayList<IssuedAccDetailOrder>();
        for (IssuedEntity issued : pagelist) {
            orders.add(createIssuedOrderDetail(issued));
        }
        response.setOrders(orders);
        return response;
    }

    @Override
    public IssuedAccQueryResponse queryIssuedAcc(IssuedAccQueryRequest request) {
        if (request == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "IssuedAccQueryRequest" }));
        }
        IssuedEntity entity = new IssuedEntity();
        entity.setPayerCode(request.getMerCode());//商户号
        entity.setPayerAccCode(request.getMerAccCode());//交易账户号
        PageList<IssuedEntity> pagelist = issuedAccDao.selectIssuedAcc(entity, 
        		new PageBounds(request.getPageNum(), request.getPageSize()));
        BigDecimal totalAmt = issuedAccDao.selectIssuedAccToalAmt(entity);//查询总批次金额
        if (pagelist == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002, 
            		new Object[] { request.getMerCode() }));
        }
        int total = pagelist.getPaginator().getTotalCount();//总记录数
        IssuedAccQueryResponse response = new IssuedAccQueryResponse();
        response.setPageNum(request.getPageNum());
        response.setPageSize(request.getPageSize());
        response.setRowCount(total);
        response.setTotalAmt(totalAmt);//总批次金额
        List<IssuedAccOrder> orders = new ArrayList<IssuedAccOrder>();
        for (IssuedEntity issued : pagelist) {
            orders.add(createIssuedOrder(issued));
        }
        response.setOrders(orders);
        return response;
    }

    /**
     * 构建下发审核明细查询返回参数
     * 
     * @param issued
     * @param merName
     * @return
     */
    private IssuedAccDetailOrder createIssuedOrderDetail(IssuedEntity issued) {
        IssuedAccDetailOrder order = new IssuedAccDetailOrder();
        order.setIssTranNo(issued.getIssTranNo());
        order.setMerCode(issued.getPayerCode());
        order.setMerName(issued.getMerName());
        order.setMerAccCode(issued.getPayerAccCode());
        order.setTranDate(issued.getAccDate());
        order.setBizType("01");
        order.setCcyCode(issued.getCcyCode());
        order.setTranAmount(issued.getTranAmt());
        order.setPayerBankCode(issued.getPayeeBankCode());
        order.setPayeeBankCode(issued.getPayeeBankCode());
        order.setPayeeBankAccCode(issued.getPayeeBankAccCode());
        order.setPayeeBankAccName(issued.getPayeeBankAccName());
        return order;
    }

    /**
     * 构建下发审核查询返回参数
     * 
     * @param issued
     * @param merName
     * @return
     */
    private IssuedAccOrder createIssuedOrder(IssuedEntity issued) {
        IssuedAccOrder order = new IssuedAccOrder();
        order.setBatchNo(issued.getAppBatchNo());
        order.setMerCode(issued.getPayerCode());
        order.setMerName(issued.getMerName());
        order.setMerAccCode(issued.getPayerAccCode());
        order.setTranDate(issued.getAccDate());
        order.setCcyCode(issued.getCcyCode());
        order.setBatchAmt(issued.getTranAmt());
        return order;
    }

    @Override
    public QueryCusSubResponse queryCusSubAccInfo(QueryCusSubAccRequest request) throws Exception {
        if (request == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "QueryCusSubAccRequest" }));
        } else if (StringUtils.isBlank(request.getMerAccCode())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "merAccCode" }));
        } else if (StringUtils.isBlank(request.getCcyCode())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "ccyCode" }));
        }
        List<CusSubaccinfo> results = cusSubAccInfoDao.selectCusSubOrders(
        		CusSubAccInfoUtil.getTableByAccCodeLength(request.getMerAccCode().length()),
        		request.getMerAccCode(), request.getCcyCode(), request.getAccType());
        List<QueryCusSubOrder> acounts = new ArrayList<QueryCusSubOrder>();//返回结果数据集
        if (CollectionUtils.isNotEmpty(results)) {
            for (CusSubaccinfo cussubacc : results) {
                QueryCusSubOrder order = new QueryCusSubOrder();
                PropertyUtils.copyProperties(order, cussubacc);
                acounts.add(order);
            }
        }
        QueryCusSubResponse response = new QueryCusSubResponse();//报文返回对象
        response.setMerAccCode(request.getMerAccCode());//交易账户号
        response.setAcounts(acounts);//返回结果集
        return response;
    }

    @Override
    public QueryAccDetailResponse queryAccDetail(QueryAccDetailRequest request) throws Exception {
        if (request == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "QueryAccDetailRequest" }));
        } else if (StringUtils.isBlank(request.getMerAccCode())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "merAccCode" }));
        } else if (StringUtils.isBlank(request.getCcyCode())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "ccyCode" }));
        } else if (StringUtils.isBlank(request.getAccType())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "accType" }));
        }
        PageList<TrnAccDetail> pagelist=null;
        if(request.getMerAccCode().length()==MERCHANT_ACC_CODE_LENGTH){
            pagelist = trnAccDetailDao
            .selectBizAccDetailOrders(new PageBounds(request.getPageNum(), request.getPageSize()), request);
        }else if(request.getMerAccCode().length()==INDIVIDUAL_ACC_CODE_LENGTH){
            pagelist = trnAccDetailDao
            .selectIdvAccDetailOrders(new PageBounds(request.getPageNum(), request.getPageSize()), request);
        }
        
        int total = 0;//总记录数
        List<QueryAccDetailOrder> accDetails = new ArrayList<QueryAccDetailOrder>();//返回结果数据集
        if (pagelist != null && !pagelist.isEmpty()) {
            total = pagelist.getPaginator().getTotalCount();
            for (TrnAccDetail detail : pagelist) {
                QueryAccDetailOrder order = new QueryAccDetailOrder();
                PropertyUtils.copyProperties(order, detail);
                order.setAccTime(detail.getCreateTime());
                order.setTranTypeName(detail.getTranType());//由于查询出来的tran_type 本身就是tran_type_name
                accDetails.add(order);
            }
        }
        TrnAccDetail accDetail=null;
        if(request.getMerAccCode().length()==MERCHANT_ACC_CODE_LENGTH){
            accDetail = trnAccDetailDao.selectBizAccDetailTotals(request);
        }else if(request.getMerAccCode().length()==INDIVIDUAL_ACC_CODE_LENGTH){
            accDetail = trnAccDetailDao.selectIdvAccDetailTotals(request);
        }
        
        QueryAccDetailResponse response = new QueryAccDetailResponse();
        response.setPageNum(request.getPageNum());
        response.setPageSize(request.getPageSize());
        response.setRowCount(total);
        response.setMerAccCode(request.getMerAccCode());
        response.setAccType(request.getAccType());
        response.setAccDetails(accDetails);
        if (accDetail != null) {
            response.setTotalIncome(accDetail.getTotalIncome());
            response.setTotalExpenditure(accDetail.getTotalExpenditure());
        }
        return response;
    }

    @Override
    public QueryCusFifResponse queryCusFif(QueryCusFifRequest request) throws Exception {
        if (request == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "QueryCusFifRequest" }));
        } else if (StringUtils.isBlank(request.getMerAccCode())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "merAccCode" }));
        } else if (StringUtils.isBlank(request.getCcyCode())) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "ccyCode" }));
        }
        PageList<TrnTransaction> pagelist = trnTransactionDao
            .selectCusFifOrders(new PageBounds(request.getPageNum(), request.getPageSize()), request);
        int total = 0;//总记录数
        List<QueryCusFifOrder> tranDetails = new ArrayList<QueryCusFifOrder>();//返回结果数据集
        if (pagelist != null && !pagelist.isEmpty()) {
            total = pagelist.getPaginator().getTotalCount();
            for (TrnTransaction tran : pagelist) {
                QueryCusFifOrder order = new QueryCusFifOrder();
                PropertyUtils.copyProperties(order, tran);
                order.setAccTime(tran.getSubmitTime());
                order.setTranTypeName(tran.getTranType());//由于查询出来的tran_type本身就是tran_type的值
                tranDetails.add(order);
            }
        }
        BigDecimal totalAmt = trnTransactionDao.selectCusFifTotalAmts(request);
        QueryCusFifResponse response = new QueryCusFifResponse();
        response.setPageNum(request.getPageNum());
        response.setPageSize(request.getPageSize());
        response.setRowCount(total);
        response.setMerAccCode(request.getMerAccCode());
        response.setTranDetails(tranDetails);
        response.setTotalAmt(totalAmt);
        return response;
    }

    @Override
    public QueryPayAppResponse queryPaymentApp(QueryPayAppRequest request) throws Exception {
        if (request == null) {
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, 
            		new Object[] { "QueryPayAppRequest" }));
        }
        PageList<QueryPayAppOrder> pagelist = paymentAppDao.selectPayAppOrders(
        		new PageBounds(request.getPageNum(), request.getPageSize()), request);
        int total = 0;//总记录数
        if (pagelist != null && !pagelist.isEmpty()) {
            total = pagelist.getPaginator().getTotalCount();
        }
        QueryPayAppResponse response = new QueryPayAppResponse();
        response.setPageNum(request.getPageNum());
        response.setPageSize(request.getPageSize());
        response.setRowCount(total);
        response.setOrders(pagelist);
        return response;
    }

}
