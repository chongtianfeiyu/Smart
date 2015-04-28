package com.somnus.smart.biz.meracc.service.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.smart.base.dao.AccMappingDao;
import com.somnus.smart.base.dao.CusSubAccInfoDao;
import com.somnus.smart.base.dao.DaySystemDao;
import com.somnus.smart.base.dao.InfAcctypeDao;
import com.somnus.smart.base.dao.MerAccountDao;
import com.somnus.smart.base.dao.MerMerchantDao;
import com.somnus.smart.base.dao.PerAccountDao;
import com.somnus.smart.base.domain.AccMapping;
import com.somnus.smart.base.domain.Accsubentity;
import com.somnus.smart.base.domain.CusSubaccinfo;
import com.somnus.smart.base.domain.DaySystem;
import com.somnus.smart.base.domain.MerAccount;
import com.somnus.smart.base.domain.MerMerchant;
import com.somnus.smart.base.domain.PerAccount;
import com.somnus.smart.biz.meracc.service.MeracctService;
import com.somnus.smart.message.meracct.AccountAllowInOrOutRequest;
import com.somnus.smart.message.meracct.MeraccountupdRequest;
import com.somnus.smart.message.meracct.MeracctRequest;
import com.somnus.smart.message.meracct.MerchantupdRequest;
import com.somnus.smart.message.meracct.PerAccountRequest;
import com.somnus.smart.message.meracct.PerAccountUpdRequest;
import com.somnus.smart.message.meracct.SpeAccountRequest;
import com.somnus.smart.service.common.CacheConstants;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.service.common.CusSubAccInfoUtil;
import com.somnus.smart.support.common.MsgCodeList;
import com.somnus.smart.support.exceptions.BizException;
import com.somnus.smart.support.util.DateUtil;

/**
 * 商户开户接口
 * 
 * @author 李太平
 * @version $Id: MeracctServiceImpl.java, v 0.1 2015-4-3 下午04:17:13 李太平 Exp $
 */
@Service
public class MeracctServiceImpl implements MeracctService {
	/** 商户账户号前缀 */
	private static final String BIZ_SUB_ACC_CODE_PREFIX = "1";
	/** 个人账户号前缀 */
	private static final String IDV_SUB_ACC_CODE_PREFIX = "3";
	/** MessageSourceAccessor */
	@Autowired
	private MessageSourceAccessor msa;
	/** MerMerchantDao */
	@Autowired
	private MerMerchantDao merMerchantDao;
	/** MerAccountDao */
	@Autowired
	private MerAccountDao merAccountDao;
	/** InfAcctypeDao */
	@Autowired
	private InfAcctypeDao infAcctypeDao;
	/** CusSubAccInfoDao */
	@Autowired
	private CusSubAccInfoDao cusSubaccinfoDao;
	/** DaySystemDao */
	@Autowired
	private DaySystemDao daySystemDao;
	/** PerAccountDao */
	@Autowired
	private PerAccountDao perAccountDao;
	/** AccMappingDao */
	@Autowired
	private AccMappingDao accMappingDao;

	private transient Logger log = LoggerFactory.getLogger(this.getClass());

	@Transactional
	public void txnMerCreateAcc(MeracctRequest request) throws Exception {
		MerMerchant customer = merMerchantDao.selectByMercode(request
				.getMerCode());
		// 商户不存在则新增商户信息
		if (customer == null) {
			MerMerchant merchant = createMermerchant(request);
			merMerchantDao.insert(merchant);
		}
		String acctCode = request.getAcctCode();
		List<MerAccount> accounts = merAccountDao.selectByAcctcode(acctCode);// 查询交易账户号是否存在
		// 交易账户号已存在直接返回
		if (accounts != null && accounts.size() > 0) {
			log.warn(msa.getMessage(MsgCodeList.ERROR_305003,
					new Object[] { "merAccCode:".concat(acctCode) }));
			return;
		}

		// 新增交易账户
		MerAccount meraccount = createMeraccount(request);
		merAccountDao.insert(meraccount);

		// 查询企业客户账户类型
		List<Accsubentity> enterprises = infAcctypeDao.selectEnterprise();
		if (enterprises == null || enterprises.isEmpty()) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_305005));
		}

		// 新增功能账户
		for (Accsubentity accsub : enterprises) {
			Map<String, Object> map = createCussbuaccinfoMap(accsub, request);
			cusSubaccinfoDao.insert(map);
		}
	}

	@Transactional
	public void txnPerCreateAcc(PerAccountRequest request) throws Exception {
		String acctCode = request.getAcctCode();
		// 查询个人交易账户号是否存在
		PerAccount account = perAccountDao.selectByAcctCode(acctCode);
		// 个人交易账户号已存在则直接返回
		if (account != null) {
			log.warn(msa.getMessage(MsgCodeList.ERROR_305003,
					new Object[] { "merAccCode:".concat(acctCode) }));
			return;
		}

		// 新增交易账户
		PerAccount peraccount = createPeraccount(request);
		// 如果是开通个人专业账户还需建立专用交易账户与标准交易账户关联关系
		if (Constants.IDV_ACC_TYPE_2.equals(request.getAcctType())) {
			if (StringUtils.isBlank(request.getStdAcctCode())) {
				throw new BizException(msa.getMessage(MsgCodeList.ERROR_305001,
						new Object[] { "stdAcctCode:".concat(request
								.getStdAcctCode()) }));
			}
			PerAccount stdAccount = perAccountDao.selectByAcctCode(request.getStdAcctCode());
			if(stdAccount==null){
				throw new BizException("开通专用账户标准账户号必须存在, stdAcctCode:".concat(request.getStdAcctCode())+"不存在");
			}
			AccMapping accMapping = new AccMapping();
			accMapping.setSpeAcctCode(request.getAcctCode());
			accMapping.setStdAcctCode(request.getStdAcctCode());
			accMapping.setCreateBy("admin");
			accMapping.setCreateTime(DateUtil.getCurrentTimeStamp());
			accMappingDao.insert(accMapping);
		}
		perAccountDao.insert(peraccount);

		// 查询个人客户账户类型
		List<Accsubentity> individuals = infAcctypeDao.selectIndividual();
		if (individuals == null || individuals.isEmpty()) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_305005));
		}

		// 新增功能账户
		for (Accsubentity accsub : individuals) {
			// 如果是开通个人专用账户，只需开通流动资金户
			if (Constants.IDV_ACC_TYPE_2.equals(request.getAcctType())
					&& !Constants.ACC_TYPE_82.equals(accsub.getAccType())) {
				continue;
			}
			Map<String, Object> map = createCussbuaccinfoIdvMap(accsub, request);
			cusSubaccinfoDao.insert(map);
		}
	}

	/**
	 * 构建商户对象
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	private MerMerchant createMermerchant(MeracctRequest request)
			throws Exception {
		MerMerchant merchant = new MerMerchant();
		PropertyUtils.copyProperties(merchant, request);
		// String merId = merMerchantDao.getMerchantSequences();//商户信息主键
		// merchant.setMerId(new BigDecimal(merId));
		return merchant;
	}

	/**
	 * 构建商户功能账户对象
	 * 
	 * @param accSub
	 * @param meracctRequest
	 * @return
	 */
	private Map<String, Object> createCussbuaccinfoMap(Accsubentity accSub,
			MeracctRequest request) {
		String subCode2st = accSub.getSubCode2st();// 二级科目号
		if (StringUtils.isBlank(subCode2st)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001,
					new Object[] { "二级科目号" }));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("subAccCode",
				BIZ_SUB_ACC_CODE_PREFIX.concat(request.getCurrency())
						.concat(accSub.getSubCode())
						.concat(cusSubaccinfoDao.getCussubaccSequences()));
		map.put("subAccName", accSub.getAccTypeName());
		map.put("accDate", getSystemDate());
		map.put("subCode", accSub.getSubCode());
		map.put("merAccCode", request.getAcctCode());
		map.put("relSubCode",
				MessageFormat.format(accSub.getSubCode2st(),
						request.getAcctCode()));
		map.put("balDir", accSub.getBalCtrlDir());
		map.put("ccyCode", request.getCurrency());
		map.put("curBal", BigDecimal.ZERO);
		map.put("availBal", BigDecimal.ZERO);
		map.put("bizFreezeBal", BigDecimal.ZERO);
		map.put("magFreezeBal", BigDecimal.ZERO);
		map.put("payableFreezeBal", BigDecimal.ZERO);
		map.put("initialBal", BigDecimal.ZERO);
		map.put("debitAmt", BigDecimal.ZERO);
		map.put("creditAmt", BigDecimal.ZERO);
		map.put("accType", accSub.getAccType());
		map.put("overFlag", accSub.getRedFlag());
		map.put("accStatus", Constants.ACC_STATUS_0);
		map.put("openDate", new Date());
		map.put("openBy", "ADMIN");
		map.put("createTime", DateUtil.getCurrentTimeStamp());
		map.put("createBy", "ADMIN");
		map.put("lastInitialBal", BigDecimal.ZERO);
		map.put("tableName",
				CusSubAccInfoUtil.BIZ_CUS_SUB_INFO_TBL);
		return map;
	}

	/**
	 * 构建商户交易账户对象
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	private MerAccount createMeraccount(MeracctRequest request)
			throws Exception {
		MerAccount meraccount = new MerAccount();
		PropertyUtils.copyProperties(meraccount, request);
		// String acctId = merAccountDao.getMeraccSequences();
		// meraccount.setAcctId(Long.parseLong(acctId));
		return meraccount;
	}

	/**
	 * 构建个人交易账户对象
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	private PerAccount createPeraccount(PerAccountRequest request)
			throws Exception {
		PerAccount peraccount = new PerAccount();
		PropertyUtils.copyProperties(peraccount, request);
		peraccount.setAccStatus("0");
		peraccount.setFundStatus("0");
		return peraccount;
	}

	/**
	 * 构建个人功能账户对象
	 * 
	 * @param accsub
	 * @param request
	 * @return
	 */
	private Map<String, Object> createCussbuaccinfoIdvMap(Accsubentity accSub,
			PerAccountRequest request) {
		String subCode2st = accSub.getSubCode2st();// 二级科目号
		if (StringUtils.isBlank(subCode2st)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001,
					new Object[] { "二级科目号" }));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("subAccCode",
				IDV_SUB_ACC_CODE_PREFIX.concat(request.getCcyCode())
						.concat(accSub.getSubCode())
						.concat(cusSubaccinfoDao.getCussubaccSequences()));
		map.put("subAccName", accSub.getAccTypeName());
		map.put("accDate", getSystemDate());
		map.put("subCode", accSub.getSubCode());
		map.put("merAccCode", request.getAcctCode());
		map.put("relSubCode",
				MessageFormat.format(accSub.getSubCode2st(),
						request.getAcctCode()));
		map.put("balDir", accSub.getBalCtrlDir());
		map.put("ccyCode", request.getCcyCode());
		map.put("curBal", BigDecimal.ZERO);
		map.put("availBal", BigDecimal.ZERO);
		map.put("bizFreezeBal", BigDecimal.ZERO);
		map.put("magFreezeBal", BigDecimal.ZERO);
		map.put("payableFreezeBal", BigDecimal.ZERO);
		map.put("initialBal", BigDecimal.ZERO);
		map.put("debitAmt", BigDecimal.ZERO);
		map.put("creditAmt", BigDecimal.ZERO);
		map.put("accType", accSub.getAccType());
		map.put("overFlag", accSub.getRedFlag());
		map.put("accStatus", Constants.ACC_STATUS_0);
		map.put("openDate", new Date());
		map.put("openBy", "ADMIN");
		map.put("createTime", DateUtil.getCurrentTimeStamp());
		map.put("createBy", "ADMIN");
		map.put("lastInitialBal", BigDecimal.ZERO);
		map.put("tableName", CusSubAccInfoUtil.IDV_CUS_SUB_INFO_TBL);
		return map;
	}

	/**
	 * 查询账务日期
	 * 
	 * @return
	 */
	private Date getSystemDate() {
		Date systemDate = null;
		DaySystem daySystem = daySystemDao
				.getDaySystem(Constants.CORE_CUT_CODE);
		if (daySystem != null) {
			systemDate = DateTime.parse(daySystem.getCoreDate()).toDate();
		} else {
			systemDate = new Date();
		}
		return systemDate;
	}

	@Transactional
	public void updateMermerchant(MerchantupdRequest request) throws Exception {
		String merCode = request.getMerCode();
		if (StringUtils.isBlank(merCode)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001,
					new Object[] { "merCode" }));
		}
		MerMerchant merchant = merMerchantDao.selectByMercode(merCode);// 查询商户是否存在
		if (merchant == null) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002,
					new Object[] { "商户号为: ".concat(merCode) }));
		}
		MerMerchant chant = new MerMerchant();
		PropertyUtils.copyProperties(chant, request);
		merMerchantDao.updateByPrimaryKeySelective(chant);// 更新商户信息
	}

	@Transactional
	public void updateMeraccount(MeraccountupdRequest request) throws Exception {
		String acctCode = request.getAcctCode();
		if (StringUtils.isBlank(acctCode)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001,
					new Object[] { "acctCode" }));
		}
		List<MerAccount> accounts = merAccountDao.selectByAcctcode(acctCode);// 查询交易账户号是否存在
		if (accounts == null || accounts.isEmpty()) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002,
					new Object[] { "交易账户号为: ".concat(acctCode) }));
		}
		MerAccount account = new MerAccount();
		PropertyUtils.copyProperties(account, request);
		merAccountDao.updateByPrimaryKeySelective(account);// 更新交易账户信息
	}

	@Transactional
	public void updatePerAccount(PerAccountUpdRequest request) throws Exception {
		String acctCode = request.getAcctCode();
		if (StringUtils.isBlank(acctCode)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001,
					new Object[] { "acctCode" }));
		}
		// 查询个人交易账户号是否存在
		PerAccount existAcc = perAccountDao.selectByAcctCode(acctCode);
		if (existAcc == null) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002,
					new Object[] { "交易账户号为: ".concat(acctCode) }));
		}
		PerAccount account = new PerAccount();
		PropertyUtils.copyProperties(account, request);
		// 更新交易账户信息
		perAccountDao.updateByPrimaryKeySelective(account);
	}

	@CacheEvict(value = CacheConstants.CACHE_MERACCOUNT, allEntries = true)
	@Override
	@Transactional
	public void updateMeraccount(AccountAllowInOrOutRequest request)
			throws Exception {
		String acctCode = request.getMerAccCode();
		List<MerAccount> accounts = merAccountDao.selectByAcctcode(acctCode);// 查询交易账户号是否存在
		if (accounts == null || accounts.isEmpty()) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_505002,
					new Object[] { "交易账户号为: ".concat(acctCode) }));
		}
		MerAccount account = new MerAccount();
		account.setAcctCode(acctCode);
		account.setAcctId(accounts.get(0).getAcctId());
		account.setAllowIn(request.getAllowIn());
		account.setAllowOut(request.getAllowOut());
		account.setModifyBy(request.getModifyBy());
		account.setModifyTime(new Date());
		merAccountDao.updateByPrimaryKeySelective(account);// 更新交易账户信息
	}

	/**
	 * 新增特定账户
	 */
	@Override
	public void insertSpeAccount(SpeAccountRequest request) throws Exception {
		PerAccount perAccount = perAccountDao.selectByAcctCode(request
				.getAcctCode());
		// 账户不存在则新增商户信息
		if (perAccount == null) {
			throw new BizException("账户不存在");
		}
		List<CusSubaccinfo> cusSubaccinfoIdvs = cusSubaccinfoDao
				.selectCusSubOrders(CusSubAccInfoUtil.getTableByAccCodeLength(request.getAcctCode().length()),
						request.getAcctCode(), request.getCcyCode(),
						request.getAcctType());// 查询特定账户号是否存在
		// 特定账户已存在直接返回
		if (cusSubaccinfoIdvs != null && cusSubaccinfoIdvs.size() > 0) {
			log.warn(msa
					.getMessage(MsgCodeList.ERROR_305003,
							new Object[] { "merAccCode:".concat(request
									.getAcctCode()) }));
			return;
		}
		// 查询特定账户类型
		Accsubentity accsubentity = infAcctypeDao.selectAccByType(request
				.getAcctType());
		if (accsubentity == null) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_305005));
		}

		// 新增功能账户
		Map<String, Object> map = createCusSubaccinfoIdvMap(accsubentity,
				request);
		cusSubaccinfoDao.insert(map);
	}

	/**
	 * 构建特定账户功能账户对象
	 * 
	 * @param accsub
	 * @param entity
	 * @return
	 */
	private Map<String, Object> createCusSubaccinfoIdvMap(Accsubentity accSub,
			SpeAccountRequest request) {
		String subCode2st = accSub.getSubCode2st();// 二级科目号
		if (StringUtils.isBlank(subCode2st)) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001,
					new Object[] { "二级科目号" }));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("subAccCode",
				IDV_SUB_ACC_CODE_PREFIX.concat(request.getCcyCode())
						.concat(accSub.getSubCode())
						.concat(cusSubaccinfoDao.getCussubaccSequences()));
		map.put("subAccName", accSub.getAccTypeName());
		map.put("accDate", getSystemDate());
		map.put("subCode", accSub.getSubCode());
		map.put("merAccCode", request.getAcctCode());
		map.put("relSubCode",
				MessageFormat.format(accSub.getSubCode2st(),
						request.getAcctCode()));
		map.put("balDir", accSub.getBalCtrlDir());
		map.put("ccyCode", request.getCcyCode());
		map.put("curBal", BigDecimal.ZERO);
		map.put("availBal", BigDecimal.ZERO);
		map.put("bizFreezeBal", BigDecimal.ZERO);
		map.put("magFreezeBal", BigDecimal.ZERO);
		map.put("payableFreezeBal", BigDecimal.ZERO);
		map.put("initialBal", BigDecimal.ZERO);
		map.put("debitAmt", BigDecimal.ZERO);
		map.put("creditAmt", BigDecimal.ZERO);
		map.put("accType", accSub.getAccType());
		map.put("overFlag", accSub.getRedFlag());
		map.put("accStatus", Constants.ACC_STATUS_0);
		map.put("openDate", new Date());
		map.put("openBy", "ADMIN");
		map.put("createTime", DateUtil.getCurrentTimeStamp());
		map.put("createBy", "ADMIN");
		map.put("lastInitialBal", BigDecimal.ZERO);
		map.put("tableName", CusSubAccInfoUtil.IDV_CUS_SUB_INFO_TBL);
		return map;
	}

}
