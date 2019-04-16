package com.twinzom.apexa.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.twinzom.apexa.dao.po.SecurityPo;
import com.twinzom.apexa.dao.po.TransactionPo;

public class SecurityRowmapper implements RowMapper<SecurityPo> {

	public SecurityPo mapRow(ResultSet rs, int rowNum) throws SQLException {
		SecurityPo s = new SecurityPo();
        
		s.setSecid(rs.getLong("secid"));
		s.setSecCde(rs.getString("secCde"));
		s.setName(rs.getString("name"));
		s.setCcy(rs.getString("ccy"));
		s.setRiskLvl(rs.getInt("risk_lvl"));
		s.setStdDv(rs.getDouble("devi"));
		s.setAnnRtrn(rs.getDouble("ann_rtrn"));
		s.setSharpe(rs.getDouble("sharpe"));
		s.setNavPrc(rs.getDouble("nav_prc"));
		s.setBidPrc(rs.getDouble("bid_prc"));
		s.setOffPrc(rs.getDouble("off_prc"));
		s.setMin52Prc(rs.getDouble("min_52_prc"));
		s.setMax52Prc(rs.getDouble("max_52_prc"));
		s.setPrcDt(rs.getDate("prc_dt"));
		s.setStatcDt(rs.getDate("statc_dt"));
		s.setStatCde(rs.getString("stat_cde"));
		s.setFundHse(rs.getString("fund_hse"));
		
        return s;
        
    }
	
}
