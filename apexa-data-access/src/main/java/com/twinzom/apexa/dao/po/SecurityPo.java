package com.twinzom.apexa.dao.po;

import java.util.Date;

public class SecurityPo {

	private Long secid;
	
	private String secCde;
	
	private String name;
	
	private String ccy;
	
	private Integer riskLvl;
	
	private Double stdDv;
	
	private Double annRtrn;
	
	private Double sharpe;
	
	private Double navPrc;
	
	private Double bidPrc;
	
	private Double offPrc;
	
	private Double min52Prc;
	
	private Double max52Prc;
	
	private Date prcDt;
	
	private Date statcDt;
	
	public Long getSecid() {
		return secid;
	}

	public void setSecid(Long secid) {
		this.secid = secid;
	}

	public String getSecCde() {
		return secCde;
	}

	public void setSecCde(String secCde) {
		this.secCde = secCde;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public Integer getRiskLvl() {
		return riskLvl;
	}

	public void setRiskLvl(Integer riskLvl) {
		this.riskLvl = riskLvl;
	}

	public Double getStdDv() {
		return stdDv;
	}

	public void setStdDv(Double stdDv) {
		this.stdDv = stdDv;
	}

	public Double getAnnRtrn() {
		return annRtrn;
	}

	public void setAnnRtrn(Double annRtrn) {
		this.annRtrn = annRtrn;
	}

	public Double getSharpe() {
		return sharpe;
	}

	public void setSharpe(Double sharpe) {
		this.sharpe = sharpe;
	}

	public Double getNavPrc() {
		return navPrc;
	}

	public void setNavPrc(Double navPrc) {
		this.navPrc = navPrc;
	}

	public Double getBidPrc() {
		return bidPrc;
	}

	public void setBidPrc(Double bidPrc) {
		this.bidPrc = bidPrc;
	}

	public Double getOffPrc() {
		return offPrc;
	}

	public void setOffPrc(Double offPrc) {
		this.offPrc = offPrc;
	}

	public Double getMin52Prc() {
		return min52Prc;
	}

	public void setMin52Prc(Double min52Prc) {
		this.min52Prc = min52Prc;
	}

	public Double getMax52Prc() {
		return max52Prc;
	}

	public void setMax52Prc(Double max52Prc) {
		this.max52Prc = max52Prc;
	}

	public Date getPrcDt() {
		return prcDt;
	}

	public void setPrcDt(Date prcDt) {
		this.prcDt = prcDt;
	}

	public Date getStatcDt() {
		return statcDt;
	}

	public void setStatcDt(Date statcDt) {
		this.statcDt = statcDt;
	}

	public String getStatCde() {
		return statCde;
	}

	public void setStatCde(String statCde) {
		this.statCde = statCde;
	}

	public String getFundHse() {
		return fundHse;
	}

	public void setFundHse(String fundHse) {
		this.fundHse = fundHse;
	}

	private String statCde;
	
	private String fundHse;
	
	
}
