package com.somnus.smart.base.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CusSubaccinfo extends Entity {
    private String subAccCode;

    private String subAccName;

    private Date accDate;

    private String merAccCode;

    private String subCode;

    private String relSubCode;

    private String balDir;

    private String ccyCode;

    private BigDecimal curBal;

    private BigDecimal availBal;

    private BigDecimal bizFreezeBal;

    private BigDecimal magFreezeBal;

    private BigDecimal payableFreezeBal;

    private BigDecimal initialBal;

    private BigDecimal debitAmt;

    private BigDecimal creditAmt;

    private String accType;

    private String overFlag;

    private String accStatus;

    private Date openDate;

    private String openBy;

    private Date closeDate;

    private String closeBy;

    private String createTime;

    private String createBy;

    private String modifyTime;

    private String modifyBy;
    
    private BigDecimal lastInitialBal;

    public String getSubAccCode() {
        return subAccCode;
    }

    public void setSubAccCode(String subAccCode) {
        this.subAccCode = subAccCode;
    }

    public String getSubAccName() {
        return subAccName;
    }

    public void setSubAccName(String subAccName) {
        this.subAccName = subAccName;
    }

    public Date getAccDate() {
        return accDate;
    }

    public void setAccDate(Date accDate) {
        this.accDate = accDate;
    }

    public String getMerAccCode() {
        return merAccCode;
    }

    public void setMerAccCode(String merAccCode) {
        this.merAccCode = merAccCode;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getRelSubCode() {
        return relSubCode;
    }

    public void setRelSubCode(String relSubCode) {
        this.relSubCode = relSubCode;
    }

    public String getBalDir() {
        return balDir;
    }

    public void setBalDir(String balDir) {
        this.balDir = balDir;
    }

    public String getCcyCode() {
        return ccyCode;
    }

    public void setCcyCode(String ccyCode) {
        this.ccyCode = ccyCode;
    }

    public BigDecimal getCurBal() {
        return curBal;
    }

    public void setCurBal(BigDecimal curBal) {
        this.curBal = curBal;
    }

    public BigDecimal getAvailBal() {
        return availBal;
    }

    public void setAvailBal(BigDecimal availBal) {
        this.availBal = availBal;
    }

    public BigDecimal getBizFreezeBal() {
        return bizFreezeBal;
    }

    public void setBizFreezeBal(BigDecimal bizFreezeBal) {
        this.bizFreezeBal = bizFreezeBal;
    }

    public BigDecimal getMagFreezeBal() {
        return magFreezeBal;
    }

    public void setMagFreezeBal(BigDecimal magFreezeBal) {
        this.magFreezeBal = magFreezeBal;
    }

    public BigDecimal getPayableFreezeBal() {
        return payableFreezeBal;
    }

    public void setPayableFreezeBal(BigDecimal payableFreezeBal) {
        this.payableFreezeBal = payableFreezeBal;
    }

    public BigDecimal getInitialBal() {
        return initialBal;
    }

    public void setInitialBal(BigDecimal initialBal) {
        this.initialBal = initialBal;
    }

    public BigDecimal getDebitAmt() {
        return debitAmt;
    }

    public void setDebitAmt(BigDecimal debitAmt) {
        this.debitAmt = debitAmt;
    }

    public BigDecimal getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(BigDecimal creditAmt) {
        this.creditAmt = creditAmt;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getOverFlag() {
        return overFlag;
    }

    public void setOverFlag(String overFlag) {
        this.overFlag = overFlag;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getOpenBy() {
        return openBy;
    }

    public void setOpenBy(String openBy) {
        this.openBy = openBy;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public String getCloseBy() {
        return closeBy;
    }

    public void setCloseBy(String closeBy) {
        this.closeBy = closeBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

	public BigDecimal getLastInitialBal() {
		return lastInitialBal;
	}

	public void setLastInitialBal(BigDecimal lastInitialBal) {
		this.lastInitialBal = lastInitialBal;
	}
}