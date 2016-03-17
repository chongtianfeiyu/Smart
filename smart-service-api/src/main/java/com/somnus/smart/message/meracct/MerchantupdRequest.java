package com.somnus.smart.message.meracct;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.smart.message.Message;

import javax.validation.constraints.NotNull;

public class MerchantupdRequest extends Message {
	
    /**交易账户号*/
	@NotEmpty
    private String merCode;
    /**修改人*/
	@NotEmpty
    private String modifyBy;
    /**商户名称*/
	@NotEmpty
    private String merName;
    /**商户简称*/
	@NotEmpty
    private String shortName;
    /**网关名称*/
	@NotEmpty
    private String gwName;
    /**商户邮箱*/
	@NotEmpty
    private String merMail;
    /**一级行业分类*/
	@NotEmpty
    private String industryL1;
    /**二级行业分类*/
	@NotEmpty
    private String industryL2;
    /**三级行业分类*/
	@NotEmpty
    private String industryL3;
    /**MCC码*/
    private String mcc;
    /**主网址*/
    private String mainUrl;
    /**风险等级*/
    private String risk;
    /**入账延迟时间*/
    private String recognizeDelay;
    /**商户来源方式*/
    private String merSource;
    /**所属分公司编号*/
    private String companyCode;
    /**我方签约代表工号*/
    private String employeeNo;
    /**代理商编号*/
    private String agencyCode;
    /**所属国家*/
    private String merCountry;
    /**所属省份*/
    private String merProvince;
    /**所属省份*/	
    private String merCity;
    /**法人姓名*/
    private String legalPerson;
    /**法人证件类型*/
    private String lpCerType;
    /**法人证件号码*/
    private String lpCerNo;
    /**法人证件有效日期*/
    private String lpCerVldTo;
    /**营业执照号码*/
    private String licenseNo;
    /**营业执照号码有效日期*/
    private String licenseVldTo;
    /**税证号码*/
    private String taxNo;
    /**组织机构代码*/
    private String orgCode;
    /**组织机构代码证有效日期*/
    private String orgVldTo;
    /**备注*/
    private String remark;
    @NotNull
    /**版本*/
    private Integer version;
    /**版本状态:1:审核中 2:有效 3:无效*/
    @NotEmpty
    private String status;
    /**操作标志:1:被删除 2:被新版本替换*/
    @NotEmpty
    private String operFlag;
    /**生效日期*/
    @NotEmpty
    private String effectDate;
    /**失效日期*/
    @NotEmpty
    private String loseEffectDate;
    /**修改时间*/
    @NotNull
    private Date modifyTime;
    
	public String getMerCode() {
		return merCode;
	}
	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public String getMerName() {
		return merName;
	}
	public void setMerName(String merName) {
		this.merName = merName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getGwName() {
		return gwName;
	}
	public void setGwName(String gwName) {
		this.gwName = gwName;
	}
	public String getMerMail() {
		return merMail;
	}
	public void setMerMail(String merMail) {
		this.merMail = merMail;
	}
	public String getIndustryL1() {
		return industryL1;
	}
	public void setIndustryL1(String industryL1) {
		this.industryL1 = industryL1;
	}
	public String getIndustryL2() {
		return industryL2;
	}
	public void setIndustryL2(String industryL2) {
		this.industryL2 = industryL2;
	}
	public String getIndustryL3() {
		return industryL3;
	}
	public void setIndustryL3(String industryL3) {
		this.industryL3 = industryL3;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getMainUrl() {
		return mainUrl;
	}
	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}
	public String getRisk() {
		return risk;
	}
	public void setRisk(String risk) {
		this.risk = risk;
	}
	public String getRecognizeDelay() {
		return recognizeDelay;
	}
	public void setRecognizeDelay(String recognizeDelay) {
		this.recognizeDelay = recognizeDelay;
	}
	public String getMerSource() {
		return merSource;
	}
	public void setMerSource(String merSource) {
		this.merSource = merSource;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getAgencyCode() {
		return agencyCode;
	}
	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	public String getMerCountry() {
		return merCountry;
	}
	public void setMerCountry(String merCountry) {
		this.merCountry = merCountry;
	}
	public String getMerProvince() {
		return merProvince;
	}
	public void setMerProvince(String merProvince) {
		this.merProvince = merProvince;
	}
	public String getMerCity() {
		return merCity;
	}
	public void setMerCity(String merCity) {
		this.merCity = merCity;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getLpCerType() {
		return lpCerType;
	}
	public void setLpCerType(String lpCerType) {
		this.lpCerType = lpCerType;
	}
	public String getLpCerNo() {
		return lpCerNo;
	}
	public void setLpCerNo(String lpCerNo) {
		this.lpCerNo = lpCerNo;
	}
	public String getLpCerVldTo() {
		return lpCerVldTo;
	}
	public void setLpCerVldTo(String lpCerVldTo) {
		this.lpCerVldTo = lpCerVldTo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getLicenseVldTo() {
		return licenseVldTo;
	}
	public void setLicenseVldTo(String licenseVldTo) {
		this.licenseVldTo = licenseVldTo;
	}
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgVldTo() {
		return orgVldTo;
	}
	public void setOrgVldTo(String orgVldTo) {
		this.orgVldTo = orgVldTo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperFlag() {
		return operFlag;
	}
	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}
	public String getEffectDate() {
		return effectDate;
	}
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}
	public String getLoseEffectDate() {
		return loseEffectDate;
	}
	public void setLoseEffectDate(String loseEffectDate) {
		this.loseEffectDate = loseEffectDate;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
