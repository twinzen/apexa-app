package com.twinzom.apexa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.twinzom.apexa.dao.po.AccountPo;
import com.twinzom.apexa.dao.po.TransactionPo;
import com.twinzom.apexa.dao.rowmapper.AccountRowmapper;
import com.twinzom.apexa.dao.rowmapper.TransactionRowmapper;

@Component
public class TransactionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String GET_TXNS_BY_ACCT_IDS = "select * from txn_mast where acid in ( :acids )";

	
	public List<TransactionPo> getTxnsByAcctIds (List<Long> acids) {

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());

		if (acids == null || acids.size() <= 0) 
			return null;
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("acids", acids);
		
		List<TransactionPo> transactions = namedParameterJdbcTemplate.query(GET_TXNS_BY_ACCT_IDS,
				namedParameters,
				new TransactionRowmapper());
		
		return transactions;
	}
	
}
