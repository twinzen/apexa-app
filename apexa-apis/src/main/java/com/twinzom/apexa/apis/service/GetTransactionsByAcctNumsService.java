package com.twinzom.apexa.apis.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twinzom.apexa.apis.model.AccountHoldings;
import com.twinzom.apexa.apis.model.Holding;
import com.twinzom.apexa.apis.model.Security;
import com.twinzom.apexa.apis.model.Transaction;
import com.twinzom.apexa.apis.remoteclient.CalEngClient;
import com.twinzom.apexa.caleng.model.CalGroup;
import com.twinzom.apexa.caleng.model.CalPosition;
import com.twinzom.apexa.caleng.model.CalResponse;
import com.twinzom.apexa.caleng.model.CalSnapshot;
import com.twinzom.apexa.caleng.model.CalTxn;
import com.twinzom.apexa.dao.AccountDao;
import com.twinzom.apexa.dao.SecurityDao;
import com.twinzom.apexa.dao.TransactionDao;
import com.twinzom.apexa.dao.po.AccountPo;
import com.twinzom.apexa.dao.po.SecurityPo;
import com.twinzom.apexa.dao.po.TransactionPo;

@Service
public class GetTransactionsByAcctNumsService {

	@Autowired
	AccountDao accountDao;
	
	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	SecurityDao securityDao;
	
	private static  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public List<Transaction> process (String acctNum) throws InterruptedException, ExecutionException {
		
		/**
		 * convert external account id to internal account id
		 */
		//TODO: valid input account number list
		
		
		AccountPo apo = accountDao.getAcctByAccNum(acctNum);
		
		// Format acid list
		List<Long> acids = new ArrayList<Long>();
		Map<Long, String> acidAcctNumMap = new HashMap<Long, String>();
		acids.add(apo.getAcid());
		acidAcctNumMap.put(apo.getAcid(), apo.getAcctNum());
		
		// Get transactions from DB
		List<TransactionPo> tpos = transactionDao.getTxnsByAcctIds(acids);
		
		List<Transaction> txns = convertTxnPoToTxn(tpos);
		
		Collections.sort(txns);
		
		populateSecurity(txns);
		
		return txns;
	}
	
	private void populateSecurity (List<Transaction> txns) {
		
		List<Long> secids = new ArrayList<Long>();
		
		for (Transaction txn : txns) {
			secids.add(txn.getSecid());
		}
		
		List<SecurityPo> secPos = securityDao.getSecsBySecids(secids);
		
		Map<Long, Security> secs = convertSecPoToSec (secPos);
		
		for (Transaction txn : txns) {
			Security s = secs.get(txn.getSecid());
			txn.setSecurity(s);
		}
		
	}
	
	private Map<Long, Security> convertSecPoToSec (List<SecurityPo> secPos) {
		
		Map<Long, Security> secs = new HashMap<Long, Security>();
		
		for (SecurityPo spo : secPos) {
			Security sec = new Security();
			sec.setSecid(spo.getSecid());
			sec.setCode(spo.getSecCde());
			sec.setName(spo.getName());
			sec.setCcy(spo.getCcy());
			sec.setRiskLvl(spo.getRiskLvl());
			sec.setPrice(spo.getNavPrc());
			sec.setStdev(spo.getStdDv());
			sec.setAnnRtrn(spo.getAnnRtrn());
			sec.setSharpe(spo.getSharpe());
			secs.put(sec.getSecid(), sec);
		}
		
		return secs;
		
	}
	
	private List<Transaction> convertTxnPoToTxn (List<TransactionPo> txnPos) {
		
		List<Transaction> txns = new ArrayList<Transaction>();
		
		for (TransactionPo txnpo : txnPos) {
			Transaction txn = new Transaction();
			txn.setTxnid(txnpo.getTxnid());
			txn.setTxnTypeCde(txnpo.getTxnTypeCde());
			txn.setExtTxnRef(txnpo.getExtTxnRef());
			txn.setExtTxnTypeCde(txnpo.getExtTxnTypeCde());
			txn.setSecid(txnpo.getSecid());
			txn.setExeDtTm(txnpo.getExeDtTm());
			txn.setExePrc(Double.valueOf(txnpo.getExePrc()));
			txn.setPrcCcy(txnpo.getPrcCcy());
			txn.setQty(Double.valueOf(txnpo.getQty()));
			txn.setPripAmtLocl(Double.valueOf(txnpo.getPripAmtLocl()));
			txn.setSetlDtTm(txnpo.getSetlDtTm());
			txn.setSetlCcy(txnpo.getSetlCcy());
			txn.setSetlAmtSetl(Double.valueOf(txnpo.getSetlAmtSetl()));
			txn.setSetlLoclRate(Double.valueOf(txnpo.getSetlLoclRate()));
			txn.setMktCde(txnpo.getMktCde());
			txn.setLongShtInd(txnpo.getLongShtInd());
			txn.setMktValLocl(Double.valueOf(txnpo.getMktValLocl()));
			txn.setMktValAcct(Double.valueOf(txnpo.getMktValAcct()));
			txn.setBkCostLocl(Double.valueOf(txnpo.getBkCostLocl()));
			txn.setBkCostAcct(Double.valueOf(txnpo.getBkCostAcct()));
			txns.add(txn);
		}
		
		return txns;
		
	}
	
}
