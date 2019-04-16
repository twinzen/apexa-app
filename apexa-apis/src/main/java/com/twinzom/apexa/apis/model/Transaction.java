package com.twinzom.apexa.apis.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.twinzom.apexa.caleng.model.CalTxn;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction implements Comparable<Transaction> {

	private Security security;
	
	private Long txnid;
	
	private String txnTypeCde;
	
	private String extTxnRef;
	
	private String extTxnTypeCde;
	
	private String acno;
	
	private Long secid;
	
	private Date exeDtTm;
	
	private Double exePrc;
	
	private String prcCcy;
	
	private Double qty;
	
	private Double pripAmtLocl;
	
	private Date setlDtTm;
	
	private String setlCcy;
	
	private Double setlAmtSetl;
	
	private Double setlLoclRate;
	
	private String mktCde;
	
	private String longShtInd;
	
	private Double mktValLocl;
	
	private Double mktValAcct;
	
	private Double bkCostLocl;
	
	private Double bkCostAcct;

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public Long getTxnid() {
		return txnid;
	}

	public void setTxnid(Long txnid) {
		this.txnid = txnid;
	}

	public String getTxnTypeCde() {
		return txnTypeCde;
	}

	public void setTxnTypeCde(String txnTypeCde) {
		this.txnTypeCde = txnTypeCde;
	}

	public String getExtTxnRef() {
		return extTxnRef;
	}

	public void setExtTxnRef(String extTxnRef) {
		this.extTxnRef = extTxnRef;
	}

	public String getExtTxnTypeCde() {
		return extTxnTypeCde;
	}

	public void setExtTxnTypeCde(String extTxnTypeCde) {
		this.extTxnTypeCde = extTxnTypeCde;
	}

	public String getAcno() {
		return acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}

	public Long getSecid() {
		return secid;
	}

	public void setSecid(Long secid) {
		this.secid = secid;
	}

	public Date getExeDtTm() {
		return exeDtTm;
	}

	public void setExeDtTm(Date exeDtTm) {
		this.exeDtTm = exeDtTm;
	}

	public Double getExePrc() {
		return exePrc;
	}

	public void setExePrc(Double exePrc) {
		this.exePrc = exePrc;
	}

	public String getPrcCcy() {
		return prcCcy;
	}

	public void setPrcCcy(String prcCcy) {
		this.prcCcy = prcCcy;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getPripAmtLocl() {
		return pripAmtLocl;
	}

	public void setPripAmtLocl(Double pripAmtLocl) {
		this.pripAmtLocl = pripAmtLocl;
	}

	public Date getSetlDtTm() {
		return setlDtTm;
	}

	public void setSetlDtTm(Date setlDtTm) {
		this.setlDtTm = setlDtTm;
	}

	public String getSetlCcy() {
		return setlCcy;
	}

	public void setSetlCcy(String setlCcy) {
		this.setlCcy = setlCcy;
	}

	public Double getSetlAmtSetl() {
		return setlAmtSetl;
	}

	public void setSetlAmtSetl(Double setlAmtSetl) {
		this.setlAmtSetl = setlAmtSetl;
	}

	public Double getSetlLoclRate() {
		return setlLoclRate;
	}

	public void setSetlLoclRate(Double setlLoclRate) {
		this.setlLoclRate = setlLoclRate;
	}

	public String getMktCde() {
		return mktCde;
	}

	public void setMktCde(String mktCde) {
		this.mktCde = mktCde;
	}

	public String getLongShtInd() {
		return longShtInd;
	}

	public void setLongShtInd(String longShtInd) {
		this.longShtInd = longShtInd;
	}

	public Double getMktValLocl() {
		return mktValLocl;
	}

	public void setMktValLocl(Double mktValLocl) {
		this.mktValLocl = mktValLocl;
	}

	public Double getMktValAcct() {
		return mktValAcct;
	}

	public void setMktValAcct(Double mktValAcct) {
		this.mktValAcct = mktValAcct;
	}

	public Double getBkCostLocl() {
		return bkCostLocl;
	}

	public void setBkCostLocl(Double bkCostLocl) {
		this.bkCostLocl = bkCostLocl;
	}

	public Double getBkCostAcct() {
		return bkCostAcct;
	}

	public void setBkCostAcct(Double bkCostAcct) {
		this.bkCostAcct = bkCostAcct;
	}
	
	@Override
	public int compareTo(Transaction t) {
		return (this.exeDtTm.compareTo(t.exeDtTm));
	}
}
