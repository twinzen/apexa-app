package com.twinzom.apexa.dao.po;

import java.util.Date;

public class AccountPo {

	private Long acid;
	
	private String acctNum;
	
	private String acctMethod;
	
	private Date startDate;
	
	private Date terminationDate;

	public Long getAcid() {
		return acid;
	}

	public void setAcid(Long acid) {
		this.acid = acid;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public String getAcctMethod() {
		return acctMethod;
	}

	public void setAcctMethod(String acctMethod) {
		this.acctMethod = acctMethod;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	
	
}
