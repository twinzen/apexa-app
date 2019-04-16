package com.twinzom.apexa.apis.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twinzom.apexa.apis.model.AccountHoldings;
import com.twinzom.apexa.apis.model.Transaction;
import com.twinzom.apexa.apis.service.GetHoldingsByAcctNumsService;
import com.twinzom.apexa.apis.service.GetTransactionsByAcctNumsService;

@RestController
public class TransactionController {

	private static final Logger logger = LogManager.getLogger(TransactionController.class);

	@Autowired
	GetTransactionsByAcctNumsService getTransactionsByAcctNumsService;
	
	@RequestMapping(value="/transaction/getByAcctNums", method=RequestMethod.GET)
    public List<Transaction> getByAcctNums (
	    		String acctNums, 
	    		String dates
    		) {
		
		List<String> acctNumsList = Arrays.asList(acctNums.split(","));
		
		List<Transaction> txns = new ArrayList<Transaction>();
		
		try {
			txns = getTransactionsByAcctNumsService.process(acctNumsList.get(0));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        return txns;
    }
	
}
