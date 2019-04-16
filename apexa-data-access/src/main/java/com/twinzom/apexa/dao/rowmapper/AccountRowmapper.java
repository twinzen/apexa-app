package com.twinzom.apexa.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.twinzom.apexa.dao.po.AccountPo;

public class AccountRowmapper implements RowMapper<AccountPo> {

	public AccountPo mapRow(ResultSet rs, int rowNum) throws SQLException {
        AccountPo account = new AccountPo();
        
        account.setAcid(rs.getLong("acid"));
        account.setAcctNum(rs.getString("acno"));
        account.setAcctMethod(rs.getString("acct_mthd"));
        account.setStartDate(rs.getDate("strt_dt_tm"));
        account.setTerminationDate(rs.getDate("term_dt_tm"));
        
        return account;
        
    }
	
}
